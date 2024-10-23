plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("kapt")
    id ("kotlin-parcelize")
   // id("com.google.gms.google-services")

}

android {
    namespace = "com.example.domain"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.firestore.ktx)
    implementation( platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation (libs.firebase.auth)
    implementation("com.google.android.gms:play-services-auth:21.2.0")

    implementation ("com.google.code.gson:gson:2.9.1")
    implementation ("androidx.room:room-runtime:2.5.1")
    kapt ("androidx.room:room-compiler:2.5.1")
//    implementation(project(":data"))
//    implementation(project(":app"))
    val room_version = "2.5.0" // Or use the latest version
    implementation( "androidx.room:room-runtime:$room_version")
    implementation( "androidx.room:room-ktx:$room_version") // Add this line
    kapt( "androidx.room:room-compiler:$room_version")
    implementation ("androidx.paging:paging-runtime:3.2.0")


    //moshi
    implementation ("com.squareup.moshi:moshi:1.14.0")

    // Moshi adapter for Kotlin support
    implementation ("com.squareup.moshi:moshi-kotlin:1.14.0")

    // (Optional) If using Retrofit, you can add this to work with Moshi:
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")

    // For Kotlin coroutines support
    implementation ("androidx.paging:paging-common-ktx:3.2.0")
    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
}