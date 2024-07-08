package com.apisap.smsenderlibrary.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apisap.smsenderlibrary.R
import com.apisap.smsenderlibrary.ui.theme.SMSenderLibraryTheme

@Composable
fun SMSenderLibraryUi(
    modifier: Modifier = Modifier,
    isSendingSMS: Boolean,
    onSendSMSBtnClick: (telephone: String, message: String) -> Unit
) {
    var textFieldNumber by remember { mutableStateOf("") }
    var textFieldMessage by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentHeight(align = Alignment.CenterVertically)
            .padding(top = 128.dp)
    ) {
        Row {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.app_name),
                style = TextStyle(
                    fontSize = 22.sp
                )
            )
        }
        Row {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                enabled = !isSendingSMS,
                label = { Text(text = "Telephone") },
                value = textFieldNumber,
                onValueChange = { newTextField: String ->
                    if (newTextField.isNotEmpty() && newTextField.length <= 10 && newTextField.matches(
                            Regex("^\\d+\$")
                        )
                    ) {
                        textFieldNumber = newTextField
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )
        }
        Row {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                enabled = !isSendingSMS,
                label = { Text(text = "Message") },
                value = textFieldMessage,
                onValueChange = { newTextField: String ->
                    textFieldMessage = newTextField
                })
        }
        Row(modifier = Modifier.fillMaxHeight()) {
            TextButton(modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
                enabled = !isSendingSMS && textFieldNumber.length >= 10 && textFieldMessage.isNotEmpty(),
                onClick = { onSendSMSBtnClick(textFieldNumber, textFieldMessage) }) {
                Text(text = "Send SMS")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SMSenderLibraryTheme {
        SMSenderLibraryUi(
            modifier = Modifier.padding(
                start = 0.0.dp,
                top = 23.466667.dp,
                end = 0.0.dp,
                bottom = 14.933333.dp
            ),
            isSendingSMS = false,
            onSendSMSBtnClick = { _, _ -> }
        )
    }
}