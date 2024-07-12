// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

    // Dagger Hilt
    id("com.google.dagger.hilt.android") version "2.51.1" apply false

    // Room
    id("androidx.room") version "2.6.1" apply false

}

buildscript {
    dependencies {
    }
}