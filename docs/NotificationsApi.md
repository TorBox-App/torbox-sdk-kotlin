# NotificationsApi

All URIs are relative to *https://api.torbox.app*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**clearAllNotifications**](NotificationsApi.md#clearAllNotifications) | **POST** /v1/api/notifications/clear | Clear All Notifications |
| [**clearSingleNotification**](NotificationsApi.md#clearSingleNotification) | **POST** /v1/api/notifications/clear/{id} | Clear Single Notification |
| [**getNotificationFeed**](NotificationsApi.md#getNotificationFeed) | **GET** /v1/api/notifications/mynotifications | Get Notification Feed |
| [**getRssNotificationFeed**](NotificationsApi.md#getRssNotificationFeed) | **GET** /v1/api/notifications/rss | Get RSS Notification Feed |
| [**sendTestNotification**](NotificationsApi.md#sendTestNotification) | **POST** /v1/api/notifications/test | Send Test Notification |


<a id="clearAllNotifications"></a>
# **clearAllNotifications**
> ClearAllNotificationsResponse clearAllNotifications()

Clear All Notifications

### Overview  Marks all of your notifications as read and deletes them permanently.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = NotificationsApi()
try {
    val result : ClearAllNotificationsResponse = apiInstance.clearAllNotifications()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NotificationsApi#clearAllNotifications")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NotificationsApi#clearAllNotifications")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ClearAllNotificationsResponse**](ClearAllNotificationsResponse.md)

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

<a id="clearSingleNotification"></a>
# **clearSingleNotification**
> ClearSingleNotificationResponse clearSingleNotification(id)

Clear Single Notification

### Overview  Marks a single notification as read and permanently deletes it from your notifications. Requires a &#x60;notification_id&#x60; which can be found by getting your notification feed.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = NotificationsApi()
val id : kotlin.String = id_example // kotlin.String | 
try {
    val result : ClearSingleNotificationResponse = apiInstance.clearSingleNotification(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NotificationsApi#clearSingleNotification")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NotificationsApi#clearSingleNotification")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.String**|  | |

### Return type

[**ClearSingleNotificationResponse**](ClearSingleNotificationResponse.md)

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

<a id="getNotificationFeed"></a>
# **getNotificationFeed**
> GetNotificationFeedResponse getNotificationFeed(bypassCache)

Get Notification Feed

### Overview  Gets your notifications in a JSON object that is easily parsable compared to the RSS Feed. Gives all the same data as the RSS Feed.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = NotificationsApi()
val bypassCache : kotlin.Boolean = true // kotlin.Boolean | 
try {
    val result : GetNotificationFeedResponse = apiInstance.getNotificationFeed(bypassCache)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NotificationsApi#getNotificationFeed")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NotificationsApi#getNotificationFeed")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **bypassCache** | **kotlin.Boolean**|  | [optional] [default to false] |

### Return type

[**GetNotificationFeedResponse**](GetNotificationFeedResponse.md)

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

<a id="getRssNotificationFeed"></a>
# **getRssNotificationFeed**
> kotlin.String getRssNotificationFeed(token)

Get RSS Notification Feed

### Overview  Gets your notifications in an RSS Feed which allows you to use them with RSS Feed readers or notification services that can take RSS Feeds and listen to updates. As soon as a notification goes to your account, it will be added to your feed.  ### Authorization  Requires an API key using as a query parameter using the &#x60;token&#x60; key. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = NotificationsApi()
val token : kotlin.String = token_example // kotlin.String | The user's API key.
try {
    val result : kotlin.String = apiInstance.getRssNotificationFeed(token)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NotificationsApi#getRssNotificationFeed")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NotificationsApi#getRssNotificationFeed")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **token** | **kotlin.String**| The user&#39;s API key. | |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="sendTestNotification"></a>
# **sendTestNotification**
> SendTestNotificationResponse sendTestNotification()

Send Test Notification

### Overview  Sends a test notification to all enabled notification types. This can be useful for validating setups. No need for any body in this request.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = NotificationsApi()
try {
    val result : SendTestNotificationResponse = apiInstance.sendTestNotification()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NotificationsApi#sendTestNotification")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NotificationsApi#sendTestNotification")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SendTestNotificationResponse**](SendTestNotificationResponse.md)

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

