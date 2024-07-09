package com.apisap.smsenderlibrary

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.apisap.smsender.SMSender
import com.apisap.smsender.countries.CountriesCodes
import com.apisap.smsender.states.SMStatus
import com.apisap.smsenderlibrary.ui.SMSenderLibraryUi
import com.apisap.smsenderlibrary.ui.theme.SMSenderLibraryTheme
import com.apisap.smsenderlibrary.viewmodel.SMSenderActivityViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

private val TAG = SMSenderActivity::class.simpleName

class SMSenderActivity : ComponentActivity() {

    private val viewModel by viewModels<SMSenderActivityViewModel>()
    private val smsSender by lazy { SMSender(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.smsSenderUiState.collectLatest { (isSendingSMS) ->
                    setContent {
                        SMSenderLibraryTheme {
                            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                                SMSenderLibraryUi(
                                    modifier = Modifier.padding(innerPadding),
                                    isSendingSMS = isSendingSMS,
                                    onSendSMSBtnClick = { telephone, message ->
                                        lifecycleScope.launch {
                                            viewModel.disableSendSMSBtn().await()
                                            delay(1000)
                                            val smsId = smsSender.sendSMS(
                                                CountriesCodes.MX,
                                                telephone,
                                                message
                                            )
                                            Log.i("** $TAG", "New SMS created: $smsId")
                                            Toast.makeText(
                                                this@SMSenderActivity,
                                                "New SMS created: $smsId",
                                                Toast.LENGTH_LONG
                                            ).show()
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.SEND_SMS
            ) == PackageManager.PERMISSION_GRANTED -> {
                smsSender.startSender()
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this, Manifest.permission.SEND_SMS
            ) -> {
                requestPermissions(arrayOf(Manifest.permission.SEND_SMS), 1)
            }

            else -> {
                requestPermissions(arrayOf(Manifest.permission.SEND_SMS), 1)
            }
        }

        smsSender.onSMStatusChanged { smsId, partNumber, totalParts, newState ->
            lifecycleScope.launch {
                if (totalParts <= (partNumber + 1)) {
                    when (newState) {
                        SMStatus.SEND -> {}
                        SMStatus.FAIL -> viewModel.enableSendSMSBtn().await()
                        SMStatus.DELIVERED -> viewModel.enableSendSMSBtn().await()
                    }
                    Toast.makeText(
                        this@SMSenderActivity,
                        "SMS: $smsId Status: ${newState.name}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            Log.i(
                "** $TAG",
                "SMS: $smsId Part: $partNumber Total Parts: $totalParts Status: ${newState.name}"
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            permissions.forEachIndexed { index, permission ->
                when (permission) {
                    Manifest.permission.SEND_SMS -> {
                        if (grantResults[index] == PackageManager.PERMISSION_GRANTED) {
                            smsSender.startSender()
                        }
                    }
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        smsSender.stopSender()
    }
}