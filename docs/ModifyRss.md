
# ModifyRss

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **rssFeedId** | **kotlin.Long** | The ID of the RSS feed you want to modify. |  |
| **name** | **kotlin.String** | Display name of the rss feed you want to add. |  [optional] |
| **doRegex** | **kotlin.String** | Regex of items you want to make sure are added. Optional. |  [optional] |
| **dontRegex** | **kotlin.String** | Regex of items you dont want added. Optional. |  [optional] |
| **scanInterval** | **kotlin.Long** | Time in minutes with the minimum being 10 which you want the api to scan in interval. Optional. Default is 60. |  [optional] |
| **dontOlderThan** | **kotlin.Long** | Time in days that tells the parser to skip if the torrent is older than that many days. Optional. |  [optional] |
| **rssType** | **kotlin.String** | The type of downloads inside of this RSS feed. Optional. Default is torrent. Options are \&quot;torrent\&quot;, \&quot;usenet\&quot;, \&quot;webdl\&quot; |  [optional] |
| **torrentSeeding** | **kotlin.Long** | Determines if torrents inside of this RSS feed will seed or not. Optional. Default is 1, for auto. Options are 1 for auto, 2 for always, and 3 for never. |  [optional] |



