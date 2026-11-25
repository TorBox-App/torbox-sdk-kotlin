# RssApi

All URIs are relative to *https://api.torbox.app*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**addRssFeed**](RssApi.md#addRssFeed) | **POST** /v1/api/rss/addrss | Add RSS Feed |
| [**controlRssFeed**](RssApi.md#controlRssFeed) | **POST** /v1/api/rss/controlrss | Control RSS Feed |
| [**editRssFeed**](RssApi.md#editRssFeed) | **POST** /v1/api/rss/modifyrss | Edit RSS Feed |
| [**getRssFeedItems**](RssApi.md#getRssFeedItems) | **GET** /v1/api/rss/getfeeditems | Get RSS Feed Items |
| [**getUserRssFeeds**](RssApi.md#getUserRssFeeds) | **GET** /v1/api/rss/getfeeds | Get User RSS Feeds |


<a id="addRssFeed"></a>
# **addRssFeed**
> AddRssFeedResponse addRssFeed(addRss)

Add RSS Feed

### Overview  Allows adding an RSS feed to your account. This API gives you a lot of customization options, but is best used with the UI on the website. This endpoint only works for Pro users (plan: 2).  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = RssApi()
val addRss : AddRss = {"url":"https://example.com/feed.xml","name":"string","do_regex":"string","dont_regex":"string","dont_older_than":0,"scan_interval":0,"pass_check":false,"rss_type":"torrent","torrent_seeding":1} // AddRss | 
try {
    val result : AddRssFeedResponse = apiInstance.addRssFeed(addRss)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RssApi#addRssFeed")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RssApi#addRssFeed")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **addRss** | [**AddRss**](AddRss.md)|  | |

### Return type

[**AddRssFeedResponse**](AddRssFeedResponse.md)

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

<a id="controlRssFeed"></a>
# **controlRssFeed**
> ControlRssFeedResponse controlRssFeed(controlRss)

Control RSS Feed

### Overview  Controls an RSS Feed. By sending the RSS feed&#39;s ID and the type of operation you want to perform, it will perform said action on the RSS feed checker.  Operations are either:  - **Update** &#x60;forces an update on the rss feed&#x60; - **Delete** &#x60;deletes the rss feed from your account permanently. This also deletes all associated RSS feed items. This does not remove queued items spawned from the RSS feed.&#x60; - **Pause** &#x60;pauses checking the rss feed on the scan interval&#x60; - **Resume** &#x60;resumes a paused rss feed&#x60;   ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = RssApi()
val controlRss : ControlRss = {"operation":"pause","rss_feed_id":0} // ControlRss | 
try {
    val result : ControlRssFeedResponse = apiInstance.controlRssFeed(controlRss)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RssApi#controlRssFeed")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RssApi#controlRssFeed")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **controlRss** | [**ControlRss**](ControlRss.md)|  | |

### Return type

[**ControlRssFeedResponse**](ControlRssFeedResponse.md)

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

<a id="editRssFeed"></a>
# **editRssFeed**
> EditRssFeedResponse editRssFeed(modifyRss)

Edit RSS Feed

### Overview  Allows you to edit the RSS feed based on the RSS feed ID passed. Allows you to change everything about an RSS feed, except for the URL.  When updating the \&quot;rss_type\&quot; or the \&quot;torrent_seeding\&quot; options, it will update all of the RSS items associated with the RSS feed, including all previous items.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = RssApi()
val modifyRss : ModifyRss = {"rss_feed_id":0,"name":"string","do_regex":"string","dont_regex":"string","dont_older_than":0,"scan_interval":0,"rss_type":"torrent","torrent_seeding":1} // ModifyRss | 
try {
    val result : EditRssFeedResponse = apiInstance.editRssFeed(modifyRss)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RssApi#editRssFeed")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RssApi#editRssFeed")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **modifyRss** | [**ModifyRss**](ModifyRss.md)|  | |

### Return type

[**EditRssFeedResponse**](EditRssFeedResponse.md)

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

<a id="getRssFeedItems"></a>
# **getRssFeedItems**
> GetRssFeedItemsResponse getRssFeedItems(rssFeedId)

Get RSS Feed Items

### Overview  Gets the first 10,000 RSS feed items associated with an RSS feed. RSS feed items are scraped items from the RSS feed. They contain a direct download link as well as the content name, and additional information.  ##### Type Key  The \&quot;type\&quot; key in the response is used for showing what type of downloads this RSS feed item is. This affects how the item is downloaded, as well as what is scraped, so make sure it is correct. When the parent RSS feed&#39;s type is changed, it changes all of the items types as well.  - **\&quot;**torrent**\&quot;** &#x60;uses .torrent files and magnet links and adds as torrent when downloaded.&#x60; - \&quot;usenet\&quot; &#x60;uses .nzb files and nzb links and adds as a usenet download when downloaded.&#x60; - \&quot;webdl\&quot; &#x60;uses generic links and adds as a web download when downloaded.&#x60;   ##### Status Key  The \&quot;status\&quot; key tells the status of the RSS feed item. This is useful for seeing what the item is doing, and what it will do next. Each item also includes a \&quot;status_message\&quot; key which gives a user friendly message about anything about the RSS feed item, such as errors and explainations.  - \&quot;new\&quot; &#x60;the RSS feed item is set to be downloaded.&#x60; - \&quot;ignored\&quot; &#x60;the RSS feed item has been ignored due to the parents RSS feed settings, as it doesn&#39;t match the chosen settings. The item will not be downloaded.&#x60; - \&quot;error\&quot; &#x60;the RSS feed item had an error while attempting to download. The item will be retried on the next scrape.&#x60; - \&quot;downloaded\&quot; &#x60;the RSS feed item has already been downloaded to the user&#39;s account. It will not be downloaded again.&#x60;   ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = RssApi()
val rssFeedId : kotlin.Long = 789 // kotlin.Long | The RSS Feed ID of the RSS Feed you want to retrieve the scraped items of.
try {
    val result : GetRssFeedItemsResponse = apiInstance.getRssFeedItems(rssFeedId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RssApi#getRssFeedItems")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RssApi#getRssFeedItems")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **rssFeedId** | **kotlin.Long**| The RSS Feed ID of the RSS Feed you want to retrieve the scraped items of. | |

### Return type

[**GetRssFeedItemsResponse**](GetRssFeedItemsResponse.md)

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

<a id="getUserRssFeeds"></a>
# **getUserRssFeeds**
> GetUserRssFeedsResponse getUserRssFeeds(id)

Get User RSS Feeds

### Overview  Gets all of a user&#39;s RSS feeds located on their account. Can only be accessed on a Pro (plan: 2) account. Also allows you to get a specific by passing an \&quot;id\&quot; in the parameters.  ##### Type Key  The \&quot;type\&quot; key in the response is used for showing what type of downloads are spawned from this RSS feed. This affects how the item is downloaded, as well as what is scraped, so make sure it is correct.  - **\&quot;**torrent**\&quot;** &#x60;uses .torrent files and magnet links and adds as torrent when downloaded.&#x60; - \&quot;usenet\&quot; &#x60;uses .nzb files and nzb links and adds as a usenet download when downloaded.&#x60; - \&quot;webdl\&quot; &#x60;uses generic links and adds as a web download when downloaded.&#x60;   ##### Status Key  The \&quot;status\&quot; key tells the user selected status of the RSS feed. These statuses are **not** the same as the status key for the RSS items associated with the RSS feed. Each feed also includes a \&quot;status_message\&quot; key which gives a user friendly message about anything about the RSS feed, such as errors and explainations.  - \&quot;active\&quot; &#x60;the RSS feed is set to be scraped.&#x60; - \&quot;paused\&quot; &#x60;the RSS feed will not be scraped as it is paused by the user.&#x60;  - \&quot;error\&quot; &#x60;the RSS feed had an error while scraping, and cannot continue.&#x60;   ##### State Key  The \&quot;state\&quot; key tells you exactly in real time, what the RSS feed is doing. This is useful for realtime status updates.  - \&quot;idle\&quot; &#x60;the RSS feed is idle, and is currently not doing anything in the current moment.&#x60; - \&quot;scraping\&quot; &#x60;the RSS feed is currently scraping new RSS items.&#x60; - \&quot;downloading\&quot; &#x60;the RSS feed is currently downloading the newly scraped RSS items.&#x60;   ##### Torrent Seeding Key  The \&quot;torrent_seeding\&quot; key is returned with every response, regardless of the type of the RSS feed. This controls what seeding setting the RSS feed is using when it adds new torrents. These are the same options as when adding a torrent using the /torrent/createtorrent endpoint.  &gt; Tells TorBox your preference for seeding this torrent. 1 is auto. 2 is seed. 3 is don&#39;t seed. Optional. Default is 1, or whatever the user has in their settings. Overwrites option in settings.   - 1 &#x60;auto, the torrent will seed based on what the user has in their settings.&#x60; - 2 &#x60;always, TorBox will be instructed to seed this torrent regardless of any other settings.&#x60; - 3 &#x60;never, TorBox will not seed this torrent.&#x60;   ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = RssApi()
val id : kotlin.Long = 789 // kotlin.Long | A specific RSS feed ID that you want to retrieve. Optional.
try {
    val result : GetUserRssFeedsResponse = apiInstance.getUserRssFeeds(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RssApi#getUserRssFeeds")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RssApi#getUserRssFeeds")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.Long**| A specific RSS feed ID that you want to retrieve. Optional. | [optional] |

### Return type

[**GetUserRssFeedsResponse**](GetUserRssFeedsResponse.md)

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

