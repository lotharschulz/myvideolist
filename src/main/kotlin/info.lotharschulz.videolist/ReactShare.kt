@file:JsModule("react-share")
@file:JsNonModule

package info.lotharschulz.videolist // ktlint-disable

import react.RClass
import react.RProps

@JsName("EmailIcon")
external val emailIcon: RClass<IconProps>

@JsName("EmailShareButton")
external val emailShareButton: RClass<EmailShareButtonProps>

@JsName("TwitterIcon")
external val twitterIcon: RClass<IconProps>

@JsName("TwitterShareButton")
external val twitterShareButton: RClass<TwitterShareButtonProps>

@JsName("LinkedinIcon")
external val linkedinIcon: RClass<IconProps>

@JsName("LinkedinShareButton")
external val linkedinShareButton: RClass<LinkedinShareButtonProps>

external interface EmailShareButtonProps : RProps {
    var url: String
    var subject: String
    var body: String
}

external interface LinkedinShareButtonProps : RProps {
    var url: String
    var title: String
    var summary: String
    var source: String
}

external interface TwitterShareButtonProps : RProps {
    var url: String
    var title: String
    var via: String
}

external interface IconProps : RProps {
    var size: Int
    var round: Boolean
    var iconFillColor: String
}