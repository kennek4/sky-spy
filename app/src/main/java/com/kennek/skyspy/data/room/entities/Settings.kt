package com.kennek.skyspy.data.room.entities

import androidx.room.Entity

@Entity
data class Settings(
    val latitude: String,
    val longitude: String,
    val currentLocation: String,
    val units: String,
)
