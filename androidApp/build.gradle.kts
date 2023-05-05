
plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
}

kotlin {
    android()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))
                api("io.insert-koin:koin-core:3.3.3")
                api("io.insert-koin:koin-android:3.3.3")
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.jacquessmuts"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        applicationId = "com.jacquessmuts.aquakmp"
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(11)
    }
}
