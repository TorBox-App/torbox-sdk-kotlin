
# AddToDropbox

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.Long** | Id of the torrent, usenet download or web download. Still required by the route, but no longer used. |  |
| **dropboxToken** | **kotlin.String** | Dropbox OAuth access token. Still required by the route, but no longer used. |  |
| **fileId** | **kotlin.Long** | Id of the file inside the download. No longer used. |  [optional] |
| **zip** | **kotlin.Boolean** | Whether to upload the whole download as one zip. No longer used. |  [optional] |
| **type** | **kotlin.String** | Which kind of download &#x60;id&#x60; refers to. One of &#x60;torrent&#x60;, &#x60;usenet&#x60; or &#x60;webdownload&#x60;. Optional, default &#x60;torrent&#x60;. Still checked before the route answers. |  [optional] |



