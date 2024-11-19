plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("org.jetbrains.kotlin.kapt") // Add this line explicitly
   /* alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
  //  alias(libs.plugins.kotlin.kapt)*/
}

android {
    namespace = "com.example.mvvm_countries"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mvvm_countries"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding=true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.adapter.rxjava2)
    implementation(libs.rxjava)
    implementation(libs.rxandroid)
    implementation(libs.dagger)
    implementation(libs.dagger.android.support)
    implementation(libs.androidx.recyclerview)
    implementation(libs.glide)
    implementation(libs.androidx.swiperefreshlayout)
    //implementation(libs.extensions)
    testImplementation(libs.junit)
    testImplementation(libs.mockito.inline)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    testImplementation(libs.core.testing)
    //implementation(libs.dagger.android.processor)
    kapt(libs.dagger.compiler)
}