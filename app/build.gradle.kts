plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.device"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.device"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.camera.view)

    // 添加 CameraX 相关依赖
    implementation("androidx.camera:camera-camera2:1.1.0") // CameraX 核心库
    implementation("androidx.camera:camera-lifecycle:1.1.0")  // CameraX 生命周期支持
    implementation("androidx.camera:camera-view:1.0.0-alpha20")
    implementation(libs.biometric)  // CameraX 视图库


    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}