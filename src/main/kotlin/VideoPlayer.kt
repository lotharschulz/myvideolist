import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.h4
import styled.*

external interface VideoPlayerProps : RProps {
    var video: Video
    var onWatchedButtonPressed: (Video) -> Unit
    var unwatchedVideo: Boolean
}

class VideoPlayer : RComponent<VideoPlayerProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            h4 {
                +"${props.video.title}"
            }
            reactPlayer {
                attrs.url = props.video.videoUrl
            }
            styledDiv {
                css {
                    display = Display.flex
                    margin = "1em"
                }
                emailShareButton {
                    attrs.url = props.video.videoUrl
                    attrs.body = "Video by Lothar Schulz: "
                    attrs.subject = "Video: '${props.video.title}' by Lothar Schulz"
                    emailIcon {
                        attrs.size = 32
                        attrs.round = false
                        attrs.iconFillColor = "black"
                    }
                }
                linkedinShareButton {
                    attrs.url = props.video.videoUrl
                    attrs.title = props.video.title
                    attrs.summary = "Video by Lothar Schulz"
                    attrs.source = "lotharschulz.info: videos"
                    linkedinIcon {
                        attrs.size = 32
                        attrs.round = false
                        attrs.iconFillColor = "black"
                    }
                }
                twitterShareButton {
                    attrs.url = props.video.videoUrl
                    attrs.title = "'${props.video.title}'"
                    attrs.via = "lotharschulz"
                    twitterIcon {
                        attrs.size = 32
                        attrs.round = false
                        attrs.iconFillColor = "black"
                    }
                }
/*
                styledButton {
                    css {
                        margin = "1em"
                        padding = "0.5em"
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
*/
            }
        }
    }
}

fun RBuilder.videoPlayer(handler: VideoPlayerProps.() -> Unit): ReactElement {
    return child(VideoPlayer::class) {
        this.attrs(handler)
    }
}