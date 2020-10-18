@file:JsModule("react-player")
@file:JsNonModule // ktlint-disable

import react.RClass
import react.RProps

@JsName("default")
external val reactPlayer: RClass<ReactPlayerProps>

external interface ReactPlayerProps : RProps {
    var url: String
}