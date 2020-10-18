package info.lotharschulz.videolist

import react.* // ktlint-disable
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h4

val videos = listOf(
    Video(1, "Open Source CI/CD components for GitHub Actions", "https://youtu.be/26E9hRKkqw4"),
    Video(2, "How to shrink a docker image [CI/CD Meetup Berlin - Nov. 2018]", "https://youtu.be/_NK0_KgudNc"),
    Video(3, "Ktor info.lotharschulz.videolist.App Continuous Delivery", "https://youtu.be/T-Ed_tbi1f8"),
    Video(4, "How to Shrink a Docker Image [Devops Pro Conference - March 2019 ]", "https://youtu.be/_6R0nk_gWbY"),
    Video(5, "A GitOps show case", "https://youtu.be/pSrjBcKr1tA"),
    Video(6, "Kubernetes downward API demo", "https://youtu.be/rCtT18k4nUM")
)

external interface AppState : RState {
    var currentVideo: Video?
    var unwatchedVideos: List<Video>
}

class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        unwatchedVideos = videos
    }

    override fun RBuilder.render() {
        div(classes = "videolist") {
            videoList {
                videos = state.unwatchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video ->
                    setState {
                        currentVideo = video
                    }
                }
            }
        }
        div(classes = "videoplayer") {
            state.currentVideo?.let { currentVideo ->
                videoPlayer {
                    video = currentVideo
                    unwatchedVideo = currentVideo in state.unwatchedVideos
                }
            }
        }
    }
}