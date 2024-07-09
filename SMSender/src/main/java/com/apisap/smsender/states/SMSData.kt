package com.apisap.smsender.states

import com.apisap.smsender.countries.CountriesCodes

/**
 * [SMSData] used to wrap SMS data.
 *
 * @property [countryCode][CountriesCodes] define Country Code (XX) to send SMS.
 * @property [number][String] define phone number.
 * @property [message][String] define message to send.
 * @property [multiPartSMS][ArrayList] if message it's too long, it will divide in parts.
 * @property [attemptCounter][Int] define number of send attempts.
 *
 */
data class SMSData(
    val countryCode: CountriesCodes,
    val number: String,
    val message: String,
    val multiPartSMS: ArrayList<String> = arrayListOf(),
    var attemptCounter: Int = 0,
)