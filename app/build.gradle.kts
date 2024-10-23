plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
    id ("kotlin-parcelize")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.gymforce"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.gymforce"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.storage)
    implementation(libs.androidx.benchmark.common)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.firestore.ktx)
    implementation( platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation (libs.firebase.auth)
    implementation("com.google.android.gms:play-services-auth:21.2.0")

    implementation ("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.compose.material:material:1.4.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose-android:2.8.0-rc01")

    val nav_version = "2.7.0" // Use the latest version
    implementation ("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation ("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation ("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")



    implementation(project(":domain"))
    implementation(project(":data"))
    implementation ("com.akexorcist:localization:1.2.11")


    implementation ("androidx.room:room-runtime:2.5.1")
    kapt ("androidx.room:room-compiler:2.5.1")
    val room_version = "2.5.0" // Or use the latest version
    implementation( "androidx.room:room-runtime:$room_version")
    implementation( "androidx.room:room-ktx:$room_version") // Add this line
    kapt( "androidx.room:room-compiler:$room_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")


    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("com.google.dagger:hilt-android:2.49")
    kapt("com.google.dagger:hilt-android-compiler:2.49")
//    val lottieVersion = "3.4.0"
//    implementation ("com.airbnb.android:lottie:$lottieVersion")
    implementation ("com.google.android.material:material:1.9.0")

    implementation ("com.airbnb.android:lottie:5.0.3" )// Check for the latest version
    implementation ("com.airbnb.android:lottie-compose:6.1.0")

    implementation ("com.intuit.sdp:sdp-android:1.0.6")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")


    //for video
    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:core:12.0.0")
    // SSP (for scalable sp)
    implementation ("com.intuit.ssp:ssp-android:1.0.6")
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    //noinspection GradleDependency
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    //noinspection GradleDependency
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")
// ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
// Annotation processor
    //noinspection LifecycleAnnotationProcessorWithJava8
    kapt("androidx.lifecycle:lifecycle-compiler:2.7.0")
    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.github.bumptech.glide:glide:4.13.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.13.0")

    implementation ("androidx.paging:paging-runtime:3.2.0")

    // For Kotlin coroutines support
    implementation ("androidx.paging:paging-common-ktx:3.2.0")

    implementation( "com.google.accompanist:accompanist-pager:0.32.0" )// Check for the latest version
    implementation( "com.google.accompanist:accompanist-pager-indicators:0.32.0")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")  // Use the latest version
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
}