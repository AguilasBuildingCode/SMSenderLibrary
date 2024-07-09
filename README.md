# SMSenderLibrary (V1.0.0)

## Introduction
This library expose all necessary to send SMS and get update status por each SMS.

## How to start?
Add __SEND_SMS__ Permissions into your __*AndroidManifest.xml*__
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:tools="http://schemas.android.com/tools">

    <uses-permission android:name="android.permission.SEND_SMS" />

    <application
        [...]>
        <activity
            [...]>
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

To start use it, create a new instance of __SMSender__ (see [demo](https://github.com/AguilasBuildingCode/SMSenderLibrary/blob/main/app/src/main/java/com/apisap/smsenderlibrary/MainActivity.kt)):
```
class SMSenderActivity : ComponentActivity() {

    private val smsSender by lazy { SMSender(this) }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        [...]
    }
    
    override fun onStart() {
        super.onStart()
        // Check 'Manifest.permission.SEND_SMS' permissions
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
                // You should explain user the reason to request permissions.
                requestPermissions(arrayOf(Manifest.permission.SEND_SMS), REQUEST_CODE)
            }

            else -> {
                requestPermissions(arrayOf(Manifest.permission.SEND_SMS), REQUEST_CODE)
            }
        }
    }
    
    [...]
    
    override fun onStop() {
        super.onStop()
        smsSender.stopSender()
    }
}
```

| Methods             | Params                                                             | Description                                                              |
|---------------------|--------------------------------------------------------------------|--------------------------------------------------------------------------|
| setPolicy           | SMSenderPolicy                                                     | Used to change default Policy                                            |
| onSMStatusChanged   | smsStatusChangedCallback                                           | Used to get updates of SMSs                                              |
| startSender         | N/A                                                                | Used to start to send SMSs                                               |
| sendSMS             | countryCode: CountriesCodes, number: String, message: String       | Used to add a SMS pending to send (return uuid to identify SMS)          |
| sendSMS             | countryCode: CountriesCodes, number: String, message: List<String> | Used to add many SMS pending to send (return uuid list to identify SMSs) |
| getSMSPendingToSend | N/A                                                                | Used to get SMSs list pending to send                                    |
| stopSender          | N/A                                                                | Used to stop SMSs sending process                                        |

### Warning
If you stop SMSs sender, check if there aren't SMS pending to send.

## SMSenderPolicy
| Policy        | Used to                              |
|---------------|--------------------------------------|
| delayInterval | Delay each SMS send                  |
| maxAttempts   | Define maximum attempts for each SMS |

## smsStatusChangedCallback
| Params     | Type     | Description                                                                   |
|------------|----------|-------------------------------------------------------------------------------|
| smsId      | String   | UUID to identify SMS (assigned by "__sendSMS__" method).                      |
| partNumber | Int      | If the message given is too long, it was divide in parts, each part is a SMS. |
| totalParts | Int      | Number of total parts, if values is '0', meaning that was send in one SMS.    |
| newStatus  | SMStatus | Define the new status of SMS.                                                 |

| SMStatus           | Meaning           |
|--------------------|-------------------|
| SMStatus.FAIL      | SMS can't be send |
| SMStatus.SEND      | SMS was send      |
| SMStatus.DELIVERED | SMS was delivered |

### Example:
```
smsSender.onSMStatusChanged { smsId, partNumber, totalParts, newStatus ->
    if (totalParts <= (partNumber + 1)) {
        when (newStatus) {
            SMStatus.SEND -> //ToDo Handle SEND case
            SMStatus.FAIL -> //ToDo Handle FAIL case
            SMStatus.DELIVERED -> //ToDo Handle DELIVERED case
        }
    }
}
```