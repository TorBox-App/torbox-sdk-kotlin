# VendorsApi

All URIs are relative to *https://api.torbox.app*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getVendorAccount**](VendorsApi.md#getVendorAccount) | **GET** /v1/api/vendors/account | Get Vendor Account |
| [**getVendorUser**](VendorsApi.md#getVendorUser) | **GET** /v1/api/vendors/getaccount | Get Vendor User |
| [**getVendorUsers**](VendorsApi.md#getVendorUsers) | **GET** /v1/api/vendors/getaccounts | Get Vendor Users |
| [**refreshVendorUsers**](VendorsApi.md#refreshVendorUsers) | **PATCH** /v1/api/vendors/refresh | Refresh Vendor Users |
| [**registerVendor**](VendorsApi.md#registerVendor) | **POST** /v1/api/vendors/register | Register Vendor |
| [**registerVendorUser**](VendorsApi.md#registerVendorUser) | **POST** /v1/api/vendors/registeruser | Register Vendor User |
| [**removeVendorUser**](VendorsApi.md#removeVendorUser) | **DELETE** /v1/api/vendors/removeuser | Remove Vendor User |
| [**updateVendorAccount**](VendorsApi.md#updateVendorAccount) | **PUT** /v1/api/vendors/updateaccount | Update Vendor Account |


<a id="getVendorAccount"></a>
# **getVendorAccount**
> GetVendorAccountResponse getVendorAccount()

Get Vendor Account

### Overview  Gets the vendor account that is registered under your TorBox account.  ##### Response Keys  - \&quot;vendor_id\&quot; &#x60;the id of the vendor account. Users owned by the vendor have this value as their \&quot;vendor_id\&quot;.&#x60; - \&quot;vendor_token\&quot; &#x60;the vendor token that was generated when the vendor account was registered.&#x60; - \&quot;vendor_email\&quot; &#x60;the email that was on the TorBox account when the vendor account was registered.&#x60; - \&quot;vendor_status\&quot; &#x60;the status of the vendor account. A vendor account is registered as \&quot;pending\&quot;.&#x60; - \&quot;users_allowed\&quot; &#x60;the highest number of users the vendor account may have.&#x60; - \&quot;current_users\&quot; &#x60;the number of users currently counted against \&quot;users_allowed\&quot;.&#x60; - \&quot;can_register_new\&quot; &#x60;whether the vendor account is allowed to register users.&#x60; - \&quot;account_type\&quot; &#x60;always \&quot;individual\&quot;.&#x60; - \&quot;plan\&quot; &#x60;the plan that is given to the vendor&#39;s users.&#x60; - \&quot;paid_until\&quot; &#x60;the date the vendor account is paid until. It is given to the vendor&#39;s users as their \&quot;premium_expires_at\&quot;.&#x60; - \&quot;can_generate_vouchers\&quot; &#x60;whether the vendor account is allowed to generate vouchers.&#x60;  ### Rate Limits  This endpoint is rate limited to **1 request per second** per API token.  ### Authorization  Requires an API key using the Authorization Bearer Header. Works with an API key from any plan, including the free plan. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = VendorsApi()
try {
    val result : GetVendorAccountResponse = apiInstance.getVendorAccount()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VendorsApi#getVendorAccount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VendorsApi#getVendorAccount")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetVendorAccountResponse**](GetVendorAccountResponse.md)

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

<a id="getVendorUser"></a>
# **getVendorUser**
> GetVendorUserResponse getVendorUser(userAuthId)

Get Vendor User

### Overview  Gets a single user account that is owned by your vendor account, using the user&#39;s &#x60;auth_id&#x60;. A user that is not owned by your vendor account is not found.  The response is the user&#39;s full account record, the same as an item of the Get Vendor Users endpoint, with one more key at the end:  - \&quot;api_token\&quot; &#x60;the user&#39;s API token. If the user has no API token, this is the text \&quot;USER HAS NOT CONFIRMED EMAIL\&quot;.&#x60;  ### Rate Limits  This endpoint is rate limited to **1 request per second** per API token.  ### Authorization  Requires an API key using the Authorization Bearer Header. Works with an API key from any plan, including the free plan. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = VendorsApi()
val userAuthId : kotlin.String = userAuthId_example // kotlin.String | Auth id of the user, from the Get Vendor Users endpoint. Required.
try {
    val result : GetVendorUserResponse = apiInstance.getVendorUser(userAuthId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VendorsApi#getVendorUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VendorsApi#getVendorUser")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **userAuthId** | **kotlin.String**| Auth id of the user, from the Get Vendor Users endpoint. Required. | |

### Return type

[**GetVendorUserResponse**](GetVendorUserResponse.md)

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

<a id="getVendorUsers"></a>
# **getVendorUsers**
> GetVendorUsersResponse getVendorUsers()

Get Vendor Users

### Overview  Gets every user account that is owned by your vendor account. Each item is the user&#39;s full account record, including their email, plan and &#x60;premium_expires_at&#x60;. There are no paging parameters, all of the users are returned in one response, ordered by their &#x60;id&#x60;. If the vendor account owns no users, &#x60;data&#x60; is an empty list.  The &#x60;auth_id&#x60; of a user is what the Get Vendor User and Remove Vendor User endpoints take as &#x60;user_auth_id&#x60;.  ### Rate Limits  This endpoint is rate limited to **1 request per second** per API token.  ### Authorization  Requires an API key using the Authorization Bearer Header. Works with an API key from any plan, including the free plan. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = VendorsApi()
try {
    val result : GetVendorUsersResponse = apiInstance.getVendorUsers()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VendorsApi#getVendorUsers")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VendorsApi#getVendorUsers")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetVendorUsersResponse**](GetVendorUsersResponse.md)

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

<a id="refreshVendorUsers"></a>
# **refreshVendorUsers**
> RefreshVendorUsersResponse refreshVendorUsers()

Refresh Vendor Users

### Overview  Refreshes every user that is owned by your vendor account. Each user&#39;s plan is set to your vendor account&#39;s &#x60;plan&#x60;, and each user&#39;s &#x60;premium_expires_at&#x60; is set to your vendor account&#39;s &#x60;paid_until&#x60;. Your vendor account&#39;s &#x60;current_users&#x60; is then recounted from the users it owns.  Your vendor account must be active: approved (its status is no longer \&quot;pending\&quot;), on a paid plan (its &#x60;plan&#x60; is not 0) and with a &#x60;paid_until&#x60; date that has not passed. Otherwise the request is rejected and no user is changed.  This endpoint takes no parameters and returns no data.  ### Authorization  Requires an API key using the Authorization Bearer Header. Works with an API key from any plan, including the free plan. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = VendorsApi()
try {
    val result : RefreshVendorUsersResponse = apiInstance.refreshVendorUsers()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VendorsApi#refreshVendorUsers")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VendorsApi#refreshVendorUsers")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RefreshVendorUsersResponse**](RefreshVendorUsersResponse.md)

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

<a id="registerVendor"></a>
# **registerVendor**
> RegisterVendorResponse registerVendor(vendorName, vendorUrl)

Register Vendor

### Overview  Registers a vendor account under your TorBox account. The vendor account uses your TorBox account&#39;s email, is created with the status \&quot;pending\&quot; and a newly generated vendor token, and your TorBox account is marked as a vendor. Once it is registered, a welcome email is sent to your account&#39;s email address and the TorBox team is notified of the signup.  A TorBox account can only have one vendor account, and an account that is itself owned by a vendor cannot register as a vendor.  The &#x60;vendor_url&#x60; must start with &#x60;http://&#x60; or &#x60;https://&#x60; and be a domain with an optional path. A URL with a port, a query string or a fragment is rejected.  To read the vendor account afterwards, including its id, user limit, plan and paid-until date, use the Get Vendor Account endpoint.  ### Rate Limits  This endpoint is rate limited to **15 requests per hour** per API token.  ### Authorization  Requires an API key using the Authorization Bearer Header. Works with an API key from any plan, including the free plan. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = VendorsApi()
val vendorName : kotlin.String = vendorName_example // kotlin.String | Name of the vendor. Required.
val vendorUrl : kotlin.String = vendorUrl_example // kotlin.String | Website of the vendor. Must start with http:// or https:// and cannot contain a port, a query string or a fragment. Required.
try {
    val result : RegisterVendorResponse = apiInstance.registerVendor(vendorName, vendorUrl)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VendorsApi#registerVendor")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VendorsApi#registerVendor")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **vendorName** | **kotlin.String**| Name of the vendor. Required. | |
| **vendorUrl** | **kotlin.String**| Website of the vendor. Must start with http:// or https:// and cannot contain a port, a query string or a fragment. Required. | |

### Return type

[**RegisterVendorResponse**](RegisterVendorResponse.md)

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

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a id="registerVendorUser"></a>
# **registerVendorUser**
> RegisterVendorUserResponse registerVendorUser(userEmail)

Register Vendor User

### Overview  Registers a user under your vendor account. Your vendor account must be allowed to register users (&#x60;can_register_new&#x60;) and must be below its user limit (&#x60;current_users&#x60; lower than &#x60;users_allowed&#x60;). The email is trimmed and lowercased before it is used, and it must be a valid, deliverable address that is not from a disposable email provider.  What happens depends on whether the email already has a TorBox account:  - **New account** &#x60;the email has no TorBox account. A new TorBox account is created with its email already confirmed and a generated password. It is owned by your vendor account, on your vendor account&#39;s plan, with your vendor account&#39;s \&quot;paid_until\&quot; as its \&quot;premium_expires_at\&quot;. The generated password is returned in the \&quot;password\&quot; key.&#x60; - **Existing account** &#x60;the email already has a TorBox account that is not owned by a vendor. The account is attached to your vendor account, and its plan and \&quot;premium_expires_at\&quot; are replaced with your vendor account&#39;s plan and \&quot;paid_until\&quot;. Its password is not changed, so the \&quot;password\&quot; key is the text \&quot;ALREADY_SET\&quot;. The user receives a notification that they were added to your vendor account, with a link to your vendor URL.&#x60;  An existing account is attached only when the email you send is the account&#39;s own email, or is that email without its dots and without anything from a &#x60;+&#x60; on in the part before the &#x60;@&#x60;. Any other spelling of an existing account&#39;s email attaches nothing and is rejected with the error &#x60;USER_EXISTS&#x60;: the account of &#x60;jane.doe@example.com&#x60; is not attached by &#x60;jane.doe+shop@example.com&#x60;.  An account that is already owned by a vendor cannot be registered, and that includes an account your own vendor account already owns. When two vendors register the same account at the same moment, one of them gets it and the other is rejected.  Each successful registration raises your vendor account&#39;s &#x60;current_users&#x60; by one. The &#x60;auth_id&#x60; in the response is what the Get Vendor User and Remove Vendor User endpoints take as &#x60;user_auth_id&#x60;.  ### Rate Limits  This endpoint is rate limited to **1 request per second** per API token.  ### Authorization  Requires an API key using the Authorization Bearer Header. Works with an API key from any plan, including the free plan. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = VendorsApi()
val userEmail : kotlin.String = userEmail_example // kotlin.String | Email address of the user to register. Required.
try {
    val result : RegisterVendorUserResponse = apiInstance.registerVendorUser(userEmail)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VendorsApi#registerVendorUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VendorsApi#registerVendorUser")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **userEmail** | **kotlin.String**| Email address of the user to register. Required. | |

### Return type

[**RegisterVendorUserResponse**](RegisterVendorUserResponse.md)

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

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a id="removeVendorUser"></a>
# **removeVendorUser**
> RemoveVendorUserResponse removeVendorUser(userAuthId)

Remove Vendor User

### Overview  Removes a user from your vendor account. The user must be owned by your vendor account. The user&#39;s TorBox account is not deleted, it is only released from the vendor, even though the &#x60;detail&#x60; of the response reads \&quot;User deleted successfully.\&quot;  What happens to the user&#39;s plan depends on the plan they are on when they are removed:  - If the user is on the same plan as your vendor account, the user is moved to the free plan (plan 0) and their &#x60;premium_expires_at&#x60; is set to the current time. - If the user is on a different plan than your vendor account, their plan and their &#x60;premium_expires_at&#x60; are left as they are.  Your vendor account&#39;s &#x60;current_users&#x60; is lowered by one, and the user receives a notification that they were removed from the vendor.  ### Rate Limits  This endpoint is rate limited to **1 request per second** per API token.  ### Authorization  Requires an API key using the Authorization Bearer Header. Works with an API key from any plan, including the free plan. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = VendorsApi()
val userAuthId : kotlin.String = userAuthId_example // kotlin.String | Auth id of the user to remove, from the Get Vendor Users endpoint. Required.
try {
    val result : RemoveVendorUserResponse = apiInstance.removeVendorUser(userAuthId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VendorsApi#removeVendorUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VendorsApi#removeVendorUser")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **userAuthId** | **kotlin.String**| Auth id of the user to remove, from the Get Vendor Users endpoint. Required. | |

### Return type

[**RemoveVendorUserResponse**](RemoveVendorUserResponse.md)

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

<a id="updateVendorAccount"></a>
# **updateVendorAccount**
> UpdateVendorAccountResponse updateVendorAccount(vendorName, vendorUrl)

Update Vendor Account

### Overview  Updates the name, the URL, or both, of your vendor account. Send at least one of &#x60;vendor_name&#x60; and &#x60;vendor_url&#x60;. The one that is not sent is left as it is.  The &#x60;vendor_url&#x60; follows the same rule as on the Register Vendor endpoint: it must start with &#x60;http://&#x60; or &#x60;https://&#x60; and be a domain with an optional path. A URL with a port, a query string or a fragment is rejected, and the request then changes nothing.  The response is the updated vendor account, in the same shape and with the same &#x60;detail&#x60; as the Get Vendor Account endpoint.  ### Rate Limits  This endpoint is rate limited to **15 requests per hour** per API token.  ### Authorization  Requires an API key using the Authorization Bearer Header. Works with an API key from any plan, including the free plan. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = VendorsApi()
val vendorName : kotlin.String = vendorName_example // kotlin.String | New name of the vendor. Optional, but at least one of vendor_name and vendor_url must be sent.
val vendorUrl : kotlin.String = vendorUrl_example // kotlin.String | New website of the vendor. Must start with http:// or https:// and cannot contain a port, a query string or a fragment. Optional, but at least one of vendor_name and vendor_url must be sent.
try {
    val result : UpdateVendorAccountResponse = apiInstance.updateVendorAccount(vendorName, vendorUrl)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling VendorsApi#updateVendorAccount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling VendorsApi#updateVendorAccount")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **vendorName** | **kotlin.String**| New name of the vendor. Optional, but at least one of vendor_name and vendor_url must be sent. | [optional] |
| **vendorUrl** | **kotlin.String**| New website of the vendor. Must start with http:// or https:// and cannot contain a port, a query string or a fragment. Optional, but at least one of vendor_name and vendor_url must be sent. | [optional] |

### Return type

[**UpdateVendorAccountResponse**](UpdateVendorAccountResponse.md)

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

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

