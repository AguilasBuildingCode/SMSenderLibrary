package com.apisap.smsender

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.telephony.SmsManager
import androidx.appcompat.app.AppCompatActivity
import com.apisap.smsender.countries.CountriesCodes
import com.apisap.smsender.datas.SMSData
import com.apisap.smsender.datas.SMSInfoData
import com.apisap.smsender.interfaces.SMSInfo
import com.apisap.smsender.policies.SMSenderPolicy
import com.apisap.smsender.states.SMStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.UUID

/**
 * [SMS_SEND_ACTION] used as first part of action to register receiver and send SMS with [IntentFilter]
 * in send.
 */

private const val SMS_SEND_ACTION: String = "SMS_SEND_ACTION"

/**
 * [SMS_DELIVERED_ACTION] used as first part of action to register receiver and send SMS with [IntentFilter]
 * in delivery.
 */
private const val SMS_DELIVERED_ACTION: String = "SMS_DELIVERED_ACTION"

/**
 * [SMS_ID_INTENT_EXTRA] used as key to pass SMSId to send and delivery [BroadcastReceiver].
 */
private const val SMS_ID_INTENT_EXTRA: String = "SMS_ID_INTENT_EXTRA"

/**
 * [SMS_PART_NUMBER_INTENT_EXTRA] used as key to pass part number to send and delivery [BroadcastReceiver].
 * Apply in multi part SMS.
 */
private const val SMS_PART_NUMBER_INTENT_EXTRA: String = "SMS_PART_INTENT_EXTRA"

/**
 * [SMS_TOTAL_PARTS_INTENT_EXTRA] used as key to pass total of parts to send and delivery [BroadcastReceiver].
 * Apply in multi part SMS.
 */
private const val SMS_TOTAL_PARTS_INTENT_EXTRA: String = "SMS_TOTAL_PARTS_INTENT_EXTRA"

/**
 * [SMS_ATTEMPT_COUNTER_INTENT_EXTRA] used as key to pass attempts counter to send and delivery [BroadcastReceiver].
 * Check [SMSenderPolicy].
 */
private const val SMS_ATTEMPT_COUNTER_INTENT_EXTRA: String = "SMS_TRY_COUNTER_INTENT_EXTRA"

/**
 * [SMSender] provide the functionality to send SMS.
 *
 * @param [context][Context]
 *
 * @property [job][Job]
 * @property [isSenderRunning][Boolean]
 * @property [isSendingSMS][Boolean]
 * @property [coroutineScope][CoroutineScope]
 * @property [smsManager][SmsManager]
 * @property [smsDataRef][MutableMap]
 * @property [smsStack][MutableList]
 * @property [policy][SMSenderPolicy]
 * @property [smsStatusChangedCallback] (smsId: String, partNumber: Int, totalParts: Int, newState: SMStatus) -> Unit
 *
 */
open class SMSender(private val context: Context) {

    private var job: Job? = null
    private var isSenderRunning: Boolean = false
    private var isSendingSMS: Boolean = false
    private val coroutineScope by lazy { CoroutineScope(Job() + Dispatchers.IO) }
    private val smsManager: SmsManager by lazy { context.getSystemService(SmsManager::class.java) }
    private val smsDataRef: MutableMap<String, SMSData> = mutableMapOf()
    private val smsStack: MutableList<String> = mutableListOf()

    private var policy: SMSenderPolicy = SMSenderPolicy()

    private var smsStatusChangedCallback: ((smsId: String, partNumber: Int, totalParts: Int, newStatus: SMStatus) -> Unit)? =
        null

    /**
     * [sendBroadcastReceiver] used to ear send SMS Status.
     */
    private val sendBroadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent?.let { safeIntent ->
                safeIntent.getStringExtra(SMS_ID_INTENT_EXTRA)?.let { smsId ->
                    val attemptCounter = safeIntent.getIntExtra(SMS_ATTEMPT_COUNTER_INTENT_EXTRA, 0)
                    val partNumber = safeIntent.getIntExtra(SMS_PART_NUMBER_INTENT_EXTRA, 1)
                    val totalParts = safeIntent.getIntExtra(SMS_TOTAL_PARTS_INTENT_EXTRA, 1)
                    when (resultCode) {
                        AppCompatActivity.RESULT_OK -> {
                            this@SMSender.smsStatusChangedCallback?.let {
                                it(
                                    smsId,
                                    partNumber,
                                    totalParts,
                                    SMStatus.SEND
                                )
                            }
                        }

                        else -> {
                            if (attemptCounter >= policy.maxAttempts) {
                                smsDataRef.remove(smsId)
                                this@SMSender.smsStatusChangedCallback?.let {
                                    it(
                                        smsId,
                                        partNumber,
                                        totalParts,
                                        SMStatus.FAIL.setRefCode(refCode = resultCode)
                                    )
                                }
                                return
                            }
                            smsDataRef[smsId]?.attemptCounter = attemptCounter + 1
                            smsStack.add(0, smsId)
                        }
                    }
                    if (totalParts <= partNumber) {
                        isSendingSMS = false
                        this@SMSender.context.unregisterReceiver(this)
                    }
                }
            }
        }
    }

    /**
     * [deliveredBroadcastReceiver] used to ear delivery SMS Status.
     */
    private val deliveredBroadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent?.let { safeIntent ->
                safeIntent.getStringExtra(SMS_ID_INTENT_EXTRA)?.let { smsId ->
                    val attemptCounter = safeIntent.getIntExtra(SMS_ATTEMPT_COUNTER_INTENT_EXTRA, 0)
                    val partNumber = safeIntent.getIntExtra(SMS_PART_NUMBER_INTENT_EXTRA, 1)
                    val totalParts = safeIntent.getIntExtra(SMS_TOTAL_PARTS_INTENT_EXTRA, 1)
                    when (resultCode) {
                        AppCompatActivity.RESULT_OK -> {
                            smsDataRef.remove(smsId)
                            this@SMSender.smsStatusChangedCallback?.let {
                                it(
                                    smsId,
                                    partNumber,
                                    totalParts,
                                    SMStatus.DELIVERED
                                )
                            }
                        }

                        else -> {
                            if (attemptCounter >= policy.maxAttempts) {
                                smsDataRef.remove(smsId)
                                this@SMSender.smsStatusChangedCallback?.let {
                                    it(
                                        smsId,
                                        partNumber,
                                        totalParts,
                                        SMStatus.FAIL.setRefCode(refCode = resultCode)
                                    )
                                }
                                return
                            }
                            smsDataRef[smsId]?.attemptCounter = attemptCounter + 1
                            smsStack.add(0, smsId)
                        }
                    }
                    if (totalParts <= partNumber) {
                        isSendingSMS = false
                        this@SMSender.context.unregisterReceiver(this)
                    }
                }
            }
        }
    }

    /**
     * [setPolicy] used to change default [SMSenderPolicy], by default:
     * [SMSenderPolicy.maxAttempts] = 3
     * [SMSenderPolicy.delayInterval] = 5000
     *
     * @return [Unit]
     */
    fun setPolicy(policy: SMSenderPolicy) {
        this.policy = policy
    }

    /**
     * [onSMStatusChanged] used to set new [smsStatusChangedCallback].
     *
     * @param [smsStatusChangedCallback] (smsId: [String], partNumber: [Int], totalParts: [Int], newState: [SMStatus]) -> [Unit]
     *
     * @return [Unit]
     */
    fun onSMStatusChanged(smsStatusChangedCallback: (smsId: String, partNumber: Int, totalParts: Int, newStatus: SMStatus) -> Unit) {
        this.smsStatusChangedCallback = smsStatusChangedCallback
    }

    /**
     * [registerSendReceiver] used to register [sendBroadcastReceiver] and get all [PendingIntent]s to ear send status.
     *
     * @param [multiPartSMSSize][Int] size of [SMSData.multiPartSMS] to know number of parts to generate [PendingIntent] for
     * each part.
     * @param [smsId][String] uuid of SMS.
     * @param [attempt][Int] number of attempts.
     *
     * @return [ArrayList]<[PendingIntent]>
     */
    private fun registerSendReceiver(
        multiPartSMSSize: Int,
        smsId: String,
        attempt: Int
    ): ArrayList<PendingIntent> {
        return List(multiPartSMSSize) { index ->
            return@List PendingIntent.getBroadcast(
                context, 0,
                Intent(registerSendReceiver(smsData = "smsId-$smsId-attempt-$attempt-part-$index")).apply {
                    putExtra(SMS_ID_INTENT_EXTRA, smsId)
                    putExtra(SMS_PART_NUMBER_INTENT_EXTRA, (index + 1))
                    putExtra(
                        SMS_TOTAL_PARTS_INTENT_EXTRA,
                        multiPartSMSSize
                    )
                    putExtra(
                        SMS_ATTEMPT_COUNTER_INTENT_EXTRA,
                        attempt
                    )
                }, PendingIntent.FLAG_IMMUTABLE
            )
        } as ArrayList<PendingIntent>
    }

    /**
     * [registerSendReceiver] used to register [sendBroadcastReceiver] and get [PendingIntent] to ear send status.
     *
     * @param [smsId][String] uuid of SMS.
     * @param [attempt][Int] number of attempts.
     *
     * @return [PendingIntent]
     */
    private fun registerSendReceiver(smsId: String, attempt: Int): PendingIntent {
        return PendingIntent.getBroadcast(
            context, 0,
            Intent(registerSendReceiver(smsData = "smsId-$smsId-attempt-$attempt")).apply {
                putExtra(SMS_ID_INTENT_EXTRA, smsId)
                putExtra(
                    SMS_ATTEMPT_COUNTER_INTENT_EXTRA,
                    attempt
                )
            }, PendingIntent.FLAG_IMMUTABLE
        )
    }

    /**
     * [registerSendReceiver] used to register [sendBroadcastReceiver] and get [Intent] action.
     *
     * @param [smsData][String] data of SMS in [String] mode.
     *
     * @return action [String]
     */
    private fun registerSendReceiver(smsData: String): String {
        val smsSendAction = "$SMS_SEND_ACTION-$smsData"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.registerReceiver(
                sendBroadcastReceiver, IntentFilter(smsSendAction),
                Context.RECEIVER_EXPORTED
            )
            return smsSendAction
        }
        context.registerReceiver(
            sendBroadcastReceiver, IntentFilter(smsSendAction)
        )
        return smsSendAction
    }

    /**
     * [registerSendReceiver] used to register [deliveredBroadcastReceiver] and get all [PendingIntent]s to ear delivery status.
     *
     * @param [multiPartSMSSize][Int] size of [SMSData.multiPartSMS] to know number of parts to generate [PendingIntent] for
     * each part.
     * @param [smsId][String] uuid of SMS.
     * @param [attempt][Int] number of attempts.
     *
     * @return [ArrayList]<[PendingIntent]>
     */
    private fun registerDeliveryReceiver(
        multiPartSMSSize: Int,
        smsId: String,
        attempt: Int,
    ): ArrayList<PendingIntent> {
        return List(multiPartSMSSize) { index ->
            return@List PendingIntent.getBroadcast(
                context, 0,
                Intent(registerDeliveryReceiver(smsData = "smsId-$smsId-attempt-$attempt-part-$index")).apply {
                    putExtra(SMS_ID_INTENT_EXTRA, smsId)
                    putExtra(SMS_PART_NUMBER_INTENT_EXTRA, (index + 1))
                    putExtra(
                        SMS_TOTAL_PARTS_INTENT_EXTRA,
                        multiPartSMSSize
                    )
                    putExtra(
                        SMS_ATTEMPT_COUNTER_INTENT_EXTRA,
                        attempt
                    )
                }, PendingIntent.FLAG_IMMUTABLE
            )
        } as ArrayList<PendingIntent>
    }

    /**
     * [registerSendReceiver] used to register [deliveredBroadcastReceiver] and get [PendingIntent] to ear delivery status.
     *
     * @param [smsId][String] uuid of SMS.
     * @param [attempt][Int] number of attempts.
     *
     * @return [PendingIntent]
     */
    private fun registerDeliveryReceiver(smsId: String, attempt: Int): PendingIntent {
        return PendingIntent.getBroadcast(
            context, 0,
            Intent(registerDeliveryReceiver(smsData = "smsId-$smsId-attempt-$attempt")).apply {
                putExtra(SMS_ID_INTENT_EXTRA, smsId)
                putExtra(
                    SMS_ATTEMPT_COUNTER_INTENT_EXTRA,
                    attempt
                )
            }, PendingIntent.FLAG_IMMUTABLE
        )
    }

    /**
     * [registerDeliveryReceiver] used to register [deliveredBroadcastReceiver] and get [Intent] action.
     *
     * @param [smsData][String] data of SMS in [String] mode.
     *
     * @return action [String]
     */
    private fun registerDeliveryReceiver(smsData: String): String {
        val smsDeliveredAction = "$SMS_DELIVERED_ACTION-$smsData"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.registerReceiver(
                deliveredBroadcastReceiver, IntentFilter(smsDeliveredAction),
                Context.RECEIVER_EXPORTED
            )
            return smsDeliveredAction
        }

        context.registerReceiver(
            deliveredBroadcastReceiver, IntentFilter(smsDeliveredAction)
        )
        return smsDeliveredAction
    }

    /**
     * [startSender] used to start SMS send process.
     *
     * @return [Unit]
     */
    fun startSender() {
        isSenderRunning = true
        job = coroutineScope.launch {
            while (isSenderRunning) {
                if (smsStack.isNotEmpty() and !isSendingSMS) {
                    isSendingSMS = true
                    val smsId = smsStack[0]
                    smsStack.removeAt(0)
                    smsDataRef[smsId]?.let { (countryCode, number, message, multiPartSMS, attemptCounter): SMSData ->
                        try {
                            val destinationAddress = "+${countryCode.code}$number"
                            if (multiPartSMS.size > 1) {
                                smsManager.sendMultipartTextMessage(
                                    destinationAddress,
                                    null,
                                    multiPartSMS,
                                    registerSendReceiver(
                                        multiPartSMSSize = multiPartSMS.size,
                                        smsId = smsId,
                                        attempt = attemptCounter
                                    ),
                                    registerDeliveryReceiver(
                                        multiPartSMSSize = multiPartSMS.size,
                                        smsId = smsId,
                                        attempt = attemptCounter,
                                    )
                                )
                            } else {
                                smsManager.sendTextMessage(
                                    destinationAddress,
                                    null,
                                    message,
                                    registerSendReceiver(smsId = smsId, attempt = attemptCounter),
                                    registerDeliveryReceiver(
                                        smsId = smsId,
                                        attempt = attemptCounter
                                    )
                                )
                            }
                        } catch (e: IllegalArgumentException) {
                            e.printStackTrace()
                            isSendingSMS = false
                            smsStatusChangedCallback?.let {
                                it(
                                    smsId,
                                    -1,
                                    -1,
                                    SMStatus.FAIL.setRefCode(refCode = -1)
                                )
                            }
                        }
                    }
                }
                delay(policy.delayInterval)
            }
        }
    }

    /**
     * [sendSMS] used to send a SMS.
     *
     * @param [countryCode][CountriesCodes] define country origin by Country Code (XX)
     * @param [number][String] telephone number (10 digits)
     * @param [message][String] message to send.
     *
     * @throws IllegalArgumentException if number has more or less 10 digits.
     *
     * @return uuid: [SMSInfo]
     */
    fun sendSMS(
        countryCode: CountriesCodes,
        number: String,
        message: String,
    ): SMSInfoData {
        if (number.length != 10) {
            throw IllegalArgumentException("Param number should be 10 digits but given ${number.length} digits")
        }
        val uuid: String = UUID.randomUUID().toString()
        val smsData = SMSData(
            countryCode = countryCode,
            number = number,
            message = message,
            multiPartSMS = smsManager.divideMessage(message)
        )
        smsDataRef[uuid] = smsData
        smsStack.add(uuid)
        return SMSInfoData(
            smsId = uuid,
            smsParts = smsData.multiPartSMS.size
        )
    }

    /**
     * [sendSMS] used to send many SMSs.
     *
     * @param [countryCode][CountriesCodes] define country origin by Country Code (XX)
     * @param [number][String] telephone number (10 digits)
     * @param [messages][List]<[String]> messages to send.
     *
     * @throws IllegalArgumentException if number has more or less 10 digits.
     *
     * @return uuid: [String]
     */
    fun sendSMS(
        countryCode: CountriesCodes,
        number: String,
        messages: List<String>,
    ): List<SMSInfoData> {
        return messages.map { message -> sendSMS(countryCode, number, message) }
    }

    /**
     * [getSMSPendingToSend] used to know how many SMS are there pending to send.
     *
     * @return uuids [List]<[String]>
     */
    fun getSMSPendingToSend(): List<String> {
        return smsStack.toList()
    }

    /**
     * [stopSender] used to stop SMS send process. Could be SMS pending to send.
     *
     * @return [Unit]
     */
    fun stopSender() {
        isSenderRunning = false
        job?.cancel()
    }
}