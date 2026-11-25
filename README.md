# TorBox Kotlin SDK

Kotlin/JVM client for the [TorBox API](https://api-docs.torbox.app). Requires Java 17 or later.

```kotlin
// build.gradle.kts
repositories { mavenCentral() }
dependencies { implementation("app.torbox:torbox-sdk:9.3.2026112508") }
```

```kotlin
import app.torbox.sdk.TorBox
import app.torbox.sdk.apis.UserApi

fun main() {
    val client = TorBox(requireNotNull(System.getenv("TORBOX_API_KEY")))
    val response = client.api(::UserApi).getUserData()
    check(response.success) { response.detail }
    println(response.data)
}
```

The generated methods return the TorBox response envelope. For download link endpoints, pass `client.apiKey` as the
`token` argument. File uploads accept `java.io.File`. Use the [SDK guide](https://api-docs.torbox.app/docs/sdks)
and [API reference](https://api-docs.torbox.app/reference) for request examples.
