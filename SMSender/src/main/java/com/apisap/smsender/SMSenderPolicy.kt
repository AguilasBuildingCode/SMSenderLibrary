package com.apisap.smsender

data class SMSenderPolicy(var delayInterval: Long = 5000, var maxAttempts: Int = 3)