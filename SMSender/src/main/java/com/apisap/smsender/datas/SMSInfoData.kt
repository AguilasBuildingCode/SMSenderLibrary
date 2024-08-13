package com.apisap.smsender.datas

import com.apisap.smsender.interfaces.SMSInfo

data class SMSInfoData(
    override val smsId: String, override val smsParts: Int
) : SMSInfo
