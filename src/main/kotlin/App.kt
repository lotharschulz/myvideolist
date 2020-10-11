import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import react.* // currentVideo
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h1
import react.dom.h3

external interface AppState: RState {
    var currentVideo: Video?
    var unwatchedVideos: List<Video>
    var watchedVideos: List<Video>
}

class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        unwatchedVideos = listOf(
            Video(1, "Open Source CI/CD components for GitHub Actions", "Lothar Schulz", "https://youtu.be/26E9hRKkqw4"),
            Video(2, "Docker image journey - How to shrink a docker image [CI/CD Meetup - 20.11.2018]", "Lothar Schulz", "https://youtu.be/_NK0_KgudNc"),
            Video(3, "Ktor App Continuous Delivery", "Lothar Schulz", "https://youtu.be/T-Ed_tbi1f8"),
            Video(4, "Docker Image Journey - How to Shrink a Docker Image", "Lothar Schulz", "https://youtu.be/_6R0nk_gWbY"),
            Video(5, "Gitops show case", "Lothar Schulz", "https://youtu.be/pSrjBcKr1tA"),
            Video(6, "downwardAPI demo", "Lothar Schulz", "https://youtu.be/rCtT18k4nUM")
        )
        watchedVideos = listOf()
    }

    override fun RBuilder.render() {
        div {
            h3 {
                +"Videos"
            }
            videoList {
                videos = state.unwatchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video ->
                    setState {
                        currentVideo = video
                    }
                }
            }

            if (state.watchedVideos.isNotEmpty()) {
                h3 {
                    +"Videos watched"
                }
            }
            videoList {
                videos = state.watchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video ->
                    setState {
                        currentVideo = video
                    }
                }
            }
        }
        state.currentVideo?.let { currentVideo ->
            videoPlayer {
                video = currentVideo
                unwatchedVideo = currentVideo in state.unwatchedVideos
                onWatchedButtonPressed = {
                    if (video in state.unwatchedVideos) {
                        setState {
                            unwatchedVideos -= video
                            watchedVideos += video
                        }
                    } else {
                        setState {
                            watchedVideos -= video
                            unwatchedVideos += video
                        }
                    }
                }
            }
        }
    }
}