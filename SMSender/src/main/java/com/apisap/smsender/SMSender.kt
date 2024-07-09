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
import com.apisap.smsender.states.SMSData
import com.apisap.smsender.states.SMStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.UUID

private const val SMS_SEND_ACTION: String = "SMS_SEND_ACTION"
private const val SMS_DELIVERED_ACTION: String = "SMS_DELIVERED_ACTION"
private const val SMS_ID_INTENT_EXTRA: String = "SMS_ID_INTENT_EXTRA"
private const val SMS_PART_NUMBER_INTENT_EXTRA: String = "SMS_PART_INTENT_EXTRA"
private const val SMS_TOTAL_PARTS_INTENT_EXTRA: String = "SMS_TOTAL_PARTS_INTENT_EXTRA"
private const val SMS_ATTEMPT_COUNTER_INTENT_EXTRA: String = "SMS_TRY_COUNTER_INTENT_EXTRA"

open class SMSender(private val context: Context) {

    private var job: Job? = null
    private var isSenderRunning: Boolean = false
    private var isSendingSMS: Boolean = false
    private val coroutineScope by lazy { CoroutineScope(Job() + Dispatchers.IO) }
    private val smsManager: SmsManager by lazy { context.getSystemService(SmsManager::class.java) }
    private val smsData: MutableMap<String, SMSData> = mutableMapOf()
    private val smsStack: MutableList<String> = mutableListOf()

    private var policy: SMSenderPolicy = SMSenderPolicy()

    private var smsStatusChangedCallback: ((smsId: String, partNumber: Int, totalParts: Int, newState: SMStatus) -> Unit)? =
        null

    private val sentBroadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent?.let { safeIntent ->
                safeIntent.getStringExtra(SMS_ID_INTENT_EXTRA)?.let { smsId ->
                    val attemptCounter = safeIntent.getIntExtra(SMS_ATTEMPT_COUNTER_INTENT_EXTRA, 0)
                    val partNumber = safeIntent.getIntExtra(SMS_PART_NUMBER_INTENT_EXTRA, 0)
                    val totalParts = safeIntent.getIntExtra(SMS_TOTAL_PARTS_INTENT_EXTRA, 0)
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
                                smsData.remove(smsId)
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
                            smsData[smsId]?.attemptCounter = attemptCounter + 1
                            smsStack.add(0, smsId)
                        }
                    }
                    if (totalParts <= (partNumber + 1)) {
                        isSendingSMS = false
                        this@SMSender.context.unregisterReceiver(this)
                    }
                }
            }
        }
    }

    private val deliveredBroadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent?.let { safeIntent ->
                safeIntent.getStringExtra(SMS_ID_INTENT_EXTRA)?.let { smsId ->
                    val attemptCounter = safeIntent.getIntExtra(SMS_ATTEMPT_COUNTER_INTENT_EXTRA, 0)
                    val partNumber = safeIntent.getIntExtra(SMS_PART_NUMBER_INTENT_EXTRA, 0)
                    val totalParts = safeIntent.getIntExtra(SMS_TOTAL_PARTS_INTENT_EXTRA, 0)
                    when (resultCode) {
                        AppCompatActivity.RESULT_OK -> {
                            smsData.remove(smsId)
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
                                smsData.remove(smsId)
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
                            smsData[smsId]?.attemptCounter = attemptCounter + 1
                            smsStack.add(0, smsId)
                        }
                    }
                    if (totalParts <= (partNumber + 1)) {
                        isSendingSMS = false
                        this@SMSender.context.unregisterReceiver(this)
                    }
                }
            }
        }
    }

    fun setPolicy(policy: SMSenderPolicy) {
        this.policy = policy
    }

    fun setOnSMStatusChanged(smsStatusChangedCallback: (smsId: String, partNumber: Int, totalParts: Int, newState: SMStatus) -> Unit) {
        this.smsStatusChangedCallback = smsStatusChangedCallback
    }

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
                    putExtra(SMS_PART_NUMBER_INTENT_EXTRA, index)
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

    private fun registerSendReceiver(smsData: String): String {
        val smsSendAction = "$SMS_SEND_ACTION-$smsData"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.registerReceiver(
                sentBroadcastReceiver, IntentFilter(smsSendAction),
                Context.RECEIVER_EXPORTED
            )
            return smsSendAction
        }
        context.registerReceiver(
            sentBroadcastReceiver, IntentFilter(smsSendAction)
        )
        return smsSendAction
    }

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
                    putExtra(SMS_PART_NUMBER_INTENT_EXTRA, index)
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

    fun startSender() {
        isSenderRunning = true
        job = coroutineScope.launch {
            while (isSenderRunning) {
                if (smsStack.isNotEmpty() and !isSendingSMS) {
                    isSendingSMS = true
                    val smsId = smsStack.removeFirst()
                    smsData[smsId]?.let { (countryCode, number, message, multiPartSMS, attemptCounter): SMSData ->
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

    fun sendSMS(
        countryCode: CountriesCodes,
        number: String,
        message: String,
    ): String {
        val uuid: String = UUID.randomUUID().toString()
        try {
            smsData[uuid] = SMSData(
                countryCode = countryCode,
                number = number,
                message = message,
                multiPartSMS = smsManager.divideMessage(message)
            )
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
        smsStack.add(uuid)
        return uuid
    }

    fun sendSMS(
        countryCode: CountriesCodes,
        number: String,
        messages: List<String>,
    ): List<String> {
        return messages.map { message -> sendSMS(countryCode, number, message) }
    }

    fun stopSender() {
        isSenderRunning = false
        job?.cancel()
    }
}