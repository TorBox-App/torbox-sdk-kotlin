# TagsApi

All URIs are relative to *https://api.torbox.app*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**controlTag**](TagsApi.md#controlTag) | **POST** /v1/api/tags/controltag | Control Tag |
| [**editTag**](TagsApi.md#editTag) | **PUT** /v1/api/tags/edittag | Edit Tag |
| [**getTags**](TagsApi.md#getTags) | **GET** /v1/api/tags/mytags | Get User Tags |


<a id="controlTag"></a>
# **controlTag**
> ControlTagResponse controlTag(controlTag)

Control Tag

### Overview  Controls a tag. Currently, the only operation is \&quot;delete\&quot;, which deletes the tag and removes it from every download using it; the downloads stay in your account and are otherwise unmodified. The ID is the tag&#39;s ID from &#x60;/mytags&#x60; endpoint.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TagsApi()
val controlTag : ControlTag = {"id":0,"operation":"delete"} // ControlTag | 
try {
    val result : ControlTagResponse = apiInstance.controlTag(controlTag)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#controlTag")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#controlTag")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **controlTag** | [**ControlTag**](ControlTag.md)|  | |

### Return type

[**ControlTagResponse**](ControlTagResponse.md)

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

<a id="editTag"></a>
# **editTag**
> EditTagResponse editTag(editTag)

Edit Tag

### Overview  Renames a tag. This new name is case sensitive. The ID is the tag&#39;s ID from the &#x60;/mytags&#x60;. Fails with &#x60;DUPLICATE_ITEM&#x60; when another of the user&#39;s tags already has the same name, in any casing.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TagsApi()
val editTag : EditTag = {"id":0,"new_name":"string"} // EditTag | 
try {
    val result : EditTagResponse = apiInstance.editTag(editTag)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#editTag")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#editTag")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **editTag** | [**EditTag**](EditTag.md)|  | |

### Return type

[**EditTagResponse**](EditTagResponse.md)

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

<a id="getTags"></a>
# **getTags**
> GetTagsResponse getTags()

Get User Tags

### Overview  Gets the tags attached to a user account, with the downloads using each tag, their count and total size.  ### Authorization  Requires an API key using the Authorization Bearer Header. 

### Example
```kotlin
// Import classes:
//import app.torbox.sdk.infrastructure.*
//import app.torbox.sdk.models.*

val apiInstance = TagsApi()
try {
    val result : GetTagsResponse = apiInstance.getTags()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TagsApi#getTags")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TagsApi#getTags")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetTagsResponse**](GetTagsResponse.md)

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

