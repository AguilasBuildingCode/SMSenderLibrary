package com.apisap.smsender.states

import com.apisap.smsender.countries.CountriesCodes

data class SMSData(
    val countryCode: CountriesCodes,
    val number: String,
    val message: String,
    val multiPartSMS: ArrayList<String> = arrayListOf(),
    var attemptCounter: Int = 0,
)