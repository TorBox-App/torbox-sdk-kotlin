
# AddRss

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **url** | **kotlin.String** | URL of the rss feed you want to add. |  |
| **name** | **kotlin.String** | Display name of the rss feed you want to add. |  |
| **doRegex** | **kotlin.String** | Regex of items you want to make sure are added. Optional. |  [optional] |
| **dontRegex** | **kotlin.String** | Regex of items you dont want added. Optional. |  [optional] |
| **dontOlderThan** | **kotlin.Long** | Time in days that tells the parser to skip if the torrent is older than that many days. Optional. |  [optional] |
| **passCheck** | **kotlin.Boolean** | Boolean which tells to allow multiple of the same url if it already exists on your account |  [optional] |
| **scanInterval** | **kotlin.Long** | Time in minutes with the minimum being 10 which you want the api to scan in interval. Optional. Default is 60. |  [optional] |
| **rssType** | **kotlin.String** | The type of downloads inside of this RSS feed. Optional. Default is torrent. Options are \&quot;torrent\&quot;, \&quot;usenet\&quot;, \&quot;webdl\&quot; |  [optional] |
| **torrentSeeding** | **kotlin.Long** | Determines if torrents inside of this RSS feed will seed or not. Optional. Default is 1, for auto. Options are 1 for auto, 2 for always, and 3 for never. |  [optional] |



