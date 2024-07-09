package com.apisap.smsenderlibrary.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apisap.smsenderlibrary.ui.state.SMSenderUiState
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SMSenderActivityViewModel : ViewModel(), DefaultLifecycleObserver {
    private val _smsSenderUiState: MutableStateFlow<SMSenderUiState> =
        MutableStateFlow(SMSenderUiState())
    val smsSenderUiState: StateFlow<SMSenderUiState> = _smsSenderUiState.asStateFlow()

    fun disableSendSMSBtn(): Deferred<Unit> {
        return viewModelScope.async {
            _smsSenderUiState.update { currentState ->
                currentState.copy(isSendingSMS = true)
            }
        }
    }

    fun enableSendSMSBtn(): Deferred<Unit> {
        return viewModelScope.async {
            _smsSenderUiState.update { currentState ->
                currentState.copy(isSendingSMS = false)
            }
        }
    }
}