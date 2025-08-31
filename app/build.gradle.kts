plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.portfolio_app"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.portfolio_app"
        minSdk = 24
        targetSdk = 36
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
    implementation("com.airbnb.android:lottie:6.6.7")
    implementation("com.google.android.material:material:1.12.0")   // this is used to make change the shape of the views
    implementation("com.google.android.material:material:1.12.0")   // this is for card view and other views
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.filament.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}