package info.lotharschulz.videolist

import kotlinx.css.Cursor
import kotlinx.css.FontWeight
import kotlinx.css.cursor
import kotlinx.css.fontWeight
import kotlinx.css.properties.TextDecorationLine
import kotlinx.css.properties.textDecoration
import kotlinx.css.properties.transition
import kotlinx.css.properties.Time
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import styled.css
import styled.styledP

external interface VideoListProps : RProps {
    var videos: List<Video>
    var selectedVideo: Video?
    var onSelectVideo: (Video) -> Unit
}

external interface VideoListState : RState {
    var initialState: Boolean
}

class VideoList : RComponent<VideoListProps, VideoListState>() {

    override fun VideoListState.init() {
        initialState = true
    }

    override fun RBuilder.render() {
        for (video in props.videos) {
            styledP {
                css {
                    when (video == props.selectedVideo) {
                        true -> {
                            textDecoration(TextDecorationLine.unset)
                            fontWeight = FontWeight.bold
                        }
                        false -> textDecoration(TextDecorationLine.underline)
                    }
                    transition(property = "all", duration = Time("0.4"))
                    hover {
                        cursor = Cursor.pointer
                        when (video == props.selectedVideo) {
                            true -> textDecoration(TextDecorationLine.underline)
                            false -> textDecoration(TextDecorationLine.unset)
                        }
                    }
                }
                key = video.id.toString()
                attrs {
                    if (state.initialState) {
                        props.onSelectVideo(
                            videos[0]
                        )
                        state.initialState = false
                    }
                    onClickFunction = {
                        props.onSelectVideo(video)
                    }
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