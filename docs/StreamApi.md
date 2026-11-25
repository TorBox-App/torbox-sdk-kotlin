# StreamApi

All URIs are relative to *https://api.torbox.app*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createStream**](StreamApi.md#createStream) | **GET** /v1/api/stream/createstream | Create Stream |
| [**getStreamData**](StreamApi.md#getStreamData) | **GET** /v1/api/stream/getstreamdata | Get Stream Data |


<a id="createStream"></a>
# **createStream**
> CreateStreamResponse createStream(id, fileId, type, chosenSubtitleIndex, chosenAudioIndex, chosenResolutionIndex, scrobblingEnabled)

Create Stream

### Overview  Creates a new stream based off of the data provided.  #### Selecting Subtitles and Audios  We use indexes to determine which audio and subtitle you would like to select. To view all available indexes, you must request this endpoint intially with \&quot;null\&quot; or 0, for the chosen indexes. This will return a metadata dictionary in the response, which will contain the list of audios and subtitles available for this stream. When choosing a subtitle or audio stream, use the **relative index**, starting from 0, rather than the \&quot;index\&quot; value. This is important for selecting the correct index. Once your user gets a selection of audios and subtitles available, you can submit this to the endpoint again to get the chosen stream.  - **null** - Selecting no subtitle. Not available for audio as one must always be selected.  - **0** - Selecting first subtitle or audio   #### Selecting Resolution  Similar to the subtitles and audios, we use indexes to determine the resolution chosen. Unlike the above, these are predetermined. We do not upscale video, so if for example, you pass a 1080p video, and request it with resolution, 7, it will stay at 1080p. Please see the below for options.  - **null** - Original video resolution. No downscaling will take place.  - **0** - 144p  - **1** - 240p  - **2** - 360p  - **3** - 480p  - **4** - 720p  - **5** - 1080p  - **6** - 1440p  - **7** - 2160p   #### Types  This endpoint allows you to handle torrents, usenet and web downloads all in one. This is why the \&quot;type\&quot; parameter is available. It defaults to \&quot;torrent\&quot;.  - **torrent** - Torrents  - **usenet** - Usenet downloads  - **webdownload** - Web Downloads   #### Important Notes  - Only text based subtitles are supported. If a non-text based subtitle is selected, it will be ignored.  - If a subtitle or audio index does not exist on the stream, it will be ignored.  - There are a lot of edge-case videos, if something doesn&#39;t work, don&#39;t hesitate to report the download hash and file_id of the failing video file.  - This is a **Pro** only feature.   ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = StreamApi()
val id : kotlin.Long = 789 // kotlin.Long | The ID of the type of download.
val fileId : kotlin.Long = 789 // kotlin.Long | The file ID inside of the download you would like to stream.
val type : kotlin.String = type_example // kotlin.String | The type of download that this is. If choosing the incorrect one, the ID will be incorrect.
val chosenSubtitleIndex : kotlin.String = chosenSubtitleIndex_example // kotlin.String | The relative index of the subtitle you would like to stream. This is default null for none. 0 is the first subtitle found.
val chosenAudioIndex : kotlin.Long = 789 // kotlin.Long | The relative index of the subtitle you would like to stream. Defaults to 0 for the first audio stream found inside the file. Cannot be null.
val chosenResolutionIndex : kotlin.String = chosenResolutionIndex_example // kotlin.String | The index of the resolution you would like to stream. This is default null for original.
val scrobblingEnabled : kotlin.Boolean = true // kotlin.Boolean | 
try {
    val result : CreateStreamResponse = apiInstance.createStream(id, fileId, type, chosenSubtitleIndex, chosenAudioIndex, chosenResolutionIndex, scrobblingEnabled)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling StreamApi#createStream")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling StreamApi#createStream")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.Long**| The ID of the type of download. | |
| **fileId** | **kotlin.Long**| The file ID inside of the download you would like to stream. | [optional] [default to 0L] |
| **type** | **kotlin.String**| The type of download that this is. If choosing the incorrect one, the ID will be incorrect. | [optional] [default to &quot;torrent&quot;] |
| **chosenSubtitleIndex** | **kotlin.String**| The relative index of the subtitle you would like to stream. This is default null for none. 0 is the first subtitle found. | [optional] |
| **chosenAudioIndex** | **kotlin.Long**| The relative index of the subtitle you would like to stream. Defaults to 0 for the first audio stream found inside the file. Cannot be null. | [optional] [default to 0L] |
| **chosenResolutionIndex** | **kotlin.String**| The index of the resolution you would like to stream. This is default null for original. | [optional] |
| **scrobblingEnabled** | **kotlin.Boolean**|  | [optional] [default to true] |

### Return type

[**CreateStreamResponse**](CreateStreamResponse.md)

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

<a id="getStreamData"></a>
# **getStreamData**
> GetStreamDataResponse getStreamData(token, presignedToken, chosenSubtitleIndex, chosenAudioIndex, chosenResolutionIndex)

Get Stream Data

### Overview  Gets stream data from an already created stream. Requires the presigned token and user API token from the original request.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = StreamApi()
val token : kotlin.String = token_example // kotlin.String | The user's API token, can also be used from the original, /createstream request.
val presignedToken : kotlin.String = presignedToken_example // kotlin.String | The presigned token given from the original, /createstream request.
val chosenSubtitleIndex : kotlin.String = chosenSubtitleIndex_example // kotlin.String | The chosen subtitle index that you are requesting information about.
val chosenAudioIndex : kotlin.Long = 789 // kotlin.Long | The chosen audio index that you are requesting information about.
val chosenResolutionIndex : kotlin.String = chosenResolutionIndex_example // kotlin.String | The index of the resolution you would like to stream. This is default null for original.
try {
    val result : GetStreamDataResponse = apiInstance.getStreamData(token, presignedToken, chosenSubtitleIndex, chosenAudioIndex, chosenResolutionIndex)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling StreamApi#getStreamData")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling StreamApi#getStreamData")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **token** | **kotlin.String**| The user&#39;s API token, can also be used from the original, /createstream request. | |
| **presignedToken** | **kotlin.String**| The presigned token given from the original, /createstream request. | |
| **chosenSubtitleIndex** | **kotlin.String**| The chosen subtitle index that you are requesting information about. | [optional] |
| **chosenAudioIndex** | **kotlin.Long**| The chosen audio index that you are requesting information about. | [optional] [default to 0L] |
| **chosenResolutionIndex** | **kotlin.String**| The index of the resolution you would like to stream. This is default null for original. | [optional] |

### Return type

[**GetStreamDataResponse**](GetStreamDataResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

