package com.apisap.smsender.states

/**
 * [SMStatus] define the possible SMS Status.
 *
 * @param [refCode][Int] this code is provided by BroadcastReceiver.
 */
enum class SMStatus(var refCode: Int) {
    /**
     * [FAIL] if SMS is failed
     */
    FAIL(refCode = 0),

    /**
     * [SEND] if SMS is send
     */
    SEND(refCode = -1),

    /**
     * [DELIVERED] if SMS is delivered
     */
    DELIVERED(refCode = -1);

    /**
     * [setRefCode] used to change default [refCode] value, usually is used in [FAIL] cases.
     */
    fun setRefCode(refCode: Int): SMStatus {
        this.refCode = refCode
        return this
    }
}