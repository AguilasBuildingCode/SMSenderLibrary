package com.apisap.smsenderlibrary

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.apisap.smsender.SMSender
import com.apisap.smsender.countries.CountriesCodes
import com.apisap.smsenderlibrary.ui.SMSenderLibraryUi
import com.apisap.smsenderlibrary.ui.theme.SMSenderLibraryTheme

private val TAG = MainActivity::class.simpleName

class MainActivity : ComponentActivity() {

    private val smsSender by lazy { SMSender(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SMSenderLibraryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SMSenderLibraryUi(
                        modifier = Modifier.padding(innerPadding),
                        onSendSMSBtnClick = { telephone, message ->
                            val smsId = smsSender.sendSMS(
                                CountriesCodes.MX,
                                telephone,
                                message
                            )
                            Log.i(TAG, "New SMS created: $smsId")
                        }
                    )
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

        smsSender.setOnSMStatusChanged { smsId, partNumber, newState ->
            Log.i(TAG, "SMS: $smsId Part: $partNumber Status: ${newState.name}")
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