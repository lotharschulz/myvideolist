plugins {
    id("org.jetbrains.kotlin.js") version "1.4.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    mavenCentral()
    jcenter()
}

kotlin {
    js {
        browser {
            testTask {
                useKarma {
                    useIe()
                    useSafari()
                    useFirefox()
                    useChrome()
                    useChromeCanary()
                    useChromeHeadless()
                    usePhantomJS()
                    useOpera()
                }
            }
        }
        binaries.executable()
    }
}

dependencies {
    implementation(kotlin("stdlib-js"))

    //React, React DOM + Wrappers (chapter 3)
    implementation("org.jetbrains:kotlin-react:16.13.1-pre.124-kotlin-1.4.10")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.124-kotlin-1.4.10")
    implementation(npm("react", "16.13.1"))
    implementation(npm("react-dom", "16.13.1"))

    //Kotlin Styled (chapter 3)
    implementation("org.jetbrains:kotlin-styled:5.2.0-pre.124-kotlin-1.4.10")
    implementation(npm("styled-components", "~5.2.0"))
    implementation(npm("inline-style-prefixer", "~6.0.0"))

    //Video Player (chapter 7)
    implementation(npm("react-player", "~2.6.2"))

    //Share Buttons (chapter 7)
    implementation(npm("react-share", "~4.3.0"))

    //Coroutines (chapter 8)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
}