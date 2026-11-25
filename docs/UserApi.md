# UserApi

All URIs are relative to *https://api.torbox.app*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**addReferralToAccount**](UserApi.md#addReferralToAccount) | **POST** /v1/api/user/addreferral | Add Referral To Account |
| [**deleteAccount**](UserApi.md#deleteAccount) | **DELETE** /v1/api/user/deleteme | Delete Account |
| [**editUserSettings**](UserApi.md#editUserSettings) | **PUT** /v1/api/user/settings/editsettings | Edit User Settings |
| [**getConfirmationCode**](UserApi.md#getConfirmationCode) | **GET** /v1/api/user/getconfirmation | Get Confirmation Code |
| [**getReferralData**](UserApi.md#getReferralData) | **GET** /v1/api/user/referraldata | Get Referral Data |
| [**getSubscriptions**](UserApi.md#getSubscriptions) | **GET** /v1/api/user/subscriptions | Get Subscriptions |
| [**getTokenFromDeviceCodeProcess**](UserApi.md#getTokenFromDeviceCodeProcess) | **POST** /v1/api/user/auth/device/token | Get Token From Device Code Process |
| [**getTransactionPdf**](UserApi.md#getTransactionPdf) | **GET** /v1/api/user/transaction/pdf | Get Transaction PDF |
| [**getTransactions**](UserApi.md#getTransactions) | **GET** /v1/api/user/transactions | Get Transactions |
| [**getUserData**](UserApi.md#getUserData) | **GET** /v1/api/user/me | Get User Data |
| [**getUserStats**](UserApi.md#getUserStats) | **GET** /v1/api/user/stats | Get User Stats |
| [**refreshApiToken**](UserApi.md#refreshApiToken) | **POST** /v1/api/user/refreshtoken | Refresh API Token |
| [**startDeviceCodeAuthorizationProcess**](UserApi.md#startDeviceCodeAuthorizationProcess) | **GET** /v1/api/user/auth/device/start | Start Device Code Authorization Process |


<a id="addReferralToAccount"></a>
# **addReferralToAccount**
> AddReferralToAccountResponse addReferralToAccount(referral)

Add Referral To Account

### Overview  Automatically adds a referral code to the user&#39;s account. This can be used for developers to automatically add their referral to user&#39;s accounts who use their service.  This will not override any referral a user already has. If they already have one, then it cannot be changed using this endpoint. It can only be done by the user on the [website](https://torbox.app/subscription).  ### Authorization  Requires an API key using the Authorization Bearer Header. Use the user&#39;s API key, not your own. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UserApi()
val referral : kotlin.String = referral_example // kotlin.String | A referral code. Must be UUID.
try {
    val result : AddReferralToAccountResponse = apiInstance.addReferralToAccount(referral)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#addReferralToAccount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#addReferralToAccount")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **referral** | **kotlin.String**| A referral code. Must be UUID. | |

### Return type

[**AddReferralToAccountResponse**](AddReferralToAccountResponse.md)

### Authorization


Configure ApiKey statically:
```kotlin
ApiClient.accessToken = ""
```
Configure ApiKey dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="deleteAccount"></a>
# **deleteAccount**
> DeleteAccountResponse deleteAccount(deleteAccountSchema)

Delete Account

### Overview  Permanently deletes the user&#39;s TorBox account. This cannot be undone.  Because of how dangerous this action is, it needs two things on top of the API key: the user&#39;s session token from the website, and a confirmation code, which is sent to the user&#39;s email by the Get Confirmation Code endpoint.  ### Authorization  Requires an API key using the Authorization Bearer Header, as well as the session token and the confirmation code in the body. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UserApi()
val deleteAccountSchema : DeleteAccountSchema = {"session_token":"string","confirmation_code":123456} // DeleteAccountSchema | 
try {
    val result : DeleteAccountResponse = apiInstance.deleteAccount(deleteAccountSchema)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#deleteAccount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#deleteAccount")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **deleteAccountSchema** | [**DeleteAccountSchema**](DeleteAccountSchema.md)|  | |

### Return type

[**DeleteAccountResponse**](DeleteAccountResponse.md)

### Authorization


Configure ApiKey statically:
```kotlin
ApiClient.accessToken = ""
```
Configure ApiKey dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="editUserSettings"></a>
# **editUserSettings**
> EditUserSettingsResponse editUserSettings(baseSettingsModel)

Edit User Settings

### Overview  Edits a user&#39;s TorBox settings. These values take effect immediately. Please view the body to read about allowed options and parameters.  To get the user settings, simply use the \&quot;[Get User Data](https://api.torbox.app/docs#/User/get_user_data)\&quot; endpoint, while sending the \&quot;?settings&#x3D;true\&quot; parameter  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UserApi()
val baseSettingsModel : BaseSettingsModel = {"email_notifications":true,"web_notifications":true,"mobile_notifications":true,"rss_notifications":true,"download_speed_in_tab":true,"stremio_quality":[0,1,2,3,4,5,6,7,8,9,10,11],"stremio_resolution":[0,1,2,3],"stremio_language":[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21],"stremio_cache":[1,2,3],"stremio_size_lower":0,"google_drive_folder_id":"string","onedrive_save_path":"string","discord_id":"string","discord_notifications":true,"stremio_allow_adult":true,"stremio_seed_torrents":1,"seed_torrents":1,"allow_zipped":true,"stremio_allow_zipped":true,"onefichier_folder_id":"string","gofile_folder_id":"string","webhook_notifications":true,"webhook_url":"https://example.com/webhook","telegram_notifications":true,"telegram_id":"string","mega_email":"string","mega_password":"string","stremio_sort":"seeders","cdn_selection":"string","stremio_use_custom_search_engines":true,"stremio_result_sort":"torrent","webdav_use_local_files":true,"stremio_legacy_your_media":true,"stremio_only_your_media_streams":true,"stremio_disable_your_media_streams":true,"webdav_use_folder_view":true,"webdav_flatten":true,"stremio_limit_per_resolution_torrent":0,"stremio_limit_per_resolution_usenet":0,"stremio_size_upper":0,"stremio_torrent_seeders_cutoff":0,"pixeldrain_api_key":"string","onefichier_api_key":"string","gofile_api_key":"string","patreon_id":"string","stremio_wait_for_download_usenet":true,"stremio_wait_for_download_torrent":true,"stremio_disable_filtered_note":true,"stremio_emoji_in_description":true,"dashboard_filter":{"torrents":false,"usenet_downloads":false,"web_downloads":false,"active":false,"inactive":false,"queued":false,"downloading":false,"uploading":false,"processing":false,"download_ready":false,"cached":false,"uncached":false,"private":false,"borrowed":false},"web_player_always_transcode":true,"web_player_always_skip_intro":true,"web_player_audio_preferred_language":"string","web_player_subtitle_preferred_language":"string","web_player_disable_prestream_selector":true,"dashboard_sort":"default","web_player_disable_next_up_dialogue":true,"web_player_enable_scrobbling":true,"append_filename_to_links":true} // BaseSettingsModel | 
try {
    val result : EditUserSettingsResponse = apiInstance.editUserSettings(baseSettingsModel)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#editUserSettings")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#editUserSettings")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **baseSettingsModel** | [**BaseSettingsModel**](BaseSettingsModel.md)|  | |

### Return type

[**EditUserSettingsResponse**](EditUserSettingsResponse.md)

### Authorization


Configure ApiKey statically:
```kotlin
ApiClient.accessToken = ""
```
Configure ApiKey dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="getConfirmationCode"></a>
# **getConfirmationCode**
> GetConfirmationCodeResponse getConfirmationCode()

Get Confirmation Code

### Overview  Requests a 6 digit code to be sent to the user&#39;s email for verification. Used to verify a user actually wants to perform a potentially dangerous action.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UserApi()
try {
    val result : GetConfirmationCodeResponse = apiInstance.getConfirmationCode()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#getConfirmationCode")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getConfirmationCode")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetConfirmationCodeResponse**](GetConfirmationCodeResponse.md)

### Authorization


Configure ApiKey statically:
```kotlin
ApiClient.accessToken = ""
```
Configure ApiKey dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getReferralData"></a>
# **getReferralData**
> GetReferralDataResponse getReferralData()

Get Referral Data

### Overview  Use this endpoint to get the user&#39;s referral data. This includes information such as how many referrals they have made, and their referral code.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UserApi()
try {
    val result : GetReferralDataResponse = apiInstance.getReferralData()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#getReferralData")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getReferralData")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetReferralDataResponse**](GetReferralDataResponse.md)

### Authorization


Configure ApiKey statically:
```kotlin
ApiClient.accessToken = ""
```
Configure ApiKey dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getSubscriptions"></a>
# **getSubscriptions**
> GetSubscriptionsResponse getSubscriptions()

Get Subscriptions

### Overview  Gets a users subscriptions. This includes active and inactive subscriptions for all payment processors.  It should be noted that \&quot;plan_code\&quot; is not normalized to the standard plan codes such as 1, 2, or 3. These \&quot;plan_code\&quot;s are payment processor specific and used internally. If you want to display these subscriptions, use the \&quot;plan_name\&quot;.  For displaying information to users, use the \&quot;status\&quot;, \&quot;gateway\&quot;, and \&quot;plan_name\&quot;. No other information is relevant to the user, and the rest is used for TorBox internally.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UserApi()
try {
    val result : GetSubscriptionsResponse = apiInstance.getSubscriptions()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#getSubscriptions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getSubscriptions")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetSubscriptionsResponse**](GetSubscriptionsResponse.md)

### Authorization


Configure ApiKey statically:
```kotlin
ApiClient.accessToken = ""
```
Configure ApiKey dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTokenFromDeviceCodeProcess"></a>
# **getTokenFromDeviceCodeProcess**
> GetTokenFromDeviceCodeProcessResponse getTokenFromDeviceCodeProcess(deviceTokenSchema)

Get Token From Device Code Process

### Overview  Gets the user&#39;s API token from the device code authorization process. This endpoint is expected to be polled in interval until it returns success, or until the expiry has passed. All data you need for this request is in the [original request](https://api.torbox.app/docs#/User/start_device_code_authorization_process), which includes the interval to be polled by, the expiry time to stop at, and &#x60;device_code&#x60; to be sent to the API to get the correct data.  ### Authorization  None required. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UserApi()
val deviceTokenSchema : DeviceTokenSchema = {"device_code":"XXXXXXXXXXXXXXXXXXXXXXXXX"} // DeviceTokenSchema | 
try {
    val result : GetTokenFromDeviceCodeProcessResponse = apiInstance.getTokenFromDeviceCodeProcess(deviceTokenSchema)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#getTokenFromDeviceCodeProcess")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getTokenFromDeviceCodeProcess")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **deviceTokenSchema** | [**DeviceTokenSchema**](DeviceTokenSchema.md)|  | |

### Return type

[**GetTokenFromDeviceCodeProcessResponse**](GetTokenFromDeviceCodeProcessResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="getTransactionPdf"></a>
# **getTransactionPdf**
> kotlin.String getTransactionPdf(transactionId)

Get Transaction PDF

### Overview  Generates a PDF of the transaction information. Requires the transaction ID from the \&quot;Get Transactions\&quot; request.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UserApi()
val transactionId : kotlin.String = transactionId_example // kotlin.String | The transaction ID that you want to generate the PDF for.
try {
    val result : kotlin.String = apiInstance.getTransactionPdf(transactionId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#getTransactionPdf")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getTransactionPdf")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **transactionId** | **kotlin.String**| The transaction ID that you want to generate the PDF for. | |

### Return type

**kotlin.String**

### Authorization


Configure ApiKey statically:
```kotlin
ApiClient.accessToken = ""
```
Configure ApiKey dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTransactions"></a>
# **getTransactions**
> GetTransactionsResponse getTransactions()

Get Transactions

### Overview  Use this endpoint to get the user&#39;s list of transactions. This data isn&#39;t exactly relevant to a third party developer, unless you want to build full parity with TorBox&#39;s dashboard, or simply want to show this information.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UserApi()
try {
    val result : GetTransactionsResponse = apiInstance.getTransactions()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#getTransactions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getTransactions")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetTransactionsResponse**](GetTransactionsResponse.md)

### Authorization


Configure ApiKey statically:
```kotlin
ApiClient.accessToken = ""
```
Configure ApiKey dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getUserData"></a>
# **getUserData**
> GetUserDataResponse getUserData(settings, downloadStats, referral)

Get User Data

### Overview  Gets a users account data and information.  ### Plans  &#x60;0&#x60; is Free plan  &#x60;1&#x60; is Essential plan (_$3 plan_)  &#x60;2&#x60; is Pro plan (_$10 plan_)  &#x60;3&#x60; is Standard plan (_$5 plan_)  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UserApi()
val settings : kotlin.Boolean = true // kotlin.Boolean | Allows you to retrieve user settings.
val downloadStats : kotlin.Boolean = true // kotlin.Boolean | 
val referral : kotlin.Boolean = true // kotlin.Boolean | 
try {
    val result : GetUserDataResponse = apiInstance.getUserData(settings, downloadStats, referral)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#getUserData")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getUserData")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **settings** | **kotlin.Boolean**| Allows you to retrieve user settings. | [optional] [default to false] |
| **downloadStats** | **kotlin.Boolean**|  | [optional] [default to false] |
| **referral** | **kotlin.Boolean**|  | [optional] [default to false] |

### Return type

[**GetUserDataResponse**](GetUserDataResponse.md)

### Authorization


Configure ApiKey statically:
```kotlin
ApiClient.accessToken = ""
```
Configure ApiKey dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getUserStats"></a>
# **getUserStats**
> GetUserStatsResponse getUserStats(general, bandwidth, bandwidthGrouping)

Get User Stats

### Overview  Gets a users stats. This data is currently split into two sections, \&quot;general\&quot; and \&quot;bandwidth\&quot;. General shows general data, such as \&quot;Total Data Downloaded\&quot;, \&quot;Total Data Egress\&quot;, \&quot;Overall Ratio\&quot;, and \&quot;Total Downloaded\&quot;. Bandwidth shows the amount of bandwidth a user has downloaded within the past 30 days. We don&#39;t store this data for longer than 30 days, and it can be made more or less granular. Makes cool graphs!  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UserApi()
val general : kotlin.Boolean = true // kotlin.Boolean | Retrieve general stats.
val bandwidth : kotlin.Boolean = true // kotlin.Boolean | Retrieve bandwidth stats.
val bandwidthGrouping : kotlin.String = bandwidthGrouping_example // kotlin.String | If the \"bandwidth\" query parameter is sent, this value is used. Allowed is \"hour\", \"day\", \"week\", and \"month\", this narrates how bandwidth is grouped. More granular shows more information.
try {
    val result : GetUserStatsResponse = apiInstance.getUserStats(general, bandwidth, bandwidthGrouping)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#getUserStats")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#getUserStats")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **general** | **kotlin.Boolean**| Retrieve general stats. | [optional] [default to true] |
| **bandwidth** | **kotlin.Boolean**| Retrieve bandwidth stats. | [optional] [default to false] |
| **bandwidthGrouping** | **kotlin.String**| If the \&quot;bandwidth\&quot; query parameter is sent, this value is used. Allowed is \&quot;hour\&quot;, \&quot;day\&quot;, \&quot;week\&quot;, and \&quot;month\&quot;, this narrates how bandwidth is grouped. More granular shows more information. | [optional] [default to &quot;day&quot;] |

### Return type

[**GetUserStatsResponse**](GetUserStatsResponse.md)

### Authorization


Configure ApiKey statically:
```kotlin
ApiClient.accessToken = ""
```
Configure ApiKey dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="refreshApiToken"></a>
# **refreshApiToken**
> RefreshApiTokenResponse refreshApiToken(refreshTokenSchema)

Refresh API Token

### Overview  If you want a new API token, or your old one has been compromised, you may request a new one. If you happen to forget the token, go the [TorBox settings page ](https://torbox.app/settings) and copy the current one. If this still doesn&#39;t work, you may contact us at our support email for a new one.  ### Authorization  Requires an API key using the Authorization Bearer Header as well as passing the &#x60;session_token&#x60; from the website to be passed in the body. You can find the &#x60;session_token&#x60; in the localStorage of your browser on any TorBox.app page under the key &#x60;torbox_session_token&#x60;. This is a temporary token that only lasts for 1 hour, which is why it is used here to verify the identity of a user as well as their API token. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UserApi()
val refreshTokenSchema : RefreshTokenSchema = {"session_token":"string"} // RefreshTokenSchema | 
try {
    val result : RefreshApiTokenResponse = apiInstance.refreshApiToken(refreshTokenSchema)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#refreshApiToken")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#refreshApiToken")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **refreshTokenSchema** | [**RefreshTokenSchema**](RefreshTokenSchema.md)|  | |

### Return type

[**RefreshApiTokenResponse**](RefreshApiTokenResponse.md)

### Authorization


Configure ApiKey statically:
```kotlin
ApiClient.accessToken = ""
```
Configure ApiKey dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="startDeviceCodeAuthorizationProcess"></a>
# **startDeviceCodeAuthorizationProcess**
> StartDeviceCodeAuthorizationProcessResponse startDeviceCodeAuthorizationProcess(app)

Start Device Code Authorization Process

### Overview  Starts the device code authorization process. Returns all the necessary information to complete the rest of the flow. This includes the following:  - &#x60;device_code&#x60; - The code your app will use for consecutive requests for getting the user token.  - &#x60;code&#x60; - This is the 6 digit code that you show to the user to be entered at the following verification_url.  - &#x60;verification_url&#x60; - This url which you will show as a QR code.  - &#x60;friendly_verification_url&#x60; - The friendly short url which you can show as plain text to user if they cannot use the QR code method.   You may also submit the &#x60;app&#x60; parameter to this request to show your app name on the &#x60;verification_url&#x60; page. This concretes user trust in authorizing your application to use their TorBox account. This is not required, but is a good idea. Default is \&quot;Third Party App\&quot;. This name is also only allowed to be alpha-numeric characters (_A-Z,0-9_). Anything else will be filtered our when being shown to the user. The &#x60;friendly_verification_url&#x60; will always show \&quot;Third Party App\&quot; to keep the URL short.  The device_code is only valid for 10 minutes. Make sure the user is aware of this time limit so they submit and login before this time limit is over.  ### Authorization  None required. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UserApi()
val app : kotlin.String = app_example // kotlin.String | The app name that the user will see when verifying the code. This should be the name of your app.
try {
    val result : StartDeviceCodeAuthorizationProcessResponse = apiInstance.startDeviceCodeAuthorizationProcess(app)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserApi#startDeviceCodeAuthorizationProcess")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserApi#startDeviceCodeAuthorizationProcess")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **app** | **kotlin.String**| The app name that the user will see when verifying the code. This should be the name of your app. | [optional] [default to &quot;Third Party App&quot;] |

### Return type

[**StartDeviceCodeAuthorizationProcessResponse**](StartDeviceCodeAuthorizationProcessResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

