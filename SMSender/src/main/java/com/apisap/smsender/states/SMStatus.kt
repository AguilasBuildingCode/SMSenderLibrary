package com.apisap.smsender.states

enum class SMStatus(var refCode: Int) {
    FAIL(refCode = 0),
    SEND(refCode = -1),
    DELIVERED(refCode = -1);

    fun setRefCode(refCode: Int): SMStatus {
        this.refCode = refCode
        return this
    }
}