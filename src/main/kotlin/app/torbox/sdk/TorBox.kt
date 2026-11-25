package app.torbox.sdk

import app.torbox.sdk.infrastructure.ApiClient
import okhttp3.Call
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/** Configures generated API groups with a key scoped to this client. */
class TorBox(
    val apiKey: String,
    baseUrl: String = "https://api.torbox.app",
    private val transport: Call.Factory = OkHttpClient.Builder()
        .callTimeout(30, TimeUnit.SECONDS)
        .build(),
) {
    private val baseUrl = baseUrl.trimEnd('/')

    init {
        require(apiKey.isNotBlank()) { "A TorBox API key is required." }
    }

    fun <T : ApiClient> api(create: (String, Call.Factory) -> T): T =
        create(baseUrl, transport).also { it.accessTokenProvider = { apiKey } }
}
