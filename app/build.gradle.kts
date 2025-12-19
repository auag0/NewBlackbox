plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

val compileSdkVer = rootProject.extra["compileSdkVersion"] as Int
val targetSdkVersion = rootProject.extra["targetSdkVersion"] as Int
val minSdkVersion = rootProject.extra["minSdk"] as Int
val appVersionCode = rootProject.extra["versionCode"] as Int
val appVersionName = rootProject.extra["versionName"] as String

android {
    namespace = "pg.gotcha"
    compileSdk = compileSdkVer

    defaultConfig {
        applicationId = "pg.gotcha"
        minSdk = minSdkVersion
        compileSdk = compileSdkVer
        targetSdk = targetSdkVersion
        versionCode = appVersionCode
        versionName = appVersionName
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.10.0")
    implementation("androidx.activity:activity-compose:1.12.2")
    implementation(platform("androidx.compose:compose-bom:2025.12.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    implementation(project(":Bcore"))
}