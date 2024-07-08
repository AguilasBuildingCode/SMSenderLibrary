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
private const val SMS_ATTEMPT_COUNTER_INTENT_EXTRA: String = "SMS_TRY_COUNTER_INTENT_EXTRA"

open class SMSender(private val context: Context) {

    private var job: Job? = null
    private var isSenderRunning: Boolean = false
    private val coroutineScope by lazy { CoroutineScope(Job() + Dispatchers.IO) }
    private val smsManager: SmsManager by lazy { context.getSystemService(SmsManager::class.java) }
    private val smsData: MutableMap<String, SMSData> = mutableMapOf()
    private val smsStack: MutableList<String> = mutableListOf()

    private var policy: SMSenderPolicy = SMSenderPolicy()

    private var smsStatusChangedCallback: ((smsId: String, partNumber: Int, newState: SMStatus) -> Unit)? =
        null

    private val sentBroadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent?.let { safeIntent ->
                safeIntent.getStringExtra(SMS_ID_INTENT_EXTRA)?.let { smsId ->
                    val attemptCounter = safeIntent.getIntExtra(SMS_ATTEMPT_COUNTER_INTENT_EXTRA, 0)
                    val partNumber = safeIntent.getIntExtra(SMS_PART_NUMBER_INTENT_EXTRA, 0)
                    when (resultCode) {
                        AppCompatActivity.RESULT_OK -> {
                            this@SMSender.smsStatusChangedCallback?.let {
                                it(
                                    smsId,
                                    partNumber,
                                    SMStatus.SEND
                                )
                            }
                        }

                        else -> {
                            if (attemptCounter >= policy.maxNumberOfAttempt) {
                                smsData.remove(smsId)
                                this@SMSender.smsStatusChangedCallback?.let {
                                    it(
                                        smsId,
                                        partNumber,
                                        SMStatus.FAIL.setRefCode(refCode = resultCode)
                                    )
                                }
                                return
                            }
                            smsData[smsId]?.attemptCounter = attemptCounter + 1
                            smsStack.add(0, smsId)
                        }
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
                    when (resultCode) {
                        AppCompatActivity.RESULT_OK -> {
                            smsData.remove(smsId)
                            this@SMSender.smsStatusChangedCallback?.let {
                                it(
                                    smsId,
                                    partNumber,
                                    SMStatus.DELIVERED
                                )
                            }
                        }

                        else -> {
                            if (attemptCounter >= policy.maxNumberOfAttempt) {
                                smsData.remove(smsId)
                                this@SMSender.smsStatusChangedCallback?.let {
                                    it(
                                        smsId,
                                        partNumber,
                                        SMStatus.FAIL.setRefCode(refCode = resultCode)
                                    )
                                }
                                return
                            }
                            smsData[smsId]?.attemptCounter = attemptCounter + 1
                            smsStack.add(0, smsId)
                        }
                    }
                }
            }
        }
    }

    fun setPolicy(policy: SMSenderPolicy) {
        this.policy = policy
    }

    fun setOnSMStatusChanged(smsStatusChangedCallback: (smsId: String, partNumber: Int, newState: SMStatus) -> Unit) {
        this.smsStatusChangedCallback = smsStatusChangedCallback
    }

    private fun registerReceiver(smsId: String) {
        val smsSendAction = "$SMS_SEND_ACTION-$smsId"
        val smsDeliveredAction = "$SMS_DELIVERED_ACTION-$smsId"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.registerReceiver(
                sentBroadcastReceiver, IntentFilter(smsSendAction),
                Context.RECEIVER_EXPORTED
            )

            context.registerReceiver(
                deliveredBroadcastReceiver, IntentFilter(smsDeliveredAction),
                Context.RECEIVER_EXPORTED
            )
            return
        }
        context.registerReceiver(
            sentBroadcastReceiver, IntentFilter(smsSendAction)
        )

        context.registerReceiver(
            deliveredBroadcastReceiver, IntentFilter(smsDeliveredAction)
        )
    }

    fun startSender() {
        isSenderRunning = true
        job = coroutineScope.launch {
            while (isSenderRunning) {
                if (smsStack.isNotEmpty()) {
                    val smsId = smsStack.removeFirst()
                    smsData[smsId]?.let { (countryCode, number, message, multiPartSMS, attemptCounter): SMSData ->
                        try {
                            val destinationAddress = "+${countryCode.code}$number"
                            if (multiPartSMS.size > 1) {
                                smsManager.sendMultipartTextMessage(
                                    destinationAddress,
                                    null,
                                    multiPartSMS as ArrayList<String>?,
                                    List(multiPartSMS.size) { index ->
                                        val smsAction = "$smsId-attempt-$attemptCounter-i-$index"
                                        registerReceiver(smsId = smsAction)
                                        return@List PendingIntent.getBroadcast(
                                            context, 0,
                                            Intent("$SMS_SEND_ACTION-$smsAction").apply {
                                                putExtra(SMS_ID_INTENT_EXTRA, smsId)
                                                putExtra(SMS_PART_NUMBER_INTENT_EXTRA, index)
                                                putExtra(SMS_ATTEMPT_COUNTER_INTENT_EXTRA, attemptCounter)
                                            }, PendingIntent.FLAG_IMMUTABLE
                                        )
                                    } as ArrayList<PendingIntent>?,
                                    List(multiPartSMS.size) { index ->
                                        val smsAction = "$smsId-attempt-$attemptCounter-i-$index"
                                        return@List PendingIntent.getBroadcast(
                                            context, 0,
                                            Intent("$SMS_DELIVERED_ACTION-$smsAction").apply {
                                                putExtra(SMS_ID_INTENT_EXTRA, smsId)
                                                putExtra(SMS_PART_NUMBER_INTENT_EXTRA, index)
                                                putExtra(SMS_ATTEMPT_COUNTER_INTENT_EXTRA, attemptCounter)
                                            }, PendingIntent.FLAG_IMMUTABLE
                                        )
                                    } as ArrayList<PendingIntent>?
                                )
                            } else {
                                val smsAction = "$smsId-attempt-$attemptCounter"
                                registerReceiver(smsId = smsAction)
                                smsManager.sendTextMessage(
                                    destinationAddress,
                                    null,
                                    message,
                                    PendingIntent.getBroadcast(
                                        context, 0,
                                        Intent("$SMS_SEND_ACTION-$smsAction").apply {
                                            putExtra(SMS_ID_INTENT_EXTRA, smsId)
                                            putExtra(SMS_ATTEMPT_COUNTER_INTENT_EXTRA, attemptCounter)
                                        }, PendingIntent.FLAG_IMMUTABLE
                                    ),
                                    PendingIntent.getBroadcast(
                                        context, 0,
                                        Intent("$SMS_DELIVERED_ACTION-$smsAction").apply {
                                            putExtra(SMS_ID_INTENT_EXTRA, smsId)
                                            putExtra(SMS_ATTEMPT_COUNTER_INTENT_EXTRA, attemptCounter)
                                        }, PendingIntent.FLAG_IMMUTABLE
                                    )
                                )
                            }
                        } catch (e: IllegalArgumentException) {
                            e.printStackTrace()
                            smsStatusChangedCallback?.let {
                                it(
                                    smsId,
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

    fun stopSender() {
        isSenderRunning = false
        job?.cancel()
        context.unregisterReceiver(sentBroadcastReceiver)
        context.unregisterReceiver(deliveredBroadcastReceiver)
    }
}