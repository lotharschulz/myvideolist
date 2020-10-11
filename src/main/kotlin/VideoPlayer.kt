import kotlinx.css.*
import kotlinx.html.js.onClickFunction
//import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.h3
import react.dom.img
import styled.*

external interface VideoPlayerProps : RProps {
    var video: Video
    var onWatchedButtonPressed: (Video) -> Unit
    var unwatchedVideo: Boolean
}

class VideoPlayer : RComponent<VideoPlayerProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            css {
                position = Position.absolute
                top = 10.px
                right = 10.px
            }
            h3 {
                +"${props.video.speaker}: ${props.video.title}"
            }
            styledDiv {
                css {
                    display = Display.flex
                    marginBottom = 10.px
                }
                emailShareButton {
                    attrs.url = props.video.videoUrl
                    attrs.body = "Video by: ${props.video.speaker}"
                    attrs.subject = "Video title: '${props.video.title}'"
                    emailIcon {
                        attrs.size = 32
                        attrs.round = true
                        attrs.iconFillColor = "black"
                    }
                }
                linkedinShareButton {
                    attrs.url = props.video.videoUrl
                    attrs.title = props.video.title
                    attrs.summary = "Video by: ${props.video.speaker}"
                    attrs.source = "videoPlayer kotlinjs project"
                    linkedinIcon {
                        attrs.size = 32
                        attrs.round = true
                        attrs.iconFillColor = "black"
                    }
                }
                twitterShareButton {
                    attrs.url = props.video.videoUrl
                    attrs.title = "'${props.video.title}'"
                    attrs.via = "lotharschulz"
                    twitterIcon {
                        attrs.size = 32
                        attrs.round = true
                        attrs.iconFillColor = "black"
                    }
                }
            }
            reactPlayer {
                attrs.url = props.video.videoUrl
            }
            styledButton {
                css {
                    display = Display.block
                    backgroundColor = if(props.unwatchedVideo) Color.black else Color.red
                    color = Color.white
                }
                attrs {
                    onClickFunction = {
                        props.onWatchedButtonPressed(props.video)
                    }
                }
                if(props.unwatchedVideo) {
                    +"Mark as watched"
                }
                else {
                    +"Mark as unwatched"
                }
            }
        }
    }
}

fun RBuilder.videoPlayer(handler: VideoPlayerProps.() -> Unit): ReactElement {
    return child(VideoPlayer::class) {
        this.attrs(handler)
    }
}