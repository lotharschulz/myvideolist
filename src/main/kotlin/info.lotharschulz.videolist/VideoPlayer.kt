package info.lotharschulz.videolist

import kotlinx.css.Display
import kotlinx.css.display
import kotlinx.css.margin
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import styled.css
import styled.styledDiv

external interface VideoPlayerProps : RProps {
    var video: Video
    var unwatchedVideo: Boolean
}

class VideoPlayer : RComponent<VideoPlayerProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
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
                    attrs.source = "lotharschulz.info: info.lotharschulz.videolist.getVideos"
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
            }
        }
    }
}

fun RBuilder.videoPlayer(handler: VideoPlayerProps.() -> Unit): ReactElement {
    return child(VideoPlayer::class) {
        this.attrs(handler)
    }
}