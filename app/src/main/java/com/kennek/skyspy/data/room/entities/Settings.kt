package com.kennek.skyspy.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Settings(
    val latitude: String,
    val longitude: String,
    val currentLocation: String,
    val units: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
