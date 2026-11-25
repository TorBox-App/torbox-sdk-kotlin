
# ApiError

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **success** | **kotlin.Boolean** | False when the request failed. A list with nothing to return answers &#x60;ITEM_NOT_FOUND&#x60; with &#x60;success&#x60; true: the request worked, there is no data. |  |
| **error** | **kotlin.String** | The error code, such as &#x60;BAD_TOKEN&#x60;. Listed in the introduction. |  |
| **detail** | **kotlin.String** | What went wrong, in words. |  |
| **&#x60;data&#x60;** | [**kotlin.Any**](.md) | Extra data for some errors, usually null. |  [optional] |



