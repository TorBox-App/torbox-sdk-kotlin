# QueuedApi

All URIs are relative to *https://api.torbox.app*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**controlQueuedDownloads**](QueuedApi.md#controlQueuedDownloads) | **POST** /v1/api/queued/controlqueued | Control Queued Downloads |
| [**getQueuedDownloads**](QueuedApi.md#getQueuedDownloads) | **GET** /v1/api/queued/getqueued | Get Queued Downloads |


<a id="controlQueuedDownloads"></a>
# **controlQueuedDownloads**
> ControlQueuedDownloadsResponse controlQueuedDownloads(controlQueuedDownload)

Control Queued Downloads

### Overview  Controls a queued torrent. By sending the queued torrent&#39;s ID and the type of operation you want to perform, it will perform that action on the queued torrent.  Operations are either:  - **Delete** &#x60;deletes the queued download from your account&#x60;  - **Start** &#x60;starts a queued download, cannot be used with the \&quot;all\&quot; parameter&#x60;   ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = QueuedApi()
val controlQueuedDownload : ControlQueuedDownload = {"queued_id":0,"operation":"delete","all":false} // ControlQueuedDownload | 
try {
    val result : ControlQueuedDownloadsResponse = apiInstance.controlQueuedDownloads(controlQueuedDownload)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling QueuedApi#controlQueuedDownloads")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling QueuedApi#controlQueuedDownloads")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **controlQueuedDownload** | [**ControlQueuedDownload**](ControlQueuedDownload.md)|  | |

### Return type

[**ControlQueuedDownloadsResponse**](ControlQueuedDownloadsResponse.md)

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

<a id="getQueuedDownloads"></a>
# **getQueuedDownloads**
> GetQueuedDownloadsResponse getQueuedDownloads(id, type, bypassCache, offset, limit)

Get Queued Downloads

### Overview  Retrieves all of a user&#39;s queued downloads by type. If you want to get all 3 types, \&quot;torrent\&quot;, \&quot;usenet\&quot; and \&quot;webdl\&quot; then you will need to run this request 3 times, each with the different type.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = QueuedApi()
val id : kotlin.Long = 789 // kotlin.Long | Determines the queued download requested, will return an object rather than list. Optional.
val type : kotlin.String = type_example // kotlin.String | The type of the queued download you want to retrieve. Can be \"torrent\", \"usenet\" or \"webdl\". Optional. Default is \"torrent\".
val bypassCache : kotlin.Boolean = true // kotlin.Boolean | Allows you to bypass the cached data, and always get fresh information. Useful if constantly querying for fresh download stats. Otherwise, we request that you save our database a few calls.
val offset : kotlin.Long = 789 // kotlin.Long | Determines the offset of items to get from the database. Default is 0. Optional.
val limit : kotlin.Long = 789 // kotlin.Long | Determines the number of items to recieve per request. Default is 1000. Optional.
try {
    val result : GetQueuedDownloadsResponse = apiInstance.getQueuedDownloads(id, type, bypassCache, offset, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling QueuedApi#getQueuedDownloads")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling QueuedApi#getQueuedDownloads")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.Long**| Determines the queued download requested, will return an object rather than list. Optional. | [optional] |
| **type** | **kotlin.String**| The type of the queued download you want to retrieve. Can be \&quot;torrent\&quot;, \&quot;usenet\&quot; or \&quot;webdl\&quot;. Optional. Default is \&quot;torrent\&quot;. | [optional] [default to &quot;torrent&quot;] |
| **bypassCache** | **kotlin.Boolean**| Allows you to bypass the cached data, and always get fresh information. Useful if constantly querying for fresh download stats. Otherwise, we request that you save our database a few calls. | [optional] [default to false] |
| **offset** | **kotlin.Long**| Determines the offset of items to get from the database. Default is 0. Optional. | [optional] [default to 0L] |
| **limit** | **kotlin.Long**| Determines the number of items to recieve per request. Default is 1000. Optional. | [optional] [default to 1000L] |

### Return type

[**GetQueuedDownloadsResponse**](GetQueuedDownloadsResponse.md)

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

