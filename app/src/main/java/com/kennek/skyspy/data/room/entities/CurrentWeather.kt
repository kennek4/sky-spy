package com.kennek.skyspy.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrentWeather(
    val time: String,
    val temp: Double,
    val feelsLikeTemp: Double,
    val precipitation: Int,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
