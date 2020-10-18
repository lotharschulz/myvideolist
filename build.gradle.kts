import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    val kotlinVersion = "1.4.10"
    id("org.jetbrains.kotlin.js") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
    id("org.owasp.dependencycheck") version "6.0.0"
}

group = "info.lotharschulz"
version = "0.1-SNAPSHOT"

repositories {
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))

    // React, React DOM, Wrappers
    implementation("org.jetbrains:kotlin-react:16.13.1-pre.124-kotlin-1.4.10")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.124-kotlin-1.4.10")
    implementation(npm("react", "16.13.1"))
    implementation(npm("react-dom", "16.13.1"))

    // Kotlin Styled
    implementation("org.jetbrains:kotlin-styled:5.2.0-pre.124-kotlin-1.4.10")
    implementation(npm("styled-components", "~5.2.0"))
    implementation(npm("inline-style-prefixer", "~6.0.0"))

    // Video Player
    implementation(npm("react-player", "~2.6.2"))

    // Share Buttons
    implementation(npm("react-share", "~4.3.0"))

    // test
    testImplementation(kotlin("test-js"))
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
                    useFirefox()
/*
                    useChrome()
                    useIe()
                    useSafari()
                    useChromeHeadless()
                    useChromeCanary()
                    usePhantomJS()
                    useOpera()
*/
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        binaries.executable()
    }
}

ktlint {
    debug.set(true)
    verbose.set(true)
    android.set(false)
    outputToConsole.set(true)
    outputColorName.set("RED")
    ignoreFailures.set(true)
    enableExperimentalRules.set(true)
    additionalEditorconfigFile.set(file("klint/.editorconfig"))
    reporters {
        reporter(ReporterType.PLAIN)
        reporter(ReporterType.CHECKSTYLE)
    }
}