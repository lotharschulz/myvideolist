import kotlinx.browser.window
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onLoadFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.p

external interface VideoListProps: RProps {
    var videos: List<Video>
    var selectedVideo: Video?
    var onSelectVideo: (Video) -> Unit
}

external interface VideoListState: RState {
    var initialState:Boolean
}

class VideoList: RComponent<VideoListProps, VideoListState>() {

    override fun VideoListState.init() {
        initialState = true
    }

    override fun RBuilder.render() {
        for (video in props.videos) {
            p {
                key = video.id.toString()
                attrs {
                    if (state.initialState) {
                        props.onSelectVideo(
                            Video(
                                1,
                                "Open Source CI/CD components for GitHub Actions",
                                "Lothar Schulz",
                                "https://youtu.be/26E9hRKkqw4"
                            )
                        )
                        state.initialState = false
                    }
                    onClickFunction = {
                        props.onSelectVideo(video)
                    }
                }
                if(video == props.selectedVideo) {
                    +"▶ "
                }
                +"${video.title}"
            }
        }
    }
}

fun RBuilder.videoList(handler: VideoListProps.() -> Unit): ReactElement {
    return child(VideoList::class) {
        this.attrs(handler)
    }
}