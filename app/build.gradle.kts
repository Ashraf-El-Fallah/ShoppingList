plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")

}

android {
    namespace = "com.af.shoppinglist"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.af.shoppinglist"
        minSdk = 24
        targetSdk = 33
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
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8

        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
//        jvmTarget = "1.8"
        jvmTarget="17"

    }

    buildFeatures{
        viewBinding=true
    }


}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val room_version = "2.5.2"
    val kodein_version = "6.4.0"
    val lifecycle_version = "2.6.2"

    // Room
    implementation ("androidx.room:room-runtime:$room_version")
    implementation ("androidx.room:room-ktx:$room_version")
    ksp ("androidx.room:room-compiler:$room_version")

    //view model
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")  //this used only without view model or live data but it works here :)
    //Annotation processor
    ksp ("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

    //live data
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")



    //i don't know where should i use it

//    implementation ("androidx.legacy:legacy-support-v4:1.0.0")/////
//    implementation ("androidx.lifecycle:lifecycle-extensions:2.1.0")/////
    //implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"


    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

    // New Material Design
    implementation("com.google.android.material:material:1.9.0")

//    // Kodein
    implementation ("org.kodein.di:kodein-di-generic-jvm:$kodein_version")
    implementation ("org.kodein.di:kodein-di-framework-android-x:$kodein_version")
}