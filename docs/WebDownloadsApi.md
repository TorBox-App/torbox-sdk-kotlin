# WebDownloadsApi

All URIs are relative to *https://api.torbox.app*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**asyncCreateWebDownload**](WebDownloadsApi.md#asyncCreateWebDownload) | **POST** /v1/api/webdl/asynccreatewebdownload | Async Create Web Download |
| [**controlWebDownload**](WebDownloadsApi.md#controlWebDownload) | **POST** /v1/api/webdl/controlwebdownload | Control Web Download |
| [**createWebDownload**](WebDownloadsApi.md#createWebDownload) | **POST** /v1/api/webdl/createwebdownload | Create Web Download |
| [**editWebDownloadItem**](WebDownloadsApi.md#editWebDownloadItem) | **PUT** /v1/api/webdl/editwebdownload | Edit Web Download Item |
| [**getHosterList**](WebDownloadsApi.md#getHosterList) | **GET** /v1/api/webdl/hosters | Get Hoster List |
| [**getWebDownloadCachedAvailability**](WebDownloadsApi.md#getWebDownloadCachedAvailability) | **GET** /v1/api/webdl/checkcached | Get Web Download Cached Availability |
| [**getWebDownloadCachedAvailabilityBatch**](WebDownloadsApi.md#getWebDownloadCachedAvailabilityBatch) | **POST** /v1/api/webdl/checkcached | Get Web Download Cached Availability Batch |
| [**getWebDownloadList**](WebDownloadsApi.md#getWebDownloadList) | **GET** /v1/api/webdl/mylist | Get Web Download List |
| [**requestWebDownloadLink**](WebDownloadsApi.md#requestWebDownloadLink) | **GET** /v1/api/webdl/requestdl | Request Download Link |
| [**requestWebDownloadLinksGet**](WebDownloadsApi.md#requestWebDownloadLinksGet) | **GET** /v1/api/webdl/requestdl/batch | Request Download Links - GET |
| [**requestWebDownloadLinksPost**](WebDownloadsApi.md#requestWebDownloadLinksPost) | **POST** /v1/api/webdl/requestdl/batch | Request Download Links - POST |


<a id="asyncCreateWebDownload"></a>
# **asyncCreateWebDownload**
> AsyncCreateWebDownloadResponse asyncCreateWebDownload(link, password, name, asQueued, addOnlyIfCached)

Async Create Web Download

### Overview  Creates a web download asynchronously under your account. Simply send a link to any file on the internet. Once it has been checked, it will begin downloading assuming your account has available active download slots, and they aren&#39;t too large.  The request will return instantly, not returning any data other than a success message. This is the same for failures, as they will return the error in the background as a notification, rather than immediately.  ### Rate Limits  This endpoint is rate limited to **60 requests per hour** per API token.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = WebDownloadsApi()
val link : kotlin.String = link_example // kotlin.String | An accessible link to any file on the internet. Cannot be a redirection.
val password : kotlin.String = password_example // kotlin.String | Password to the file, if the files requires it. Optional.
val name : kotlin.String = name_example // kotlin.String | The name you want the web download to be. Optional.
val asQueued : kotlin.Boolean = true // kotlin.Boolean | Tells TorBox you want this web download instantly queued. Optional.
val addOnlyIfCached : kotlin.Boolean = true // kotlin.Boolean | Only adds the download if it is cached on TorBox. If not cached, it won't be added.
try {
    val result : AsyncCreateWebDownloadResponse = apiInstance.asyncCreateWebDownload(link, password, name, asQueued, addOnlyIfCached)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebDownloadsApi#asyncCreateWebDownload")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebDownloadsApi#asyncCreateWebDownload")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **link** | **kotlin.String**| An accessible link to any file on the internet. Cannot be a redirection. | |
| **password** | **kotlin.String**| Password to the file, if the files requires it. Optional. | [optional] |
| **name** | **kotlin.String**| The name you want the web download to be. Optional. | [optional] |
| **asQueued** | **kotlin.Boolean**| Tells TorBox you want this web download instantly queued. Optional. | [optional] [default to false] |
| **addOnlyIfCached** | **kotlin.Boolean**| Only adds the download if it is cached on TorBox. If not cached, it won&#39;t be added. | [optional] [default to false] |

### Return type

[**AsyncCreateWebDownloadResponse**](AsyncCreateWebDownloadResponse.md)

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

<a id="controlWebDownload"></a>
# **controlWebDownload**
> ControlWebDownloadResponse controlWebDownload(controlWebDownload)

Control Web Download

### Overview  Controls a web download. By sending the web download&#39;s ID and the type of operation you want to perform, it will send that request to the debrid client.  Operations are either:  - **Delete** &#x60;deletes the download from the client and your account permanently&#x60;   ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = WebDownloadsApi()
val controlWebDownload : ControlWebDownload = {"webdl_id":1,"operation":"delete","all":false} // ControlWebDownload | 
try {
    val result : ControlWebDownloadResponse = apiInstance.controlWebDownload(controlWebDownload)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebDownloadsApi#controlWebDownload")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebDownloadsApi#controlWebDownload")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **controlWebDownload** | [**ControlWebDownload**](ControlWebDownload.md)|  | |

### Return type

[**ControlWebDownloadResponse**](ControlWebDownloadResponse.md)

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

<a id="createWebDownload"></a>
# **createWebDownload**
> CreateWebDownloadResponse createWebDownload(link, password, name, asQueued, addOnlyIfCached)

Create Web Download

### Overview  Creates a web download under your account. Simply send a link to any file on the internet. Once it has been checked, it will begin downloading assuming your account has available active download slots, and they aren&#39;t too large.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = WebDownloadsApi()
val link : kotlin.String = link_example // kotlin.String | An accessible link to any file on the internet. Cannot be a redirection.
val password : kotlin.String = password_example // kotlin.String | Password to the file, if the files requires it. Optional.
val name : kotlin.String = name_example // kotlin.String | The name you want the torrent to be. Optional.
val asQueued : kotlin.Boolean = true // kotlin.Boolean | Tells TorBox you want this web download.instantly queued. Optional.
val addOnlyIfCached : kotlin.Boolean = true // kotlin.Boolean | Only adds the download if it is cached on TorBox. If not cached, it won't be added.
try {
    val result : CreateWebDownloadResponse = apiInstance.createWebDownload(link, password, name, asQueued, addOnlyIfCached)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebDownloadsApi#createWebDownload")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebDownloadsApi#createWebDownload")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **link** | **kotlin.String**| An accessible link to any file on the internet. Cannot be a redirection. | |
| **password** | **kotlin.String**| Password to the file, if the files requires it. Optional. | [optional] |
| **name** | **kotlin.String**| The name you want the torrent to be. Optional. | [optional] |
| **asQueued** | **kotlin.Boolean**| Tells TorBox you want this web download.instantly queued. Optional. | [optional] [default to false] |
| **addOnlyIfCached** | **kotlin.Boolean**| Only adds the download if it is cached on TorBox. If not cached, it won&#39;t be added. | [optional] [default to false] |

### Return type

[**CreateWebDownloadResponse**](CreateWebDownloadResponse.md)

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

<a id="editWebDownloadItem"></a>
# **editWebDownloadItem**
> EditWebDownloadItemResponse editWebDownloadItem(editWebDownload)

Edit Web Download Item

### Overview  Updates a download item based on the item&#39;s ID. Sending a PUT request with valid items overwrites the previous items entirely, so use this endpoint with caution. Please make sure to read the restrictions below as they are important.  ### Restrictions  - Does not affect the cached database (or any other user&#39;s item).  - Name must pass validation:      - Above 1 character long.      - Below 200 characters long.      - Cannot contain any non-url or non filesystem safe characters. (This is removed automatically).      - Cannot contain any leading or trailing whitespace. You can have spaces in the middle. (This is removed automatically).  - Tags follow the same rules as the name.  - Alternative hashes must be of MD5, SHA1, or SHA256.   ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = WebDownloadsApi()
val editWebDownload : EditWebDownload = {"webdl_id":0,"name":"string","tags":["string"],"alternative_hashes":["0123456789abcdef0123456789abcdef01234567"],"airlocked":false} // EditWebDownload | 
try {
    val result : EditWebDownloadItemResponse = apiInstance.editWebDownloadItem(editWebDownload)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebDownloadsApi#editWebDownloadItem")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebDownloadsApi#editWebDownloadItem")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **editWebDownload** | [**EditWebDownload**](EditWebDownload.md)|  | |

### Return type

[**EditWebDownloadItemResponse**](EditWebDownloadItemResponse.md)

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

<a id="getHosterList"></a>
# **getHosterList**
> GetHosterListResponse getHosterList()

Get Hoster List

### Overview  A dynamic list of hosters that TorBox is capable of downloading through its paid service.  - **Name** - a clean name for display use, the well known name of the service, should be recognizable to users.  - **Domains** - an array of known domains that the hoster uses. While each may serve a different purpose it is still included.  - **URL** - the main url of the service. This should take you to the home page or a service page of the hoster.  - **Icon** - a square image, usually a favicon or logo, that represents the service, should be recognizable as the hoster&#39;s icon.  - **Status** - whether this hoster can be used on TorBox or not at the current time. It is usually a good idea to check this value before submitting a download to TorBox&#39;s servers for download.  - **Type** - values are either \&quot;hoster\&quot; or \&quot;stream\&quot;. Both do the same thing, but is good to differentiate services used for different things.  - **Note** - a string value (or null) that may give helpful information about the current status or state of a hoster. This can and should be shown to end users.  - **Daily Link Limit** - the number of downloads a user can use per day. As a user submits links, once they hit this number, the API will deny them from adding anymore of this type of link. A zero value means that it is unlimited.  - **Daily Link Used** - the number of downloads a user has already used. Usually zero unless you send authentication to the endpoint. This will return accurate values.  - **Daily Bandwidth Limit** - the value in bytes that a user is allowed to download from this hoster. A zero value means that it is unlimited. It is recommended to use the Daily Link Limit instead.  - **Daily Bandwidth Used** - the value in bytes that a user has already used to download from this hoster. Usually zero unless you send authentication to the endpoint. This will return accurate values.   ### Authorization  Optional authorization. Authorization is not required in this endpoint unless you want to get the user&#39;s live data. Requires an API key using the Authorization Bearer Header to get the live and accurate data for **Daily Link Used** and **Daily Bandwidth Used**. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = WebDownloadsApi()
try {
    val result : GetHosterListResponse = apiInstance.getHosterList()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebDownloadsApi#getHosterList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebDownloadsApi#getHosterList")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetHosterListResponse**](GetHosterListResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getWebDownloadCachedAvailability"></a>
# **getWebDownloadCachedAvailability**
> GetWebDownloadCachedAvailabilityResponse getWebDownloadCachedAvailability(hash, format, listFiles, checkCached)

Get Web Download Cached Availability

### Overview  Takes in a list of comma separated usenet hashes and checks if the web download is cached. This endpoint only gets a max of around 100 at a time, due to http limits in queries. If you want to do more, you can simply do more hash queries. Such as: &#x60;?hash&#x3D;XXXX&amp;hash&#x3D;XXXX&amp;hash&#x3D;XXXX&#x60;  or &#x60;?hash&#x3D;XXXX,XXXX&amp;hash&#x3D;XXXX&amp;hash&#x3D;XXXX,XXXX&#x60; and this will work too. Performance is very fast. Less than 1 second per 100. Time is approximately O(log n) time for those interested in taking it to its max. That is without caching as well. This endpoint stores a cache for an hour.  You may also pass a &#x60;format&#x60; parameter with the format you want the data in. Options are either &#x60;object&#x60; or &#x60;list&#x60;. You can view examples of both below.  To get the hash of a web download you can read [this document](https://support.torbox.app/en/articles/13681109-technical-getting-hashes-for-searches) for all of the strategies.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = WebDownloadsApi()
val hash : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The list of web hashes you want to check. Comma seperated. To find the hash, md5 the link.
val format : kotlin.String = format_example // kotlin.String | Format you want the data in. Acceptable is either \"object\" or \"list\". List is the most performant option as it doesn't require modification of the list.
val listFiles : kotlin.Boolean = true // kotlin.Boolean | Allows you to list the files found inside the cached data.
val checkCached : CheckCached =  // CheckCached | 
try {
    val result : GetWebDownloadCachedAvailabilityResponse = apiInstance.getWebDownloadCachedAvailability(hash, format, listFiles, checkCached)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebDownloadsApi#getWebDownloadCachedAvailability")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebDownloadsApi#getWebDownloadCachedAvailability")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **hash** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The list of web hashes you want to check. Comma seperated. To find the hash, md5 the link. | [optional] |
| **format** | **kotlin.String**| Format you want the data in. Acceptable is either \&quot;object\&quot; or \&quot;list\&quot;. List is the most performant option as it doesn&#39;t require modification of the list. | [optional] [default to &quot;object&quot;] |
| **listFiles** | **kotlin.Boolean**| Allows you to list the files found inside the cached data. | [optional] [default to false] |
| **checkCached** | [**CheckCached**](CheckCached.md)|  | [optional] |

### Return type

[**GetWebDownloadCachedAvailabilityResponse**](GetWebDownloadCachedAvailabilityResponse.md)

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

<a id="getWebDownloadCachedAvailabilityBatch"></a>
# **getWebDownloadCachedAvailabilityBatch**
> GetWebDownloadCachedAvailabilityBatchResponse getWebDownloadCachedAvailabilityBatch(hash, format, listFiles, checkCached)

Get Web Download Cached Availability Batch

### Overview  Takes in a list of comma separated hashes and checks if the torrent is cached. With the POST endpoint you can submit a nearly unlimited hashes compared to the GET endpoint which is limited by url parameters.  Performance is very fast. Less than 1 second per 100. Time is approximately O(log n) time for those interested in taking it to its max. That is without caching as well. This endpoint stores a cache for an hour.  You may also pass a &#x60;format&#x60; parameter with the format you want the data in. Options are either &#x60;object&#x60; or &#x60;list&#x60;. You can view examples of both below.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = WebDownloadsApi()
val hash : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
val format : kotlin.String = format_example // kotlin.String | Format you want the data in. Acceptable is either \"object\" or \"list\". List is the most performant option as it doesn't require modification of the list.
val listFiles : kotlin.Boolean = true // kotlin.Boolean | Allows you to list the files found inside the cached data.
val checkCached : CheckCached = {"hashes":["string"]} // CheckCached | 
try {
    val result : GetWebDownloadCachedAvailabilityBatchResponse = apiInstance.getWebDownloadCachedAvailabilityBatch(hash, format, listFiles, checkCached)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebDownloadsApi#getWebDownloadCachedAvailabilityBatch")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebDownloadsApi#getWebDownloadCachedAvailabilityBatch")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **hash** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | [optional] |
| **format** | **kotlin.String**| Format you want the data in. Acceptable is either \&quot;object\&quot; or \&quot;list\&quot;. List is the most performant option as it doesn&#39;t require modification of the list. | [optional] [default to &quot;object&quot;] |
| **listFiles** | **kotlin.Boolean**| Allows you to list the files found inside the cached data. | [optional] [default to false] |
| **checkCached** | [**CheckCached**](CheckCached.md)|  | [optional] |

### Return type

[**GetWebDownloadCachedAvailabilityBatchResponse**](GetWebDownloadCachedAvailabilityBatchResponse.md)

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

<a id="getWebDownloadList"></a>
# **getWebDownloadList**
> GetWebDownloadListResponse getWebDownloadList(id, bypassCache, offset, limit, files, active)

Get Web Download List

### Overview  Gets the user&#39;s web download list. This gives you the needed information to perform other usenet actions. Unlike Torrents, this information is updated on its own every 5 seconds for live web downloads.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = WebDownloadsApi()
val id : kotlin.Long = 789 // kotlin.Long | Determines the torrent requested, will return an object rather than list. Optional.
val bypassCache : kotlin.Boolean = true // kotlin.Boolean | Allows you to bypass the cached data, and always get fresh information. Useful if constantly querying for fresh download stats. Otherwise, we request that you save our database a few calls.
val offset : kotlin.Long = 789 // kotlin.Long | Determines the offset of items to get from the database. Default is 0. Optional.
val limit : kotlin.Long = 789 // kotlin.Long | Determines the number of items to recieve per request. Default is 1000. Optional.
val files : kotlin.Boolean = true // kotlin.Boolean | Exclude files from response. Optional
val active : kotlin.Boolean = true // kotlin.Boolean | Shows only active downloads. Optional
try {
    val result : GetWebDownloadListResponse = apiInstance.getWebDownloadList(id, bypassCache, offset, limit, files, active)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebDownloadsApi#getWebDownloadList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebDownloadsApi#getWebDownloadList")
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

[**GetWebDownloadListResponse**](GetWebDownloadListResponse.md)

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

<a id="requestWebDownloadLink"></a>
# **requestWebDownloadLink**
> RequestWebDownloadLinkResponse requestWebDownloadLink(token, webId, fileId, zipLink, userIp, redirect, appendName)

Request Download Link

### Overview  Requests the download link from the server. Because downloads are metered, TorBox cannot afford to allow free access to the links directly. This endpoint opens the link for 3 hours for downloads. Once a download is started, the user has nearly unlilimited time to download the file. The 1 hour time limit is simply for starting downloads. This prevents long term link sharing.  ### Permalinks  Instead of generating many CDN urls by requesting this endpoint, you can instead create a permalink such as: &#x60;https://api.torbox.app/v1/api/torrents/requestdl?token&#x3D;APIKEY&amp;torrent_id&#x3D;NUMBER&amp;file_id&#x3D;NUMBER&amp;redirect&#x3D;true&#x60; and when a user clicks on it, it will automatically redirect them to the CDN link. This saves requests and doesn&#39;t abuse the API. Use this method rather than saving CDN links as they are not permanent. To invalidate these permalinks, simply reset your API token or delete the item from your dashboard.  ### Authorization  Requires an API key as a parameter for the &#x60;token&#x60; parameter. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = WebDownloadsApi()
val token : kotlin.String = token_example // kotlin.String | Your API Key
val webId : kotlin.Long = 789 // kotlin.Long | The web download's ID that you want to download
val fileId : kotlin.Long = 789 // kotlin.Long | The files's ID that you want to download
val zipLink : kotlin.Boolean = true // kotlin.Boolean | If you want a zip link. Required if no file_id. Takes precedence over file_id if both are given.
val userIp : kotlin.String = userIp_example // kotlin.String | The user's IP to determine the closest CDN. Optional.
val redirect : kotlin.Boolean = true // kotlin.Boolean | If you want to redirect the user to the CDN link. This is useful for creating permalinks so that you can just make this request URL the link.
val appendName : kotlin.Boolean = true // kotlin.Boolean | If you want to add the \"filename\" parameter to the returned CDN link. Optional. Default false.
try {
    val result : RequestWebDownloadLinkResponse = apiInstance.requestWebDownloadLink(token, webId, fileId, zipLink, userIp, redirect, appendName)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebDownloadsApi#requestWebDownloadLink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebDownloadsApi#requestWebDownloadLink")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **token** | **kotlin.String**| Your API Key | |
| **webId** | **kotlin.Long**| The web download&#39;s ID that you want to download | |
| **fileId** | **kotlin.Long**| The files&#39;s ID that you want to download | [optional] [default to 0L] |
| **zipLink** | **kotlin.Boolean**| If you want a zip link. Required if no file_id. Takes precedence over file_id if both are given. | [optional] [default to false] |
| **userIp** | **kotlin.String**| The user&#39;s IP to determine the closest CDN. Optional. | [optional] |
| **redirect** | **kotlin.Boolean**| If you want to redirect the user to the CDN link. This is useful for creating permalinks so that you can just make this request URL the link. | [optional] [default to false] |
| **appendName** | **kotlin.Boolean**| If you want to add the \&quot;filename\&quot; parameter to the returned CDN link. Optional. Default false. | [optional] [default to false] |

### Return type

[**RequestWebDownloadLinkResponse**](RequestWebDownloadLinkResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="requestWebDownloadLinksGet"></a>
# **requestWebDownloadLinksGet**
> RequestWebDownloadLinksGetResponse requestWebDownloadLinksGet(token, webId, fileIds, userIp, appendName, requestDownloadBatch)

Request Download Links - GET

### Overview  Requests multiple download links from the server. Because downloads are metered, TorBox cannot afford to allow free access to the links directly. This endpoint opens the link for 3 hours for downloads. Once a download is started, the user has nearly unlilimited time to download the file. The 1 hour time limit is simply for starting downloads. This prevents long term link sharing.  ### Authorization  Requires an API key as a parameter for the &#x60;token&#x60; parameter. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = WebDownloadsApi()
val token : kotlin.String = token_example // kotlin.String | Your API Key
val webId : kotlin.Long = 789 // kotlin.Long | The web download's ID that you want to download
val fileIds : kotlin.collections.List<kotlin.Long> =  // kotlin.collections.List<kotlin.Long> | The files's ID that you want to download
val userIp : kotlin.String = userIp_example // kotlin.String | The user's IP to determine the closest CDN. Optional.
val appendName : kotlin.Boolean = true // kotlin.Boolean | If you want to add the \"filename\" parameter to the returned CDN link. Optional. Default false.
val requestDownloadBatch : RequestDownloadBatch =  // RequestDownloadBatch | 
try {
    val result : RequestWebDownloadLinksGetResponse = apiInstance.requestWebDownloadLinksGet(token, webId, fileIds, userIp, appendName, requestDownloadBatch)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebDownloadsApi#requestWebDownloadLinksGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebDownloadsApi#requestWebDownloadLinksGet")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **token** | **kotlin.String**| Your API Key | |
| **webId** | **kotlin.Long**| The web download&#39;s ID that you want to download | |
| **fileIds** | [**kotlin.collections.List&lt;kotlin.Long&gt;**](kotlin.Long.md)| The files&#39;s ID that you want to download | [optional] |
| **userIp** | **kotlin.String**| The user&#39;s IP to determine the closest CDN. Optional. | [optional] |
| **appendName** | **kotlin.Boolean**| If you want to add the \&quot;filename\&quot; parameter to the returned CDN link. Optional. Default false. | [optional] [default to false] |
| **requestDownloadBatch** | [**RequestDownloadBatch**](RequestDownloadBatch.md)|  | [optional] |

### Return type

[**RequestWebDownloadLinksGetResponse**](RequestWebDownloadLinksGetResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="requestWebDownloadLinksPost"></a>
# **requestWebDownloadLinksPost**
> RequestWebDownloadLinksPostResponse requestWebDownloadLinksPost(token, webId, fileIds, userIp, appendName, requestDownloadBatch)

Request Download Links - POST

### Overview  Requests multiple download links from the server. Because downloads are metered, TorBox cannot afford to allow free access to the links directly. This endpoint opens the link for 3 hours for downloads. Once a download is started, the user has nearly unlilimited time to download the file. The 1 hour time limit is simply for starting downloads. This prevents long term link sharing.  ### Authorization  Requires an API key as a parameter for the &#x60;token&#x60; parameter. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = WebDownloadsApi()
val token : kotlin.String = token_example // kotlin.String | Your API Key
val webId : kotlin.Long = 789 // kotlin.Long | The web downloads' ID that you want to download
val fileIds : kotlin.collections.List<kotlin.Long> =  // kotlin.collections.List<kotlin.Long> | 
val userIp : kotlin.String = userIp_example // kotlin.String | The user's IP to determine the closest CDN. Optional.
val appendName : kotlin.Boolean = true // kotlin.Boolean | If you want to add the \"filename\" parameter to the returned CDN link. Optional. Default false.
val requestDownloadBatch : RequestDownloadBatch = {file_ids=[0, 1, 2]} // RequestDownloadBatch | 
try {
    val result : RequestWebDownloadLinksPostResponse = apiInstance.requestWebDownloadLinksPost(token, webId, fileIds, userIp, appendName, requestDownloadBatch)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WebDownloadsApi#requestWebDownloadLinksPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WebDownloadsApi#requestWebDownloadLinksPost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **token** | **kotlin.String**| Your API Key | |
| **webId** | **kotlin.Long**| The web downloads&#39; ID that you want to download | |
| **fileIds** | [**kotlin.collections.List&lt;kotlin.Long&gt;**](kotlin.Long.md)|  | [optional] |
| **userIp** | **kotlin.String**| The user&#39;s IP to determine the closest CDN. Optional. | [optional] |
| **appendName** | **kotlin.Boolean**| If you want to add the \&quot;filename\&quot; parameter to the returned CDN link. Optional. Default false. | [optional] [default to false] |
| **requestDownloadBatch** | [**RequestDownloadBatch**](RequestDownloadBatch.md)|  | [optional] |

### Return type

[**RequestWebDownloadLinksPostResponse**](RequestWebDownloadLinksPostResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

