import kotlinx.browser.window
import kotlinx.coroutines.async
import kotlinx.coroutines.await
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

object Fetch {
    suspend fun fetchVideos(): List<Video> = coroutineScope {
        (1..25).map { id ->
            async {
                fetchVideo(id)
            }
        }.awaitAll()
    }

    private suspend fun fetchVideo(id: Int): Video =
            window.fetch("https://my-json-server.typicode.com/kotlin-hands-on/kotlinconf-json/videos/$id")
                    .await()
                    .json()
                    .await()
                    .unsafeCast<Video>()
}

/*

- you tube API fetch my videos: https://developers.google.com/youtube/v3/code_samples/apps-script#retrieve_my_uploads
- access youtube API: https://blog.bitsrc.io/make-a-simple-react-app-with-using-youtube-api-68fa016e5a03
- API requirements: https://developers.google.com/youtube/v3/docs/#calling-the-api (https://www.slickremix.com/docs/get-api-key-for-youtube/)

 */