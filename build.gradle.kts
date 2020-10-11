plugins {
    id("org.jetbrains.kotlin.js") version "1.4.10"
}

group = "info.lotharschulz"
version = "0.1-SNAPSHOT"

repositories {
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    mavenCentral()
    jcenter()
}

kotlin {
    js {
        moduleName = "kotlinjs"
        browser {
            distribution {
                directory = File("$projectDir/output/")
            }
            webpackTask {
                cssSupport.enabled = true
            }
            runTask {
                cssSupport.enabled = true
            }
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
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        binaries.executable()
    }
}

dependencies {
    implementation(kotlin("stdlib-js"))

    //React, React DOM, Wrappers
    implementation("org.jetbrains:kotlin-react:16.13.1-pre.124-kotlin-1.4.10")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.124-kotlin-1.4.10")
    implementation(npm("react", "16.13.1"))
    implementation(npm("react-dom", "16.13.1"))

    //Kotlin Styled
    implementation("org.jetbrains:kotlin-styled:5.2.0-pre.124-kotlin-1.4.10")
    implementation(npm("styled-components", "~5.2.0"))
    implementation(npm("inline-style-prefixer", "~6.0.0"))

    //Video Player
    implementation(npm("react-player", "~2.6.2"))

    //Share Buttons
    implementation(npm("react-share", "~4.3.0"))
}