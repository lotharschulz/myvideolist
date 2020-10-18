import react.* // currentVideo
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h4

val videos  = listOf(
        Video(1, "Open Source CI/CD components for GitHub Actions", "https://youtu.be/26E9hRKkqw4"),
        Video(2, "How to shrink a docker image [CI/CD Meetup Berlin - Nov. 2018]", "https://youtu.be/_NK0_KgudNc"),
        Video(3, "Ktor App Continuous Delivery", "https://youtu.be/T-Ed_tbi1f8"),
        Video(4, "How to Shrink a Docker Image [Devops Pro Conference - March 2019 ]", "https://youtu.be/_6R0nk_gWbY"),
        Video(5, "Gitops show case", "https://youtu.be/pSrjBcKr1tA"),
        Video(6, "downwardAPI demo", "https://youtu.be/rCtT18k4nUM")
)

external interface AppState: RState {
    var currentVideo: Video?
    var unwatchedVideos: List<Video>
//    var watchedVideos: List<Video>
}

class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        unwatchedVideos = videos
//        watchedVideos = listOf()
    }

    override fun RBuilder.render() {
        div (classes = "videolist") {
            h4 {
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

/*
            if (state.watchedVideos.isNotEmpty()) {
                h4 {
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
*/
        }
        div (classes = "videoplayer") {
            state.currentVideo?.let { currentVideo ->
                videoPlayer {
                    video = currentVideo
                    unwatchedVideo = currentVideo in state.unwatchedVideos
/*
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
*/
                }
            }
        }
    }
}