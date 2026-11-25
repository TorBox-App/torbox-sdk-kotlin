
# BaseSettingsModel

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **emailNotifications** | **kotlin.Boolean** | When the user recieves a notification, send to registered email |  [optional] |
| **webNotifications** | **kotlin.Boolean** | When the user recieves a notification, send to web (if browser is open, otherwise it will be in their notifications panel) |  [optional] |
| **mobileNotifications** | **kotlin.Boolean** | When the user recieves a notification, send to TorBox mobile app (deprecated) |  [optional] |
| **rssNotifications** | **kotlin.Boolean** | When the user recieves a notification, add to user&#39;s RSS feed |  [optional] |
| **downloadSpeedInTab** | **kotlin.Boolean** | Shows download speed in tab name in browser when using the TorBox dashboard. Third party apps may still use this setting. |  [optional] |
| **showTrackerInTorrent** | **kotlin.Boolean** | Shows active tracker in torrents on the TorBox dashboard. Third party apps may still use this setting. |  [optional] |
| **stremioQuality** | **kotlin.collections.List&lt;kotlin.Long&gt;** | Determines what qualities are shown to the user when using the TorBox Stremio addon. It is always recommended to include 0 (Unknown). Third party apps may still use this setting.  - &#x60;0&#x60;: Unknown Quality - &#x60;1&#x60;: Cam Quality - &#x60;2&#x60;: DVD-R Quality - &#x60;3&#x60;: HDTV Quality - &#x60;4&#x60;: HDRip Quality - &#x60;5&#x60;: WEB-DL Quality - &#x60;6&#x60;: WEBRip Quality - &#x60;7&#x60;: Blu-Ray/BD/BDRip Quality - &#x60;8&#x60;: HDR Quality - &#x60;9&#x60;: HDR10 Quality - &#x60;10&#x60;: HDR10+ Quality - &#x60;11&#x60;: Dolby Vision Quality  |  [optional] |
| **stremioResolution** | **kotlin.collections.List&lt;kotlin.Long&gt;** | Determines what resolutions are shown to the user. It is always recommended to include 0 (Unknown). Third party apps may still use this setting.  - &#x60;0&#x60;: Unknown Resolution - &#x60;1&#x60;: SD Resolution - &#x60;2&#x60;: HD Resolution - &#x60;3&#x60;: UHD Resolution  |  [optional] |
| **stremioLanguage** | **kotlin.collections.List&lt;kotlin.Long&gt;** | Determines what languages are shown to the user. It is always recommended to include 0 (Unknown). Third party apps may still use this setting.  - &#x60;0&#x60;: Unknown - &#x60;1&#x60;: English - &#x60;2&#x60;: Spanish - &#x60;3&#x60;: French - &#x60;4&#x60;: German - &#x60;5&#x60;: Italian - &#x60;6&#x60;: Portuguese - &#x60;7&#x60;: Russian - &#x60;8&#x60;: Japanese - &#x60;9&#x60;: Korean - &#x60;10&#x60;: Chinese - &#x60;11&#x60;: Arabic - &#x60;12&#x60;: Hindi - &#x60;13&#x60;: Bengali - &#x60;14&#x60;: Ukrainian - &#x60;15&#x60;: Nordic - &#x60;16&#x60;: Czech - &#x60;17&#x60;: Polish - &#x60;18&#x60;: Tamil - &#x60;19&#x60;: Telugu - &#x60;20&#x60;: Kannada - &#x60;21&#x60;: Dutch  |  [optional] |
| **stremioCache** | **kotlin.collections.List&lt;kotlin.Long&gt;** | Determines what cached status items to show to users. While this is an array, only a single value is accepted at a time to prevent issues. Still submit this as an array to the API. Third party apps may still use this setting.  - &#x60;1&#x60;: Cached and Download - &#x60;2&#x60;: Cached Only - &#x60;3&#x60;: Download Only  |  [optional] |
| **stremioSizeLower** | **kotlin.Long** | The minimum size of files that will be shown to the user in the TorBox Stremio addon. Third party apps may still use this setting. |  [optional] |
| **googleDriveFolderId** | **kotlin.String** |  |  [optional] |
| **onedriveSavePath** | **kotlin.String** |  |  [optional] |
| **discordId** | **kotlin.String** |  |  [optional] |
| **discordNotifications** | **kotlin.Boolean** | When the user recieves a notification, use the official TorBox Discord Bot to DM the user the notification. Must have a Discord_ID present and must share a server with the Discord Bot. |  [optional] |
| **stremioAllowAdult** | **kotlin.Boolean** | Determines whether to show adult content on the TorBox Stremio addon. Third party apps may still use this setting. |  [optional] |
| **stremioSeedTorrents** | **kotlin.Long** | 1 &#x3D; Auto, 2 &#x3D; Always, 3 &#x3D; Never |  [optional] |
| **seedTorrents** | **kotlin.Long** | 1 &#x3D; Auto, 2 &#x3D; Always, 3 &#x3D; Never |  [optional] |
| **allowZipped** | **kotlin.Boolean** |  |  [optional] |
| **stremioAllowZipped** | **kotlin.Boolean** |  |  [optional] |
| **onefichierFolderId** | **kotlin.String** |  |  [optional] |
| **gofileFolderId** | **kotlin.String** |  |  [optional] |
| **webhookNotifications** | **kotlin.Boolean** |  |  [optional] |
| **webhookUrl** | **kotlin.String** |  |  [optional] |
| **telegramNotifications** | **kotlin.Boolean** |  |  [optional] |
| **telegramId** | **kotlin.String** |  |  [optional] |
| **megaEmail** | **kotlin.String** |  |  [optional] |
| **megaPassword** | **kotlin.String** |  |  [optional] |
| **stremioSort** | **kotlin.String** | seeders &#x3D; Seeders/Age (highest seeders first/lowest age first), size &#x3D; Size (highest size first), resolution &#x3D; Resolution (highest resolution first) |  [optional] |
| **cdnSelection** | **kotlin.String** | any available CDN. Can be found using test file route |  [optional] |
| **stremioUseCustomSearchEngines** | **kotlin.Boolean** |  |  [optional] |
| **stremioResultSort** | **kotlin.String** | torrents &#x3D; Torrents first, usenet &#x3D; Usenet first |  [optional] |
| **webdavUseLocalFiles** | **kotlin.Boolean** |  |  [optional] |
| **stremioLegacyYourMedia** | **kotlin.Boolean** |  |  [optional] |
| **stremioOnlyYourMediaStreams** | **kotlin.Boolean** | only shows Your Media streams in Stremio addon |  [optional] |
| **stremioDisableYourMediaStreams** | **kotlin.Boolean** |  |  [optional] |
| **webdavUseFolderView** | **kotlin.Boolean** |  |  [optional] |
| **webdavFlatten** | **kotlin.Boolean** |  |  [optional] |
| **stremioLimitPerResolutionTorrent** | **kotlin.Long** |  |  [optional] |
| **stremioLimitPerResolutionUsenet** | **kotlin.Long** |  |  [optional] |
| **stremioSizeUpper** | **kotlin.Long** |  |  [optional] |
| **stremioTorrentSeedersCutoff** | **kotlin.Long** |  |  [optional] |
| **pixeldrainApiKey** | **kotlin.String** |  |  [optional] |
| **onefichierApiKey** | **kotlin.String** |  |  [optional] |
| **gofileApiKey** | **kotlin.String** |  |  [optional] |
| **patreonId** | **kotlin.String** |  |  [optional] |
| **stremioWaitForDownloadUsenet** | **kotlin.Boolean** |  |  [optional] |
| **stremioWaitForDownloadTorrent** | **kotlin.Boolean** |  |  [optional] |
| **stremioDisableFilteredNote** | **kotlin.Boolean** |  |  [optional] |
| **stremioEmojiInDescription** | **kotlin.Boolean** |  |  [optional] |
| **dashboardFilter** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Any&gt;**](kotlin.Any.md) | sorts the user&#39;s dashboard. Does not affect third party dashboards. This entire dict MUST be presented with all keys for any update to be given. |  [optional] |
| **webPlayerAlwaysTranscode** | **kotlin.Boolean** |  |  [optional] |
| **webPlayerAlwaysSkipIntro** | **kotlin.Boolean** |  |  [optional] |
| **webPlayerAudioPreferredLanguage** | **kotlin.String** |  |  [optional] |
| **webPlayerSubtitlePreferredLanguage** | **kotlin.String** |  |  [optional] |
| **webPlayerDisablePrestreamSelector** | **kotlin.Boolean** |  |  [optional] |
| **dashboardSort** | **kotlin.String** | default &#x3D; TorBox default sorting, name &#x3D; AZ sorting, size &#x3D; largest size first, added_date &#x3D; newest first, cached_date &#x3D; newest first, last_updated &#x3D; newest first, progress &#x3D; highest progress first, ratio &#x3D; highest ratio first, download_speed &#x3D; highest value first, upload_speed &#x3D; highest value first, eta &#x3D; smallest eta first |  [optional] |
| **webPlayerDisableNextUpDialogue** | **kotlin.Boolean** |  |  [optional] |
| **webPlayerEnableScrobbling** | **kotlin.Boolean** |  |  [optional] |
| **appendFilenameToLinks** | **kotlin.Boolean** |  |  [optional] |
| **subscribedEmailSegments** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |
| **disableAi** | **kotlin.Boolean** |  |  [optional] |



