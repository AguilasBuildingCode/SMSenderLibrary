package com.apisap.smsender

data class SMSenderPolicy(var delayInterval: Long = 5000, var maxNumberOfAttempt: Int = 3)