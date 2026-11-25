# TorrentsApi

All URIs are relative to *https://api.torbox.app*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**asyncCreateTorrent**](TorrentsApi.md#asyncCreateTorrent) | **POST** /v1/api/torrents/asynccreatetorrent | Async Create Torrent |
| [**controlQueuedTorrents**](TorrentsApi.md#controlQueuedTorrents) | **POST** /v1/api/torrents/controlqueued | Control Queued Torrents |
| [**controlTorrent**](TorrentsApi.md#controlTorrent) | **POST** /v1/api/torrents/controltorrent | Control Torrent |
| [**createTorrent**](TorrentsApi.md#createTorrent) | **POST** /v1/api/torrents/createtorrent | Create Torrent |
| [**editTorrentItem**](TorrentsApi.md#editTorrentItem) | **PUT** /v1/api/torrents/edittorrent | Edit Torrent Item |
| [**exportTorrentData**](TorrentsApi.md#exportTorrentData) | **GET** /v1/api/torrents/exportdata | Export Torrent Data |
| [**getQueuedTorrents**](TorrentsApi.md#getQueuedTorrents) | **GET** /v1/api/torrents/getqueued | Get Queued Torrents |
| [**getTorrentCachedAvailability**](TorrentsApi.md#getTorrentCachedAvailability) | **GET** /v1/api/torrents/checkcached | Get Torrent Cached Availability |
| [**getTorrentCachedAvailabilityBatch**](TorrentsApi.md#getTorrentCachedAvailabilityBatch) | **POST** /v1/api/torrents/checkcached | Get Torrent Cached Availability Batch |
| [**getTorrentInfo**](TorrentsApi.md#getTorrentInfo) | **GET** /v1/api/torrents/torrentinfo | Get Torrent Info |
| [**getTorrentInfoFromFile**](TorrentsApi.md#getTorrentInfoFromFile) | **POST** /v1/api/torrents/torrentinfo | Get Torrent Info |
| [**getTorrentList**](TorrentsApi.md#getTorrentList) | **GET** /v1/api/torrents/mylist | Get Torrent List |
| [**magnetToFile**](TorrentsApi.md#magnetToFile) | **POST** /v1/api/torrents/magnettofile | Magnet To File |
| [**requestTorrentDownloadLink**](TorrentsApi.md#requestTorrentDownloadLink) | **GET** /v1/api/torrents/requestdl | Request Download Link |
| [**requestTorrentDownloadLinksGet**](TorrentsApi.md#requestTorrentDownloadLinksGet) | **GET** /v1/api/torrents/requestdl/batch | Request Download Links - GET |
| [**requestTorrentDownloadLinksPost**](TorrentsApi.md#requestTorrentDownloadLinksPost) | **POST** /v1/api/torrents/requestdl/batch | Request Download Links - POST |


<a id="asyncCreateTorrent"></a>
# **asyncCreateTorrent**
> AsyncCreateTorrentResponse asyncCreateTorrent(file, magnet, seed, allowZip, name, asQueued, addOnlyIfCached)

Async Create Torrent

### Overview  Creates a torrent asynchrously under your account. Simply send **either** a magnet link, or a torrent file. Once they have been checked, they will begin downloading assuming your account has available active download slots, and they aren&#39;t too large.  The request will return instantly, not returning any data other than a success message. This is the same for failures, as they will return the error in the background, rather than immediately.  ### Rate Limits  This endpoint has the same limits as the Create Torrent endpoint: **300 requests per minute**, and **60 uncached torrents per hour**. The hourly limit is shared between the two endpoints, so an uncached torrent added through either one counts against the same 60. As on that endpoint, a request sent with &#x60;add_only_if_cached&#x60; and without &#x60;as_queued&#x60; is not counted against the hourly limit.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
val file : java.io.File = BINARY_DATA_HERE // java.io.File | The torrent's torrent file. Optional.
val magnet : kotlin.String = magnet_example // kotlin.String | The torrent's magnet link. Optional.
val seed : kotlin.Long = 789 // kotlin.Long | Tells TorBox your preference for seeding this torrent. 1 is auto. 2 is seed. 3 is don't seed. Optional. Default is 1, or whatever the user has in their settings. Overwrites option in settings.
val allowZip : kotlin.Boolean = true // kotlin.Boolean | Tells TorBox if you want to allow this torrent to be zipped or not. TorBox only zips if the torrent is 100 files or larger.
val name : kotlin.String = name_example // kotlin.String | The name you want the torrent to be. Optional.
val asQueued : kotlin.Boolean = true // kotlin.Boolean | Tells TorBox you want this torrent instantly queued. This is bypassed if user is on free plan, and will process the request as normal in this case. Optional.
val addOnlyIfCached : kotlin.Boolean = true // kotlin.Boolean | Only adds the download if it is cached on TorBox. If not cached, it won't be added.
try {
    val result : AsyncCreateTorrentResponse = apiInstance.asyncCreateTorrent(file, magnet, seed, allowZip, name, asQueued, addOnlyIfCached)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#asyncCreateTorrent")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#asyncCreateTorrent")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **file** | **java.io.File**| The torrent&#39;s torrent file. Optional. | [optional] |
| **magnet** | **kotlin.String**| The torrent&#39;s magnet link. Optional. | [optional] |
| **seed** | **kotlin.Long**| Tells TorBox your preference for seeding this torrent. 1 is auto. 2 is seed. 3 is don&#39;t seed. Optional. Default is 1, or whatever the user has in their settings. Overwrites option in settings. | [optional] |
| **allowZip** | **kotlin.Boolean**| Tells TorBox if you want to allow this torrent to be zipped or not. TorBox only zips if the torrent is 100 files or larger. | [optional] [default to true] |
| **name** | **kotlin.String**| The name you want the torrent to be. Optional. | [optional] |
| **asQueued** | **kotlin.Boolean**| Tells TorBox you want this torrent instantly queued. This is bypassed if user is on free plan, and will process the request as normal in this case. Optional. | [optional] [default to false] |
| **addOnlyIfCached** | **kotlin.Boolean**| Only adds the download if it is cached on TorBox. If not cached, it won&#39;t be added. | [optional] [default to false] |

### Return type

[**AsyncCreateTorrentResponse**](AsyncCreateTorrentResponse.md)

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

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a id="controlQueuedTorrents"></a>
# **controlQueuedTorrents**
> controlQueuedTorrents()

Control Queued Torrents

### Overview  This endpoint is deprecated and always answers with a &#x60;DEPRECATED&#x60; error. Use the Control Queued Downloads endpoint (&#x60;/v1/api/queued/controlqueued&#x60;) instead.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
try {
    apiInstance.controlQueuedTorrents()
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#controlQueuedTorrents")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#controlQueuedTorrents")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

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

<a id="controlTorrent"></a>
# **controlTorrent**
> ControlTorrentResponse controlTorrent(controlTorrent)

Control Torrent

### Overview  Controls a torrent. By sending the torrent&#39;s ID and the type of operation you want to perform, it will send that request to the torrent client.  Operations are either:  - **Reannounce** &#x60;reannounces the torrent to get new peers&#x60;  - **Delete** &#x60;deletes the torrent from the client and your account permanently&#x60;  - **Resume** &#x60;resumes a paused torrent&#x60;   ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
val controlTorrent : ControlTorrent = {"torrent_id":1,"operation":"delete","all":false} // ControlTorrent | 
try {
    val result : ControlTorrentResponse = apiInstance.controlTorrent(controlTorrent)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#controlTorrent")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#controlTorrent")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **controlTorrent** | [**ControlTorrent**](ControlTorrent.md)|  | |

### Return type

[**ControlTorrentResponse**](ControlTorrentResponse.md)

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

<a id="createTorrent"></a>
# **createTorrent**
> CreateTorrentResponse createTorrent(file, magnet, seed, allowZip, name, asQueued, addOnlyIfCached)

Create Torrent

### Overview  Creates a torrent under your account. Simply send **either** a magnet link, or a torrent file. Once they have been checked, they will begin downloading assuming your account has available active download slots, and they aren&#39;t too large.  ### Rate Limits  This endpoint has two limits that apply at the same time:  - **300 requests per minute:** a shared ceiling that _every_ request counts against, whether the torrent is cached or uncached.  - **60 uncached torrents per hour:** an additional, stricter limit that only uncached torrents count against. A request sent with &#x60;add_only_if_cached&#x60; is not counted, because it adds nothing when the torrent is not cached. It is counted when it is also sent with &#x60;as_queued&#x60;, because a queued torrent is added whether it is cached or not.   The important thing is that cached and uncached requests both draw from the same 300/min pool, but uncached requests _also_ draw from their own separate 60/hour pool. An uncached request therefore counts twice: once against the per-minute limit, and once against the per-hour uncached limit.  **Example:** In a single minute you add 250 cached + 50 uncached torrents. That&#39;s 300 total, so you&#39;ve hit the per-minute limit for that minute. But those 50 uncached torrents also came out of your 60/hour uncached budget, leaving only **10 uncached torrents** for the remaining 59 minutes of that hour. (You could still add plenty more _cached_ torrents during that hour, since cached requests aren&#39;t capped hourly: only by the 300/min ceiling.)  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
val file : java.io.File = BINARY_DATA_HERE // java.io.File | The torrent's torrent file. Optional.
val magnet : kotlin.String = magnet_example // kotlin.String | The torrent's magnet link. Optional.
val seed : kotlin.Long = 789 // kotlin.Long | Tells TorBox your preference for seeding this torrent. 1 is auto. 2 is seed. 3 is don't seed. Optional. Default is 1, or whatever the user has in their settings. Overwrites option in settings.
val allowZip : kotlin.Boolean = true // kotlin.Boolean | Tells TorBox if you want to allow this torrent to be zipped or not. TorBox only zips if the torrent is 100 files or larger.
val name : kotlin.String = name_example // kotlin.String | The name you want the torrent to be. Optional.
val asQueued : kotlin.Boolean = true // kotlin.Boolean | Tells TorBox you want this torrent instantly queued. This is bypassed if user is on free plan, and will process the request as normal in this case. Optional.
val addOnlyIfCached : kotlin.Boolean = true // kotlin.Boolean | Only adds the download if it is cached on TorBox. If not cached, it won't be added.
try {
    val result : CreateTorrentResponse = apiInstance.createTorrent(file, magnet, seed, allowZip, name, asQueued, addOnlyIfCached)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#createTorrent")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#createTorrent")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **file** | **java.io.File**| The torrent&#39;s torrent file. Optional. | [optional] |
| **magnet** | **kotlin.String**| The torrent&#39;s magnet link. Optional. | [optional] |
| **seed** | **kotlin.Long**| Tells TorBox your preference for seeding this torrent. 1 is auto. 2 is seed. 3 is don&#39;t seed. Optional. Default is 1, or whatever the user has in their settings. Overwrites option in settings. | [optional] |
| **allowZip** | **kotlin.Boolean**| Tells TorBox if you want to allow this torrent to be zipped or not. TorBox only zips if the torrent is 100 files or larger. | [optional] [default to true] |
| **name** | **kotlin.String**| The name you want the torrent to be. Optional. | [optional] |
| **asQueued** | **kotlin.Boolean**| Tells TorBox you want this torrent instantly queued. This is bypassed if user is on free plan, and will process the request as normal in this case. Optional. | [optional] [default to false] |
| **addOnlyIfCached** | **kotlin.Boolean**| Only adds the download if it is cached on TorBox. If not cached, it won&#39;t be added. | [optional] [default to false] |

### Return type

[**CreateTorrentResponse**](CreateTorrentResponse.md)

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

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a id="editTorrentItem"></a>
# **editTorrentItem**
> EditTorrentItemResponse editTorrentItem(editTorrent)

Edit Torrent Item

### Overview  Updates a download item based on the item&#39;s ID. Sending a PUT request with valid items overwrites the previous items entirely, so use this endpoint with caution. Please make sure to read the restrictions below as they are important.  ### Restrictions  - Does not affect the cached database (or any other user&#39;s item).  - Name must pass validation:      - Above 1 character long.      - Below 200 characters long.      - Cannot contain any non-url or non filesystem safe characters. (This is removed automatically).      - Cannot contain any leading or trailing whitespace. You can have spaces in the middle. (This is removed automatically).  - Tags follow the same rules as the name.  - Alternative hashes must be of MD5, SHA1, or SHA256.   ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
val editTorrent : EditTorrent = {"torrent_id":0,"name":"string","tags":["string"],"alternative_hashes":["0123456789abcdef0123456789abcdef01234567"],"airlocked":false} // EditTorrent | 
try {
    val result : EditTorrentItemResponse = apiInstance.editTorrentItem(editTorrent)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#editTorrentItem")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#editTorrentItem")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **editTorrent** | [**EditTorrent**](EditTorrent.md)|  | |

### Return type

[**EditTorrentItemResponse**](EditTorrentItemResponse.md)

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

<a id="exportTorrentData"></a>
# **exportTorrentData**
> ExportTorrentDataResponse exportTorrentData(torrentId, type)

Export Torrent Data

### Overview  Exports the magnet or torrent file. Requires a type to be passed. If type is **magnet**, it will return a JSON response with the magnet as a string in the _data_ key. If type is **file**, it will return a bittorrent file as a download. Not compatible with cached downloads.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
val torrentId : kotlin.Long = 789 // kotlin.Long | The torrent's ID.
val type : kotlin.String = type_example // kotlin.String | Either \"magnet\" or \"file\". Tells how the API what to get, and what to respond as. If magnet, it returns a JSON response with the magnet as a string in the data key. If file, it responds with a torrent file download.
try {
    val result : ExportTorrentDataResponse = apiInstance.exportTorrentData(torrentId, type)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#exportTorrentData")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#exportTorrentData")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **torrentId** | **kotlin.Long**| The torrent&#39;s ID. | |
| **type** | **kotlin.String**| Either \&quot;magnet\&quot; or \&quot;file\&quot;. Tells how the API what to get, and what to respond as. If magnet, it returns a JSON response with the magnet as a string in the data key. If file, it responds with a torrent file download. | |

### Return type

[**ExportTorrentDataResponse**](ExportTorrentDataResponse.md)

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

<a id="getQueuedTorrents"></a>
# **getQueuedTorrents**
> getQueuedTorrents()

Get Queued Torrents

### Overview  This endpoint is deprecated and always answers with a &#x60;DEPRECATED&#x60; error. Use the Get Queued Downloads endpoint (&#x60;/v1/api/queued/getqueued&#x60;) instead.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
try {
    apiInstance.getQueuedTorrents()
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#getQueuedTorrents")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#getQueuedTorrents")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

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

<a id="getTorrentCachedAvailability"></a>
# **getTorrentCachedAvailability**
> GetTorrentCachedAvailabilityResponse getTorrentCachedAvailability(hash, format, listFiles, checkCached)

Get Torrent Cached Availability

### Overview  Takes in a list of comma separated torrent hashes and checks if the torrent is cached. This endpoint only gets a max of around 100 at a time, due to http limits in queries. If you want to do more, you can simply do more hash queries. Such as: &#x60;?hash&#x3D;XXXX&amp;hash&#x3D;XXXX&amp;hash&#x3D;XXXX&#x60;  or &#x60;?hash&#x3D;XXXX,XXXX&amp;hash&#x3D;XXXX&amp;hash&#x3D;XXXX,XXXX&#x60; and this will work too. Performance is very fast. Less than 1 second per 100. Time is approximately O(log n) time for those interested in taking it to its max. That is without caching as well. This endpoint stores a cache for an hour.  You may also pass a &#x60;format&#x60; parameter with the format you want the data in. Options are either &#x60;object&#x60; or &#x60;list&#x60;. You can view examples of both below.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
val hash : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The list of torrent hashes you want to check. Comma seperated.
val format : kotlin.String = format_example // kotlin.String | Format you want the data in. Acceptable is either \"object\" or \"list\". List is the most performant option as it doesn't require modification of the list.
val listFiles : kotlin.Boolean = true // kotlin.Boolean | Allows you to list the files found inside the cached data.
val checkCached : CheckCached =  // CheckCached | 
try {
    val result : GetTorrentCachedAvailabilityResponse = apiInstance.getTorrentCachedAvailability(hash, format, listFiles, checkCached)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#getTorrentCachedAvailability")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#getTorrentCachedAvailability")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **hash** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The list of torrent hashes you want to check. Comma seperated. | [optional] |
| **format** | **kotlin.String**| Format you want the data in. Acceptable is either \&quot;object\&quot; or \&quot;list\&quot;. List is the most performant option as it doesn&#39;t require modification of the list. | [optional] [default to &quot;object&quot;] |
| **listFiles** | **kotlin.Boolean**| Allows you to list the files found inside the cached data. | [optional] [default to false] |
| **checkCached** | [**CheckCached**](CheckCached.md)|  | [optional] |

### Return type

[**GetTorrentCachedAvailabilityResponse**](GetTorrentCachedAvailabilityResponse.md)

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

<a id="getTorrentCachedAvailabilityBatch"></a>
# **getTorrentCachedAvailabilityBatch**
> GetTorrentCachedAvailabilityBatchResponse getTorrentCachedAvailabilityBatch(hash, format, listFiles, checkCached)

Get Torrent Cached Availability Batch

### Overview  Takes in a list of comma separated torrent hashes and checks if the torrent is cached. With the POST endpoint you can submit a nearly unlimited hashes compared to the GET endpoint which is limited by url parameters.   Performance is very fast. Less than 1 second per 100. Time is approximately O(log n) time for those interested in taking it to its max. That is without caching as well. This endpoint stores a cache for an hour.  You may also pass a &#x60;format&#x60; parameter with the format you want the data in. Options are either &#x60;object&#x60; or &#x60;list&#x60;. You can view examples of both below.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
val hash : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
val format : kotlin.String = format_example // kotlin.String | 
val listFiles : kotlin.Boolean = true // kotlin.Boolean | 
val checkCached : CheckCached = {"hashes":["string","string"]} // CheckCached | 
try {
    val result : GetTorrentCachedAvailabilityBatchResponse = apiInstance.getTorrentCachedAvailabilityBatch(hash, format, listFiles, checkCached)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#getTorrentCachedAvailabilityBatch")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#getTorrentCachedAvailabilityBatch")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **hash** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] |
| **format** | **kotlin.String**|  | [optional] [default to &quot;object&quot;] |
| **listFiles** | **kotlin.Boolean**|  | [optional] [default to false] |
| **checkCached** | [**CheckCached**](CheckCached.md)|  | [optional] |

### Return type

[**GetTorrentCachedAvailabilityBatchResponse**](GetTorrentCachedAvailabilityBatchResponse.md)

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

<a id="getTorrentInfo"></a>
# **getTorrentInfo**
> GetTorrentInfoResponse getTorrentInfo(hash, timeout, useCacheLookup)

Get Torrent Info

### Overview  A general route that allows you to give a hash, and TorBox will return data about the torrent. This data is retrieved from the Bittorrent network, so expect it to take some time. If the request goes longer than 10 seconds, TorBox will cancel it. You can adjust this if you like, but the default is 10 seconds. This route is cached as well, so subsequent requests will be instant.  **It is not recommended to use this for checking TorBox&#39;s cache. Please use the GET /checkcache endpoint instead.**  ### Authorization  None required. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
val hash : kotlin.String = hash_example // kotlin.String | Hash of the torrent you want to get info for. This is required.
val timeout : kotlin.Long = 789 // kotlin.Long | The amount of time you want TorBox to search for the torrent on the Bittorrent network. If the number of seeders is low or even zero, this value may be helpful to move up. Default is 10. Optional.
val useCacheLookup : kotlin.Boolean = true // kotlin.Boolean | If you want to use a pre-cached request if sent before. This can save a lot of time. Default false.
try {
    val result : GetTorrentInfoResponse = apiInstance.getTorrentInfo(hash, timeout, useCacheLookup)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#getTorrentInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#getTorrentInfo")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **hash** | **kotlin.String**| Hash of the torrent you want to get info for. This is required. | |
| **timeout** | **kotlin.Long**| The amount of time you want TorBox to search for the torrent on the Bittorrent network. If the number of seeders is low or even zero, this value may be helpful to move up. Default is 10. Optional. | [optional] [default to 30L] |
| **useCacheLookup** | **kotlin.Boolean**| If you want to use a pre-cached request if sent before. This can save a lot of time. Default false. | [optional] [default to false] |

### Return type

[**GetTorrentInfoResponse**](GetTorrentInfoResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getTorrentInfoFromFile"></a>
# **getTorrentInfoFromFile**
> GetTorrentInfoFromFileResponse getTorrentInfoFromFile(timeout, hash, magnet, file, useCacheLookup, peersOnly)

Get Torrent Info

### Overview  Same as the GET route, but allows posting data such as magnet, and torrent files.  Hashes will have precedence over magnets, and magnets will have precedence over torrent files.  Only proper torrent files are accepted.  At least one of hash, magnet, or torrent file is required.  A general route that allows you to give a hash, and TorBox will return data about the torrent. This data is retrieved from the Bittorrent network, so expect it to take some time. If the request goes longer than 10 seconds, TorBox will cancel it. You can adjust this if you like, but the default is 10 seconds. This route is cached as well, so subsequent requests will be instant.  **It is not recommended to use this for checking TorBox&#39;s cache. Please use the GET /checkcache endpoint instead.**  ### Authorization  None required. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
val timeout : kotlin.Long = 789 // kotlin.Long | The amount of time you want TorBox to search for the torrent on the Bittorrent network. If the number of seeders is low or even zero, this value may be helpful to move up. Default is 10. Optional.
val hash : kotlin.String = hash_example // kotlin.String | A torrent hash for requesting information about the torrent. Optional.
val magnet : kotlin.String = magnet_example // kotlin.String | A magnet link for requesting information abouit the torrent. Optional.
val file : java.io.File = BINARY_DATA_HERE // java.io.File | A torrent file for requesting information about the torrent. Optional.
val useCacheLookup : kotlin.Boolean = true // kotlin.Boolean | If you want to use a pre-cached request if sent before. This can save a lot of time. Default false.
val peersOnly : kotlin.Boolean = true // kotlin.Boolean | Uses a quick lookup method using the trackers contained within the magnet or file. Requires the submitted magnet or torrent file to contain trackers of UDP or HTTP(S) to work. This will not get metadata such as name, size, or files. Best used for simply and quickly gathering the current seeds and peers according to the trackers. Uses the highest number of all the trackers as the final value. Default off.
try {
    val result : GetTorrentInfoFromFileResponse = apiInstance.getTorrentInfoFromFile(timeout, hash, magnet, file, useCacheLookup, peersOnly)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#getTorrentInfoFromFile")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#getTorrentInfoFromFile")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **timeout** | **kotlin.Long**| The amount of time you want TorBox to search for the torrent on the Bittorrent network. If the number of seeders is low or even zero, this value may be helpful to move up. Default is 10. Optional. | [optional] [default to 10L] |
| **hash** | **kotlin.String**| A torrent hash for requesting information about the torrent. Optional. | [optional] |
| **magnet** | **kotlin.String**| A magnet link for requesting information abouit the torrent. Optional. | [optional] |
| **file** | **java.io.File**| A torrent file for requesting information about the torrent. Optional. | [optional] |
| **useCacheLookup** | **kotlin.Boolean**| If you want to use a pre-cached request if sent before. This can save a lot of time. Default false. | [optional] [default to false] |
| **peersOnly** | **kotlin.Boolean**| Uses a quick lookup method using the trackers contained within the magnet or file. Requires the submitted magnet or torrent file to contain trackers of UDP or HTTP(S) to work. This will not get metadata such as name, size, or files. Best used for simply and quickly gathering the current seeds and peers according to the trackers. Uses the highest number of all the trackers as the final value. Default off. | [optional] [default to false] |

### Return type

[**GetTorrentInfoFromFileResponse**](GetTorrentInfoFromFileResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a id="getTorrentList"></a>
# **getTorrentList**
> GetTorrentListResponse getTorrentList(id, bypassCache, offset, limit, files, active)

Get Torrent List

### Overview  Gets the user&#39;s torrent list. This gives you the needed information to perform other torrent actions. This information only gets updated every 600 seconds, or when the _Request Update On Torrent_ request is sent to the _relay API_.  #### Download States:  - \&quot;downloading\&quot; -&gt; The torrent is currently downloading.  - \&quot;uploading\&quot; -&gt; The torrent is currently seeding.  - \&quot;stalled (no seeds)\&quot; -&gt; The torrent is trying to download, but there are no seeds connected to download from.  - \&quot;paused\&quot; -&gt; The torrent is paused.  - \&quot;completed\&quot; -&gt; The torrent is completely downloaded. Do not use this for download completion status.  - \&quot;cached\&quot; -&gt; The torrent is cached from the server.  - \&quot;metaDL\&quot; -&gt; The torrent is downloading metadata from the hoard.  - \&quot;checkingResumeData\&quot; -&gt; The torrent is checking resumable data.   All other statuses are basic qBittorrent states. [Check out here for the full list](https://github.com/qbittorrent/qBittorrent/wiki/WebUI-API-(qBittorrent-4.1)#torrent-management).  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
val id : kotlin.Long = 789 // kotlin.Long | Determines the torrent requested, will return an object rather than list. Optional.
val bypassCache : kotlin.Boolean = true // kotlin.Boolean | Allows you to bypass the cached data, and always get fresh information. Useful if constantly querying for fresh download stats. Otherwise, we request that you save our database a few calls.
val offset : kotlin.Long = 789 // kotlin.Long | Determines the offset of items to get from the database. Default is 0. Optional.
val limit : kotlin.Long = 789 // kotlin.Long | Determines the number of items to recieve per request. Default is 1000. Optional.
val files : kotlin.Boolean = true // kotlin.Boolean | Exclude files from response. Optional
val active : kotlin.Boolean = true // kotlin.Boolean | Shows only active downloads. Optional
try {
    val result : GetTorrentListResponse = apiInstance.getTorrentList(id, bypassCache, offset, limit, files, active)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#getTorrentList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#getTorrentList")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.Long**| Determines the torrent requested, will return an object rather than list. Optional. | [optional] |
| **bypassCache** | **kotlin.Boolean**| Allows you to bypass the cached data, and always get fresh information. Useful if constantly querying for fresh download stats. Otherwise, we request that you save our database a few calls. | [optional] [default to false] |
| **offset** | **kotlin.Long**| Determines the offset of items to get from the database. Default is 0. Optional. | [optional] [default to 0L] |
| **limit** | **kotlin.Long**| Determines the number of items to recieve per request. Default is 1000. Optional. | [optional] [default to 1000L] |
| **files** | **kotlin.Boolean**| Exclude files from response. Optional | [optional] [default to true] |
| **active** | **kotlin.Boolean**| Shows only active downloads. Optional | [optional] |

### Return type

[**GetTorrentListResponse**](GetTorrentListResponse.md)

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

<a id="magnetToFile"></a>
# **magnetToFile**
> kotlin.String magnetToFile(magnetToTorrent)

Magnet To File

### Overview  Converts any magnet to a torrent file. Does not require the magnet to be on your TorBox account or in the TorBox cache. Free endpoint for public use.  ### Authorization  None required. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
val magnetToTorrent : MagnetToTorrent = {"magnet":"string"} // MagnetToTorrent | 
try {
    val result : kotlin.String = apiInstance.magnetToFile(magnetToTorrent)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#magnetToFile")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#magnetToFile")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **magnetToTorrent** | [**MagnetToTorrent**](MagnetToTorrent.md)|  | |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="requestTorrentDownloadLink"></a>
# **requestTorrentDownloadLink**
> RequestTorrentDownloadLinkResponse requestTorrentDownloadLink(token, torrentId, fileId, zipLink, userIp, redirect, appendName)

Request Download Link

### Overview  Requests the download link from the server. Because downloads are metered, TorBox cannot afford to allow free access to the links directly. This endpoint opens the link for 3 hours for downloads. Once a download is started, the user has nearly unlilimited time to download the file. The 1 hour time limit is simply for starting downloads. This prevents long term link sharing.  ### Permalinks  Instead of generating many CDN urls by requesting this endpoint, you can instead create a permalink such as: &#x60;https://api.torbox.app/v1/api/torrents/requestdl?token&#x3D;APIKEY&amp;torrent_id&#x3D;NUMBER&amp;file_id&#x3D;NUMBER&amp;redirect&#x3D;true&#x60; and when a user clicks on it, it will automatically redirect them to the CDN link. This saves requests and doesn&#39;t abuse the API. Use this method rather than saving CDN links as they are not permanent. To invalidate these permalinks, simply reset your API token or delete the item from your dashboard.  ### Authorization  Requires an API key as a parameter for the &#x60;token&#x60; parameter. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
val token : kotlin.String = token_example // kotlin.String | Your API Key
val torrentId : kotlin.Long = 789 // kotlin.Long | The torrent's ID that you want to download
val fileId : kotlin.Long = 789 // kotlin.Long | The files's ID that you want to download
val zipLink : kotlin.Boolean = true // kotlin.Boolean | If you want a zip link. Required if no file_id. Takes precedence over file_id if both are given.
val userIp : kotlin.String = userIp_example // kotlin.String | The user's IP to determine the closest CDN. Optional.
val redirect : kotlin.Boolean = true // kotlin.Boolean | If you want to redirect the user to the CDN link. This is useful for creating permalinks so that you can just make this request URL the link.
val appendName : kotlin.Boolean = true // kotlin.Boolean | If you want to add the \"filename\" parameter to the returned CDN link. Optional. Default false.
try {
    val result : RequestTorrentDownloadLinkResponse = apiInstance.requestTorrentDownloadLink(token, torrentId, fileId, zipLink, userIp, redirect, appendName)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#requestTorrentDownloadLink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#requestTorrentDownloadLink")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **token** | **kotlin.String**| Your API Key | |
| **torrentId** | **kotlin.Long**| The torrent&#39;s ID that you want to download | |
| **fileId** | **kotlin.Long**| The files&#39;s ID that you want to download | [optional] [default to 0L] |
| **zipLink** | **kotlin.Boolean**| If you want a zip link. Required if no file_id. Takes precedence over file_id if both are given. | [optional] [default to false] |
| **userIp** | **kotlin.String**| The user&#39;s IP to determine the closest CDN. Optional. | [optional] |
| **redirect** | **kotlin.Boolean**| If you want to redirect the user to the CDN link. This is useful for creating permalinks so that you can just make this request URL the link. | [optional] [default to false] |
| **appendName** | **kotlin.Boolean**| If you want to add the \&quot;filename\&quot; parameter to the returned CDN link. Optional. Default false. | [optional] [default to false] |

### Return type

[**RequestTorrentDownloadLinkResponse**](RequestTorrentDownloadLinkResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="requestTorrentDownloadLinksGet"></a>
# **requestTorrentDownloadLinksGet**
> RequestTorrentDownloadLinksGetResponse requestTorrentDownloadLinksGet(token, torrentId, fileIds, userIp, appendName, requestDownloadBatch)

Request Download Links - GET

### Overview  Requests multiple download links from the server. Because downloads are metered, TorBox cannot afford to allow free access to the links directly. This endpoint opens the link for 3 hours for downloads. Once a download is started, the user has nearly unlilimited time to download the file. The 1 hour time limit is simply for starting downloads. This prevents long term link sharing.  ### Authorization  Requires an API key as a parameter for the &#x60;token&#x60; parameter. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
val token : kotlin.String = token_example // kotlin.String | Your API Key
val torrentId : kotlin.Long = 789 // kotlin.Long | The torrent's ID that you want to download
val fileIds : kotlin.collections.List<kotlin.Long> =  // kotlin.collections.List<kotlin.Long> | The files's ID that you want to download
val userIp : kotlin.String = userIp_example // kotlin.String | The user's IP to determine the closest CDN. Optional.
val appendName : kotlin.Boolean = true // kotlin.Boolean | If you want to add the \"filename\" parameter to the returned CDN link. Optional. Default false.
val requestDownloadBatch : RequestDownloadBatch =  // RequestDownloadBatch | 
try {
    val result : RequestTorrentDownloadLinksGetResponse = apiInstance.requestTorrentDownloadLinksGet(token, torrentId, fileIds, userIp, appendName, requestDownloadBatch)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#requestTorrentDownloadLinksGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#requestTorrentDownloadLinksGet")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **token** | **kotlin.String**| Your API Key | |
| **torrentId** | **kotlin.Long**| The torrent&#39;s ID that you want to download | |
| **fileIds** | [**kotlin.collections.List&lt;kotlin.Long&gt;**](kotlin.Long.md)| The files&#39;s ID that you want to download | [optional] |
| **userIp** | **kotlin.String**| The user&#39;s IP to determine the closest CDN. Optional. | [optional] |
| **appendName** | **kotlin.Boolean**| If you want to add the \&quot;filename\&quot; parameter to the returned CDN link. Optional. Default false. | [optional] [default to false] |
| **requestDownloadBatch** | [**RequestDownloadBatch**](RequestDownloadBatch.md)|  | [optional] |

### Return type

[**RequestTorrentDownloadLinksGetResponse**](RequestTorrentDownloadLinksGetResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="requestTorrentDownloadLinksPost"></a>
# **requestTorrentDownloadLinksPost**
> RequestTorrentDownloadLinksPostResponse requestTorrentDownloadLinksPost(token, torrentId, fileIds, userIp, appendName, requestDownloadBatch)

Request Download Links - POST

### Overview  Requests multiple download links from the server. Because downloads are metered, TorBox cannot afford to allow free access to the links directly. This endpoint opens the link for 3 hours for downloads. Once a download is started, the user has nearly unlilimited time to download the file. The 1 hour time limit is simply for starting downloads. This prevents long term link sharing.  ### Authorization  Requires an API key as a parameter for the &#x60;token&#x60; parameter. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TorrentsApi()
val token : kotlin.String = token_example // kotlin.String | Your API Key
val torrentId : kotlin.Long = 789 // kotlin.Long | The torrent's ID that you want to download
val fileIds : kotlin.collections.List<kotlin.Long> =  // kotlin.collections.List<kotlin.Long> | 
val userIp : kotlin.String = userIp_example // kotlin.String | The user's IP to determine the closest CDN. Optional.
val appendName : kotlin.Boolean = true // kotlin.Boolean | If you want to add the \"filename\" parameter to the returned CDN link. Optional. Default false.
val requestDownloadBatch : RequestDownloadBatch = {"file_ids":[0,1,2]} // RequestDownloadBatch | 
try {
    val result : RequestTorrentDownloadLinksPostResponse = apiInstance.requestTorrentDownloadLinksPost(token, torrentId, fileIds, userIp, appendName, requestDownloadBatch)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TorrentsApi#requestTorrentDownloadLinksPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TorrentsApi#requestTorrentDownloadLinksPost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **token** | **kotlin.String**| Your API Key | |
| **torrentId** | **kotlin.Long**| The torrent&#39;s ID that you want to download | |
| **fileIds** | [**kotlin.collections.List&lt;kotlin.Long&gt;**](kotlin.Long.md)|  | [optional] |
| **userIp** | **kotlin.String**| The user&#39;s IP to determine the closest CDN. Optional. | [optional] |
| **appendName** | **kotlin.Boolean**| If you want to add the \&quot;filename\&quot; parameter to the returned CDN link. Optional. Default false. | [optional] [default to false] |
| **requestDownloadBatch** | [**RequestDownloadBatch**](RequestDownloadBatch.md)|  | [optional] |

### Return type

[**RequestTorrentDownloadLinksPostResponse**](RequestTorrentDownloadLinksPostResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

