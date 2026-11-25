
# AddToPixeldrain

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.Long** | Id of the torrent, usenet download or web download to upload. It has to be one of your own downloads. Required. |  |
| **fileId** | **kotlin.Long** | Id of the file to upload, from the download&#39;s files. Leave out when &#x60;zip&#x60; is true. |  [optional] |
| **zip** | **kotlin.Boolean** | Upload the whole download as one zip instead of a single file. Takes precedence over &#x60;file_id&#x60;. Optional, default false. |  [optional] |
| **type** | **kotlin.String** | Which kind of download &#x60;id&#x60; refers to. One of &#x60;torrent&#x60;, &#x60;usenet&#x60; or &#x60;webdownload&#x60;. Optional, default &#x60;torrent&#x60;. |  [optional] |
| **pixeldrainToken** | **kotlin.String** | Pixeldrain API key of the account to upload to. It is issued by Pixeldrain, not by TorBox. The route accepts a request without it, but the job fails without it. |  [optional] |



