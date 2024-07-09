package com.apisap.smsender.policies

/**
 * [SMSenderPolicy] used to define [delayInterval] and [maxAttempts].
 *
 * @property [delayInterval][Long] time in milliseconds.
 * @property [maxAttempts][Int] number of attempts per each SMS.
 *
 */
data class SMSenderPolicy(var delayInterval: Long = 5000, var maxAttempts: Int = 3)