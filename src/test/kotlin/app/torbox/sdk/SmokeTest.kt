package app.torbox.sdk

import app.torbox.sdk.apis.TorrentsApi
import app.torbox.sdk.apis.UserApi
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assumptions.assumeTrue
import org.junit.jupiter.api.Test
import java.nio.file.Files

class SmokeTest {
    @Test
    fun authenticatesAndHandlesMultipartAndQueryKeys() {
        val mock = System.getenv("TORBOX_MOCK_URL")
        assumeTrue(mock != null)
        val client = TorBox("torbox-sdk-test", requireNotNull(mock))

        val account = client.api(::UserApi).getUserData()
        assertTrue(account.success)
        assertNotNull(account.data)

        val torrents = client.api(::TorrentsApi)
        val file = Files.createTempFile("torbox", ".torrent").toFile()
        try {
            file.writeText("d8:announce0:e")
            assertTrue(torrents.createTorrent(file = file).success)
            assertTrue(torrents.requestTorrentDownloadLink(client.apiKey, 1, 0).success)
        } finally {
            file.delete()
        }
    }
}
