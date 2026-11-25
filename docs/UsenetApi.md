# UsenetApi

All URIs are relative to *https://api.torbox.app*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**asyncCreateUsenetDownload**](UsenetApi.md#asyncCreateUsenetDownload) | **POST** /v1/api/usenet/asynccreateusenetdownload | Async Create Usenet Download |
| [**controlUsenetDownload**](UsenetApi.md#controlUsenetDownload) | **POST** /v1/api/usenet/controlusenetdownload | Control Usenet Download |
| [**createUsenetDownload**](UsenetApi.md#createUsenetDownload) | **POST** /v1/api/usenet/createusenetdownload | Create Usenet Download |
| [**editUsenetItem**](UsenetApi.md#editUsenetItem) | **PUT** /v1/api/usenet/editusenetdownload | Edit Usenet Item |
| [**getNewsServerAccount**](UsenetApi.md#getNewsServerAccount) | **GET** /v1/api/usenet/provider/account | Get News Server Account |
| [**getNewsServerConnectionInformation**](UsenetApi.md#getNewsServerConnectionInformation) | **GET** /v1/api/usenet/provider/connection | Get News Server Connection Information |
| [**getUsenetCachedAvailability**](UsenetApi.md#getUsenetCachedAvailability) | **GET** /v1/api/usenet/checkcached | Get Usenet Cached Availability |
| [**getUsenetCachedAvailabilityBatch**](UsenetApi.md#getUsenetCachedAvailabilityBatch) | **POST** /v1/api/usenet/checkcached | Get Usenet Cached Availability Batch |
| [**getUsenetList**](UsenetApi.md#getUsenetList) | **GET** /v1/api/usenet/mylist | Get Usenet List |
| [**requestUsenetDownloadLink**](UsenetApi.md#requestUsenetDownloadLink) | **GET** /v1/api/usenet/requestdl | Request Download Link |
| [**requestUsenetDownloadLinksGet**](UsenetApi.md#requestUsenetDownloadLinksGet) | **GET** /v1/api/usenet/requestdl/batch | Request Download Links - GET |
| [**requestUsenetDownloadLinksPost**](UsenetApi.md#requestUsenetDownloadLinksPost) | **POST** /v1/api/usenet/requestdl/batch | Request Download Links - POST |
| [**resetNewsServerAccountPassword**](UsenetApi.md#resetNewsServerAccountPassword) | **POST** /v1/api/usenet/provider/account/resetpw | Reset News Server Account Password |


<a id="asyncCreateUsenetDownload"></a>
# **asyncCreateUsenetDownload**
> AsyncCreateUsenetDownloadResponse asyncCreateUsenetDownload(link, file, name, password, postProcessing, asQueued, addOnlyIfCached)

Async Create Usenet Download

### Overview  Creates a usenet download asynchronously under your account. Simply send **either** a link, or an nzb file. Once they have been checked, they will begin downloading assuming your account has available active download slots, and they aren&#39;t too large.  The request will return instantly, not returning any data other than a success message. This is the same for failures, as they will return the error in the background as a notification, rather than immediately.  The post processing options are the same as for the Create Usenet Download endpoint.  ### Rate Limits  This endpoint is rate limited to **60 requests per hour** per API token.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UsenetApi()
val link : kotlin.String = link_example // kotlin.String | An accessible link to an NZB file. Cannot be a redirection. Optional.
val file : java.io.File = BINARY_DATA_HERE // java.io.File | An NZB File. Optional.
val name : kotlin.String = name_example // kotlin.String | The name you want the usenet download to be. Optional.
val password : kotlin.String = password_example // kotlin.String | The password to send to the Usenet client. This is used for extracting the RAR at the end. Optional.
val postProcessing : kotlin.Long = 789 // kotlin.Long | The post processing option to use. Read the overview of the Create Usenet Download endpoint for the options. Default is -1. Optional.
val asQueued : kotlin.Boolean = true // kotlin.Boolean | Tells TorBox you want this usenet download instantly queued. Optional.
val addOnlyIfCached : kotlin.Boolean = true // kotlin.Boolean | Only adds the download if it is cached on TorBox. If not cached, it won't be added.
try {
    val result : AsyncCreateUsenetDownloadResponse = apiInstance.asyncCreateUsenetDownload(link, file, name, password, postProcessing, asQueued, addOnlyIfCached)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsenetApi#asyncCreateUsenetDownload")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsenetApi#asyncCreateUsenetDownload")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **link** | **kotlin.String**| An accessible link to an NZB file. Cannot be a redirection. Optional. | [optional] |
| **file** | **java.io.File**| An NZB File. Optional. | [optional] |
| **name** | **kotlin.String**| The name you want the usenet download to be. Optional. | [optional] |
| **password** | **kotlin.String**| The password to send to the Usenet client. This is used for extracting the RAR at the end. Optional. | [optional] |
| **postProcessing** | **kotlin.Long**| The post processing option to use. Read the overview of the Create Usenet Download endpoint for the options. Default is -1. Optional. | [optional] [default to -1L] |
| **asQueued** | **kotlin.Boolean**| Tells TorBox you want this usenet download instantly queued. Optional. | [optional] [default to false] |
| **addOnlyIfCached** | **kotlin.Boolean**| Only adds the download if it is cached on TorBox. If not cached, it won&#39;t be added. | [optional] [default to false] |

### Return type

[**AsyncCreateUsenetDownloadResponse**](AsyncCreateUsenetDownloadResponse.md)

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

<a id="controlUsenetDownload"></a>
# **controlUsenetDownload**
> ControlUsenetDownloadResponse controlUsenetDownload(controlUsenetDownload)

Control Usenet Download

### Overview  Controls a usenet download. By sending the usenet download&#39;s ID and the type of operation you want to perform, it will send that request to the usenet client.  Operations are either:  - **Delete** &#x60;deletes the nzb from the client and your account permanently&#x60;   ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UsenetApi()
val controlUsenetDownload : ControlUsenetDownload = {"usenet_id":1,"operation":"delete","all":false} // ControlUsenetDownload | 
try {
    val result : ControlUsenetDownloadResponse = apiInstance.controlUsenetDownload(controlUsenetDownload)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsenetApi#controlUsenetDownload")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsenetApi#controlUsenetDownload")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **controlUsenetDownload** | [**ControlUsenetDownload**](ControlUsenetDownload.md)|  | |

### Return type

[**ControlUsenetDownloadResponse**](ControlUsenetDownloadResponse.md)

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

<a id="createUsenetDownload"></a>
# **createUsenetDownload**
> CreateUsenetDownloadResponse createUsenetDownload(link, file, name, password, postProcessing, asQueued, addOnlyIfCached)

Create Usenet Download

### Overview  Creates a usenet download under your account. Simply send **either** a link, or an nzb file. Once they have been checked, they will begin downloading assuming your account has available active download slots, and they aren&#39;t too large.  #### Post Processing Options:  All post processing options that the Usenet client will perform before TorBox&#39;s own processing to make the files available. It is recommended you either don&#39;t send this parameter, or keep it at &#x60;-1&#x60; for default, which will give only the wanted files.  - &#x60;-1&#x60;, Default. This runs repairs, and extractions as well as deletes the source files leaving only the wanted downloaded files.  - &#x60;0&#x60;, None. No post-processing at all. Just download all the files (including all PAR2). TorBox will still do its normal processing to make the download available, but no repairs, or extraction will take place.  - &#x60;1&#x60;, Repair. Download files and do a PAR2 verification. If the verification fails, download more PAR2 files and attempt to repair the files.  - &#x60;2&#x60;, Repair and Unpack. Download all files, do a PAR2 verification and unpack the files. The final folder will also include the RAR and ZIP files.  - &#x60;3&#x60;, Repair, Unpack and Delete. Download all files, do a PAR2 verification, unpack the files to the final folder and delete the source files.   ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UsenetApi()
val link : kotlin.String = link_example // kotlin.String | An accessible link to an NZB file. Cannot be a redirection. Optional.
val file : java.io.File = BINARY_DATA_HERE // java.io.File | An NZB File. Optional.
val name : kotlin.String = name_example // kotlin.String | The name you want the usenet download to be. Optional.
val password : kotlin.String = password_example // kotlin.String | The password to send to the Usenet client. This is used for extracting the RAR at the end. Optional.
val postProcessing : kotlin.Long = 789 // kotlin.Long | The post processing option to use. Read the overview for the options. Default is -1. Optional.
val asQueued : kotlin.Boolean = true // kotlin.Boolean | Tells TorBox you want this usenet download.instantly queued. Optional.
val addOnlyIfCached : kotlin.Boolean = true // kotlin.Boolean | Only adds the download if it is cached on TorBox. If not cached, it won't be added.
try {
    val result : CreateUsenetDownloadResponse = apiInstance.createUsenetDownload(link, file, name, password, postProcessing, asQueued, addOnlyIfCached)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsenetApi#createUsenetDownload")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsenetApi#createUsenetDownload")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **link** | **kotlin.String**| An accessible link to an NZB file. Cannot be a redirection. Optional. | [optional] |
| **file** | **java.io.File**| An NZB File. Optional. | [optional] |
| **name** | **kotlin.String**| The name you want the usenet download to be. Optional. | [optional] |
| **password** | **kotlin.String**| The password to send to the Usenet client. This is used for extracting the RAR at the end. Optional. | [optional] |
| **postProcessing** | **kotlin.Long**| The post processing option to use. Read the overview for the options. Default is -1. Optional. | [optional] [default to -1L] |
| **asQueued** | **kotlin.Boolean**| Tells TorBox you want this usenet download.instantly queued. Optional. | [optional] [default to false] |
| **addOnlyIfCached** | **kotlin.Boolean**| Only adds the download if it is cached on TorBox. If not cached, it won&#39;t be added. | [optional] [default to false] |

### Return type

[**CreateUsenetDownloadResponse**](CreateUsenetDownloadResponse.md)

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

<a id="editUsenetItem"></a>
# **editUsenetItem**
> EditUsenetItemResponse editUsenetItem(editUsenetDownload)

Edit Usenet Item

### Overview  Updates a download item based on the item&#39;s ID. Sending a PUT request with valid items overwrites the previous items entirely, so use this endpoint with caution. Please make sure to read the restrictions below as they are important.  ### Restrictions  - Does not affect the cached database (or any other user&#39;s item).  - Name must pass validation:      - Above 1 character long.      - Below 200 characters long.      - Cannot contain any non-url or non filesystem safe characters. (This is removed automatically).      - Cannot contain any leading or trailing whitespace. You can have spaces in the middle. (This is removed automatically).  - Tags follow the same rules as the name.  - Alternative hashes must be of MD5, SHA1, or SHA256.   ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UsenetApi()
val editUsenetDownload : EditUsenetDownload = {"usenet_download_id":0,"name":"string","tags":["string"],"alternative_hashes":["0123456789abcdef0123456789abcdef01234567"],"airlocked":false} // EditUsenetDownload | 
try {
    val result : EditUsenetItemResponse = apiInstance.editUsenetItem(editUsenetDownload)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsenetApi#editUsenetItem")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsenetApi#editUsenetItem")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **editUsenetDownload** | [**EditUsenetDownload**](EditUsenetDownload.md)|  | |

### Return type

[**EditUsenetItemResponse**](EditUsenetItemResponse.md)

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

<a id="getNewsServerAccount"></a>
# **getNewsServerAccount**
> GetNewsServerAccountResponse getNewsServerAccount()

Get News Server Account

### Overview  Gets the user&#39;s TorBox News Server Account with authentication details. Does not show password if not creating the account. Account creation happens on the first request. If you need to get the password, or reset the password, use the &#x60;/usenet/provider/account/resetpw&#x60; &#x60;POST&#x60; endpoint.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UsenetApi()
try {
    val result : GetNewsServerAccountResponse = apiInstance.getNewsServerAccount()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsenetApi#getNewsServerAccount")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsenetApi#getNewsServerAccount")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetNewsServerAccountResponse**](GetNewsServerAccountResponse.md)

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

<a id="getNewsServerConnectionInformation"></a>
# **getNewsServerConnectionInformation**
> GetNewsServerConnectionInformationResponse getNewsServerConnectionInformation()

Get News Server Connection Information

### Overview  Gets the TorBox News Server Connection information. This is a static path, and is not dynamic.  ### Authorization  No authentication required. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UsenetApi()
try {
    val result : GetNewsServerConnectionInformationResponse = apiInstance.getNewsServerConnectionInformation()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsenetApi#getNewsServerConnectionInformation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsenetApi#getNewsServerConnectionInformation")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetNewsServerConnectionInformationResponse**](GetNewsServerConnectionInformationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getUsenetCachedAvailability"></a>
# **getUsenetCachedAvailability**
> GetUsenetCachedAvailabilityResponse getUsenetCachedAvailability(hash, format, listFiles, checkCached)

Get Usenet Cached Availability

### Overview  Takes in a list of comma separated usenet hashes and checks if the usenet download is cached. This endpoint only gets a max of around 100 at a time, due to http limits in queries. If you want to do more, you can simply do more hash queries. Such as: &#x60;?hash&#x3D;XXXX&amp;hash&#x3D;XXXX&amp;hash&#x3D;XXXX&#x60;  or &#x60;?hash&#x3D;XXXX,XXXX&amp;hash&#x3D;XXXX&amp;hash&#x3D;XXXX,XXXX&#x60; and this will work too. Performance is very fast. Less than 1 second per 100. Time is approximately O(log n) time for those interested in taking it to its max. That is without caching as well. This endpoint stores a cache for an hour.  You may also pass a &#x60;format&#x60; parameter with the format you want the data in. Options are either &#x60;object&#x60; or &#x60;list&#x60;. You can view examples of both below.  To get the hash of a usenet download, you can read [this document](https://support.torbox.app/en/articles/13681109-technical-getting-hashes-for-searches) for all of the strategies.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UsenetApi()
val hash : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | The list of usenet hashes you want to check. Comma seperated. To find the hash, md5 the link of the usenet link or file.
val format : kotlin.String = format_example // kotlin.String | Format you want the data in. Acceptable is either \"object\" or \"list\". List is the most performant option as it doesn't require modification of the list.
val listFiles : kotlin.Boolean = true // kotlin.Boolean | Allows you to list the files found inside the cached data. Optional.
val checkCached : CheckCached =  // CheckCached | 
try {
    val result : GetUsenetCachedAvailabilityResponse = apiInstance.getUsenetCachedAvailability(hash, format, listFiles, checkCached)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsenetApi#getUsenetCachedAvailability")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsenetApi#getUsenetCachedAvailability")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **hash** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| The list of usenet hashes you want to check. Comma seperated. To find the hash, md5 the link of the usenet link or file. | [optional] |
| **format** | **kotlin.String**| Format you want the data in. Acceptable is either \&quot;object\&quot; or \&quot;list\&quot;. List is the most performant option as it doesn&#39;t require modification of the list. | [optional] [default to &quot;object&quot;] |
| **listFiles** | **kotlin.Boolean**| Allows you to list the files found inside the cached data. Optional. | [optional] [default to false] |
| **checkCached** | [**CheckCached**](CheckCached.md)|  | [optional] |

### Return type

[**GetUsenetCachedAvailabilityResponse**](GetUsenetCachedAvailabilityResponse.md)

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

<a id="getUsenetCachedAvailabilityBatch"></a>
# **getUsenetCachedAvailabilityBatch**
> GetUsenetCachedAvailabilityBatchResponse getUsenetCachedAvailabilityBatch(hash, format, listFiles, checkCached)

Get Usenet Cached Availability Batch

### Overview  Takes in a list of comma separated hashes and checks if the torrent is cached. With the POST endpoint you can submit a nearly unlimited hashes compared to the GET endpoint which is limited by url parameters.  Performance is very fast. Less than 1 second per 100. Time is approximately O(log n) time for those interested in taking it to its max. That is without caching as well. This endpoint stores a cache for an hour.  You may also pass a &#x60;format&#x60; parameter with the format you want the data in. Options are either &#x60;object&#x60; or &#x60;list&#x60;. You can view examples of both below.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UsenetApi()
val hash : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
val format : kotlin.String = format_example // kotlin.String | 
val listFiles : kotlin.Boolean = true // kotlin.Boolean | 
val checkCached : CheckCached = {hashes=[string]} // CheckCached | 
try {
    val result : GetUsenetCachedAvailabilityBatchResponse = apiInstance.getUsenetCachedAvailabilityBatch(hash, format, listFiles, checkCached)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsenetApi#getUsenetCachedAvailabilityBatch")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsenetApi#getUsenetCachedAvailabilityBatch")
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

[**GetUsenetCachedAvailabilityBatchResponse**](GetUsenetCachedAvailabilityBatchResponse.md)

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

<a id="getUsenetList"></a>
# **getUsenetList**
> GetUsenetListResponse getUsenetList(id, bypassCache, offset, limit, files, active)

Get Usenet List

### Overview  Gets the user&#39;s usenet download list. This gives you the needed information to perform other usenet actions. Unlike Torrents, this information is updated on its own every 5 seconds for live usenet downloads.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UsenetApi()
val id : kotlin.Long = 789 // kotlin.Long | Determines the usenet download requested, will return an object rather than list. Optional.
val bypassCache : kotlin.Boolean = true // kotlin.Boolean | Allows you to bypass the cached data, and always get fresh information. Useful if constantly querying for fresh download stats. Otherwise, we request that you save our database a few calls.
val offset : kotlin.Long = 789 // kotlin.Long | Determines the offset of items to get from the database. Default is 0. Optional.
val limit : kotlin.Long = 789 // kotlin.Long | Determines the number of items to recieve per request. Default is 1000. Optional.
val files : kotlin.Boolean = true // kotlin.Boolean | Exclude files from response. Optional
val active : kotlin.Boolean = true // kotlin.Boolean | Shows only active downloads. Optional
try {
    val result : GetUsenetListResponse = apiInstance.getUsenetList(id, bypassCache, offset, limit, files, active)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsenetApi#getUsenetList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsenetApi#getUsenetList")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.Long**| Determines the usenet download requested, will return an object rather than list. Optional. | [optional] |
| **bypassCache** | **kotlin.Boolean**| Allows you to bypass the cached data, and always get fresh information. Useful if constantly querying for fresh download stats. Otherwise, we request that you save our database a few calls. | [optional] [default to false] |
| **offset** | **kotlin.Long**| Determines the offset of items to get from the database. Default is 0. Optional. | [optional] [default to 0L] |
| **limit** | **kotlin.Long**| Determines the number of items to recieve per request. Default is 1000. Optional. | [optional] [default to 1000L] |
| **files** | **kotlin.Boolean**| Exclude files from response. Optional | [optional] [default to true] |
| **active** | **kotlin.Boolean**| Shows only active downloads. Optional | [optional] |

### Return type

[**GetUsenetListResponse**](GetUsenetListResponse.md)

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

<a id="requestUsenetDownloadLink"></a>
# **requestUsenetDownloadLink**
> RequestUsenetDownloadLinkResponse requestUsenetDownloadLink(token, usenetId, fileId, zipLink, userIp, redirect, appendName)

Request Download Link

### Overview  Requests the download link from the server. Because downloads are metered, TorBox cannot afford to allow free access to the links directly. This endpoint opens the link for 3 hours for downloads. Once a download is started, the user has nearly unlilimited time to download the file. The 1 hour time limit is simply for starting downloads. This prevents long term link sharing.  ### Permalinks  Instead of generating many CDN urls by requesting this endpoint, you can instead create a permalink such as: &#x60;https://api.torbox.app/v1/api/torrents/requestdl?token&#x3D;APIKEY&amp;torrent_id&#x3D;NUMBER&amp;file_id&#x3D;NUMBER&amp;redirect&#x3D;true&#x60; and when a user clicks on it, it will automatically redirect them to the CDN link. This saves requests and doesn&#39;t abuse the API. Use this method rather than saving CDN links as they are not permanent. To invalidate these permalinks, simply reset your API token or delete the item from your dashboard.  ### Authorization  Requires an API key as a parameter for the &#x60;token&#x60; parameter. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UsenetApi()
val token : kotlin.String = token_example // kotlin.String | Your API Key
val usenetId : kotlin.Long = 789 // kotlin.Long | The usenet download's ID that you want to download
val fileId : kotlin.Long = 789 // kotlin.Long | The files's ID that you want to download. Optional if using \"zip_link\".
val zipLink : kotlin.Boolean = true // kotlin.Boolean | If you want a zip link. Required if no file_id. Takes precedence over file_id if both are given.
val userIp : kotlin.String = userIp_example // kotlin.String | The user's IPv4 to determine the closest CDN. Optional.
val redirect : kotlin.Boolean = true // kotlin.Boolean | If you want to redirect the user to the CDN link. This is useful for creating permalinks so that you can just make this request URL the link.
val appendName : kotlin.Boolean = true // kotlin.Boolean | If you want to add the \"filename\" parameter to the returned CDN link. Optional. Default false.
try {
    val result : RequestUsenetDownloadLinkResponse = apiInstance.requestUsenetDownloadLink(token, usenetId, fileId, zipLink, userIp, redirect, appendName)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsenetApi#requestUsenetDownloadLink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsenetApi#requestUsenetDownloadLink")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **token** | **kotlin.String**| Your API Key | |
| **usenetId** | **kotlin.Long**| The usenet download&#39;s ID that you want to download | |
| **fileId** | **kotlin.Long**| The files&#39;s ID that you want to download. Optional if using \&quot;zip_link\&quot;. | [optional] [default to 0L] |
| **zipLink** | **kotlin.Boolean**| If you want a zip link. Required if no file_id. Takes precedence over file_id if both are given. | [optional] [default to false] |
| **userIp** | **kotlin.String**| The user&#39;s IPv4 to determine the closest CDN. Optional. | [optional] |
| **redirect** | **kotlin.Boolean**| If you want to redirect the user to the CDN link. This is useful for creating permalinks so that you can just make this request URL the link. | [optional] [default to false] |
| **appendName** | **kotlin.Boolean**| If you want to add the \&quot;filename\&quot; parameter to the returned CDN link. Optional. Default false. | [optional] [default to false] |

### Return type

[**RequestUsenetDownloadLinkResponse**](RequestUsenetDownloadLinkResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="requestUsenetDownloadLinksGet"></a>
# **requestUsenetDownloadLinksGet**
> RequestUsenetDownloadLinksGetResponse requestUsenetDownloadLinksGet(token, usenetId, fileIds, userIp, appendName, requestDownloadBatch)

Request Download Links - GET

### Overview  Requests multiple download links from the server. Because downloads are metered, TorBox cannot afford to allow free access to the links directly. This endpoint opens the link for 3 hours for downloads. Once a download is started, the user has nearly unlilimited time to download the file. The 1 hour time limit is simply for starting downloads. This prevents long term link sharing.  ### Authorization  Requires an API key as a parameter for the &#x60;token&#x60; parameter. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UsenetApi()
val token : kotlin.String = token_example // kotlin.String | Your API Key
val usenetId : kotlin.Long = 789 // kotlin.Long | The usenet download's ID that you want to download
val fileIds : kotlin.collections.List<kotlin.Long> =  // kotlin.collections.List<kotlin.Long> | The files's ID that you want to download
val userIp : kotlin.String = userIp_example // kotlin.String | The user's IP to determine the closest CDN. Optional.
val appendName : kotlin.Boolean = true // kotlin.Boolean | If you want to add the \"filename\" parameter to the returned CDN link. Optional. Default false.
val requestDownloadBatch : RequestDownloadBatch =  // RequestDownloadBatch | 
try {
    val result : RequestUsenetDownloadLinksGetResponse = apiInstance.requestUsenetDownloadLinksGet(token, usenetId, fileIds, userIp, appendName, requestDownloadBatch)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsenetApi#requestUsenetDownloadLinksGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsenetApi#requestUsenetDownloadLinksGet")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **token** | **kotlin.String**| Your API Key | |
| **usenetId** | **kotlin.Long**| The usenet download&#39;s ID that you want to download | |
| **fileIds** | [**kotlin.collections.List&lt;kotlin.Long&gt;**](kotlin.Long.md)| The files&#39;s ID that you want to download | [optional] |
| **userIp** | **kotlin.String**| The user&#39;s IP to determine the closest CDN. Optional. | [optional] |
| **appendName** | **kotlin.Boolean**| If you want to add the \&quot;filename\&quot; parameter to the returned CDN link. Optional. Default false. | [optional] [default to false] |
| **requestDownloadBatch** | [**RequestDownloadBatch**](RequestDownloadBatch.md)|  | [optional] |

### Return type

[**RequestUsenetDownloadLinksGetResponse**](RequestUsenetDownloadLinksGetResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="requestUsenetDownloadLinksPost"></a>
# **requestUsenetDownloadLinksPost**
> RequestUsenetDownloadLinksPostResponse requestUsenetDownloadLinksPost(token, usenetId, fileIds, userIp, appendName, requestDownloadBatch)

Request Download Links - POST

### Overview  Requests multiple download links from the server. Because downloads are metered, TorBox cannot afford to allow free access to the links directly. This endpoint opens the link for 3 hours for downloads. Once a download is started, the user has nearly unlilimited time to download the file. The 1 hour time limit is simply for starting downloads. This prevents long term link sharing.  ### Authorization  Requires an API key as a parameter for the &#x60;token&#x60; parameter. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UsenetApi()
val token : kotlin.String = token_example // kotlin.String | Your API Key
val usenetId : kotlin.Long = 789 // kotlin.Long | The usenet downloads' ID that you want to download
val fileIds : kotlin.collections.List<kotlin.Long> =  // kotlin.collections.List<kotlin.Long> | 
val userIp : kotlin.String = userIp_example // kotlin.String | The user's IP to determine the closest CDN. Optional.
val appendName : kotlin.Boolean = true // kotlin.Boolean | If you want to add the \"filename\" parameter to the returned CDN link. Optional. Default false.
val requestDownloadBatch : RequestDownloadBatch = {file_ids=[0, 1, 2]} // RequestDownloadBatch | 
try {
    val result : RequestUsenetDownloadLinksPostResponse = apiInstance.requestUsenetDownloadLinksPost(token, usenetId, fileIds, userIp, appendName, requestDownloadBatch)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsenetApi#requestUsenetDownloadLinksPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsenetApi#requestUsenetDownloadLinksPost")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **token** | **kotlin.String**| Your API Key | |
| **usenetId** | **kotlin.Long**| The usenet downloads&#39; ID that you want to download | |
| **fileIds** | [**kotlin.collections.List&lt;kotlin.Long&gt;**](kotlin.Long.md)|  | [optional] |
| **userIp** | **kotlin.String**| The user&#39;s IP to determine the closest CDN. Optional. | [optional] |
| **appendName** | **kotlin.Boolean**| If you want to add the \&quot;filename\&quot; parameter to the returned CDN link. Optional. Default false. | [optional] [default to false] |
| **requestDownloadBatch** | [**RequestDownloadBatch**](RequestDownloadBatch.md)|  | [optional] |

### Return type

[**RequestUsenetDownloadLinksPostResponse**](RequestUsenetDownloadLinksPostResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="resetNewsServerAccountPassword"></a>
# **resetNewsServerAccountPassword**
> ResetNewsServerAccountPasswordResponse resetNewsServerAccountPassword()

Reset News Server Account Password

### Overview  Resets the user&#39;s TorBox News Server account password. This password is automatically generated, and is not saved, it is only shown once.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = UsenetApi()
try {
    val result : ResetNewsServerAccountPasswordResponse = apiInstance.resetNewsServerAccountPassword()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UsenetApi#resetNewsServerAccountPassword")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UsenetApi#resetNewsServerAccountPassword")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ResetNewsServerAccountPasswordResponse**](ResetNewsServerAccountPasswordResponse.md)

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

