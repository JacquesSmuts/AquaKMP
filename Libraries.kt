
package com.jacquessmuts.aquakmp.buildsrc

/**
 * This defines all versions, but is inactive because it breaks Gradle versions below 8.2.
 *
 * TODO: convert to a .toml,
 * @see https://github.com/cashapp/sqldelight/blob/master/gradle/libs.versions.toml
 *
 *
 */
object Libraries

    object Kotlin {
        val version = System.getProperty("kotlin.version") ?: ""
        val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"

        object Coroutines {
            private const val version = "1.6.4"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }

        object Compose {
            val version = System.getProperty("compose.version") ?: ""
        }
    }

    object SqlDelight {
        const val version = "2.0.0-alpha05"
        const val driverAndroid = "app.cash.sqldelight:android-driver:$version"
        const val driverNative = "app.cash.sqldelight:native-driver:$version"
        const val driverTest = "app.cash.sqldelight:sqlite-driver:$version"
        const val coroutines = "app.cash.sqldelight:coroutines-extensions:$version"
    }

    // TODO: replace with a compile-time dependency injection framework: https://github.com/evant/kotlin-inject
    object Koin {
        const val version = "3.4.0"
        const val core = "io.insert-koin:koin-core:$version"
        const val test = "io.insert-koin:koin-test:$version"
        const val android = "io.insert-koin:koin-android:$version"
    }

    object AndroidX {

        val androidGradlePluginVersion = System.getProperty("agp.version") ?: ""
        val androidGradlePlugin = "com.android.tools.build:gradle:$androidGradlePluginVersion"
        val activityCompose = "androidx.activity:activity-compose:1.6.1"
        val appCompat = "androidx.appcompat:appcompat:1.6.1"
        val coreKtx = "androidx.core:core-ktx:1.9.0"

        object Compose {
            const val compilerVersion = "1.4.2"
            private const val version = "1.4.2"

            const val core = "androidx.compose.ui:ui:$version"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val material3 = "androidx.compose.material3:material3:1.0.1"
            const val workRuntimeKtx = "androidx.work:work-runtime-ktx:2.8.1"

            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val testManifest = "androidx.compose.ui:ui-test-manifest:$version"

            const val uiTest = "androidx.compose.ui:ui-test-junit4:1.4.1"

        }

        object Lifecycle {
            private const val version = "2.6.1"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val runtimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:$version"
            const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        }

        object Test {
            private const val version = "1.4.0"
            object Ext {
                private const val version = "1.1.5"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }
            const val espressoCore = "androidx.test.espresso:espresso-core:3.5.1"
        }
    }

    object Misc {
        const val coilCompose = "io.coil-kt:coil-compose:2.1.0"
        const val turbine = "app.cash.turbine:turbine:0.12.3"
        const val mockk = "io.mockk:mockk:1.13.5"
        const val kermitLogging ="co.touchlab:kermit:2.0.0-RC4"
    }

    object JUnit {
        private const val version = "4.13.2"
        const val junit = "junit:junit:$version"
    }

}