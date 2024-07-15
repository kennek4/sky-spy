package com.kennek.skyspy.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kennek.skyspy.data.room.custom.HourlyDoubleList
import com.kennek.skyspy.data.room.custom.HourlyStringList

@Entity
data class DateForecast(
    val date: String,
    val tempHigh: Double,
    val tempMin: Double,
    val sunRise: String,
    val sunSet: String,
    val hours: HourlyStringList,
    val hourlyTemps: HourlyDoubleList,
    val hourlyPrecipitation: HourlyDoubleList,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
