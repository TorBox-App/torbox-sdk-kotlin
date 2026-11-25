# GeneralApi

All URIs are relative to *https://api.torbox.app*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**get30DayStats**](GeneralApi.md#get30DayStats) | **GET** /v1/api/stats/30days | Get 30 Day Stats |
| [**getChangelogsJson**](GeneralApi.md#getChangelogsJson) | **GET** /v1/api/changelogs/json | Get Changelogs JSON |
| [**getChangelogsRssFeed**](GeneralApi.md#getChangelogsRssFeed) | **GET** /v1/api/changelogs/rss | Get Changelogs RSS Feed |
| [**getSpeedtestFiles**](GeneralApi.md#getSpeedtestFiles) | **GET** /v1/api/speedtest | Get Speedtest Files |
| [**getStats**](GeneralApi.md#getStats) | **GET** /v1/api/stats | Get Stats |
| [**getUpStatus**](GeneralApi.md#getUpStatus) | **GET** / | Get Up Status |


<a id="get30DayStats"></a>
# **get30DayStats**
> Get30DayStatsResponse get30DayStats()

Get 30 Day Stats

### Overview  Gets the general stats of the TorBox service for the last 30 days, one entry per day. Each entry is a snapshot of the totals at that time.  ### Authorization  None needed. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = GeneralApi()
try {
    val result : Get30DayStatsResponse = apiInstance.get30DayStats()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GeneralApi#get30DayStats")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GeneralApi#get30DayStats")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Get30DayStatsResponse**](Get30DayStatsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getChangelogsJson"></a>
# **getChangelogsJson**
> GetChangelogsJsonResponse getChangelogsJson(offset, limit)

Get Changelogs JSON

### Overview  Gets most recent changelogs from [https://feedback.torbox.app/changelog](https://feedback.torbox.app/changelog). This is useful for developers who want to integrate the changelog into their apps for their users to see. Includes content in HTML for developers to easily render the text in a fancy yet simple way.  ### Authorization  None needed. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = GeneralApi()
val offset : kotlin.Long = 789 // kotlin.Long | 
val limit : kotlin.Long = 789 // kotlin.Long | 
try {
    val result : GetChangelogsJsonResponse = apiInstance.getChangelogsJson(offset, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GeneralApi#getChangelogsJson")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GeneralApi#getChangelogsJson")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **offset** | **kotlin.Long**|  | [optional] [default to 0L] |
| **limit** | **kotlin.Long**|  | [optional] [default to 10L] |

### Return type

[**GetChangelogsJsonResponse**](GetChangelogsJsonResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getChangelogsRssFeed"></a>
# **getChangelogsRssFeed**
> kotlin.String getChangelogsRssFeed(offset, limit)

Get Changelogs RSS Feed

### Overview  Gets most recent 100 changelogs from [https://feedback.torbox.app/changelog](https://feedback.torbox.app/changelog). This is useful for people who want updates on the TorBox changelog. Includes all the necessary items to make this compatible with RSS feed viewers for notifications, and proper HTML viewing.  ### Authorization  None needed. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = GeneralApi()
val offset : kotlin.Long = 789 // kotlin.Long | 
val limit : kotlin.Long = 789 // kotlin.Long | 
try {
    val result : kotlin.String = apiInstance.getChangelogsRssFeed(offset, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GeneralApi#getChangelogsRssFeed")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GeneralApi#getChangelogsRssFeed")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **offset** | **kotlin.Long**|  | [optional] [default to 0L] |
| **limit** | **kotlin.Long**|  | [optional] [default to 10L] |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getSpeedtestFiles"></a>
# **getSpeedtestFiles**
> GetSpeedtestFilesResponse getSpeedtestFiles(userIp, region, testLength)

Get Speedtest Files

### Overview  Gets CDN speedtest files. This can be used for speedtesting TorBox for users or other usages, such as checking download speeds for verification. Provides all necessary data such as region, server name, and even coordinates. Uses the requesting IP to determine if the server is the closest to the user.  You also have the ability to choose between long tests or short tests via the \&quot;test_length\&quot; parameter. You may also force the region selection by passing the \&quot;region\&quot; as a specific region.  ### Authorization  None needed. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = GeneralApi()
val userIp : kotlin.String = userIp_example // kotlin.String | Pass a user's IP to get the closest server to them, otherwise will use the calling IP for location.
val region : kotlin.String = region_example // kotlin.String | Determines what cdns are returned. May be any region that TorBox is located in. To get this value, send a request without this value to determine all of the available regions that are available.
val testLength : kotlin.String = testLength_example // kotlin.String | Determines the size of the file used for the speedtest. May be \"long\" or \"short\". Optional.
try {
    val result : GetSpeedtestFilesResponse = apiInstance.getSpeedtestFiles(userIp, region, testLength)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GeneralApi#getSpeedtestFiles")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GeneralApi#getSpeedtestFiles")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **userIp** | **kotlin.String**| Pass a user&#39;s IP to get the closest server to them, otherwise will use the calling IP for location. | [optional] |
| **region** | **kotlin.String**| Determines what cdns are returned. May be any region that TorBox is located in. To get this value, send a request without this value to determine all of the available regions that are available. | [optional] [default to &quot;all&quot;] |
| **testLength** | **kotlin.String**| Determines the size of the file used for the speedtest. May be \&quot;long\&quot; or \&quot;short\&quot;. Optional. | [optional] [default to &quot;short&quot;] |

### Return type

[**GetSpeedtestFilesResponse**](GetSpeedtestFilesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getStats"></a>
# **getStats**
> GetStatsResponse getStats()

Get Stats

### Overview  Simply gets general stats about the TorBox service.  ### Authorization  None needed. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = GeneralApi()
try {
    val result : GetStatsResponse = apiInstance.getStats()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GeneralApi#getStats")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GeneralApi#getStats")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetStatsResponse**](GetStatsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getUpStatus"></a>
# **getUpStatus**
> GetUpStatusResponse getUpStatus()

Get Up Status

### Overview  Simply gets if the TorBox API is available for use or not. Also might include information about downtimes.  ### Authorization  None needed. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = GeneralApi()
try {
    val result : GetUpStatusResponse = apiInstance.getUpStatus()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GeneralApi#getUpStatus")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GeneralApi#getUpStatus")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetUpStatusResponse**](GetUpStatusResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

