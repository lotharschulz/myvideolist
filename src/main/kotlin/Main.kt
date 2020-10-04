import react.dom.*
import react.*
import kotlinx.browser.document
import kotlinx.css.*
import styled.*

data class Video(val id: Int, val title: String, val speaker: String, val videoUrl: String)

val unwatchedVideos = listOf(
        Video(1, "Building and breaking things", "John Doe", "https://youtu.be/PsaFVLr8t4E"),
        Video(2, "The development process", "Jane Smith", "https://youtu.be/PsaFVLr8t4E"),
        Video(3, "The Web 7.0", "Matt Miller", "https://youtu.be/PsaFVLr8t4E")
)

val watchedVideos = listOf(
        Video(4, "Mouseless development", "Tom Jerry", "https://youtu.be/PsaFVLr8t4E")
)

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        render(document.getElementById("root")) {
            h1 {
                +"KotlinConf Explorer"
            }
            div {
                h3 {
                    +"Videos to watch"
                }
                videoList {
                    videos = unwatchedVideos
                }

                h3 {
                    +"Videos watched"
                }
                videoList {
                    videos = watchedVideos
                }
            }
            styledDiv {
                css {
                    position = Position.absolute
                    top = 10.px
                    right = 10.px
                }
                h3 {
                    +"John Doe: Building and breaking things"
                }
                img {
                    attrs {
                        src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
                    }
                }
            }
        }
    }
}

fun main() {
    render(document.getElementById("root")) {
        child(App::class) {}
    }
}