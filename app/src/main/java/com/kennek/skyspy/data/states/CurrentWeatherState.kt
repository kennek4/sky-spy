package com.kennek.skyspy.data.states

import com.kennek.skyspy.data.room.entities.CurrentWeather
import java.time.LocalDateTime

data class CurrentWeatherState(
    val containsData: Boolean = false,
    val data: CurrentWeather? = null,
    val latestTime: LocalDateTime = LocalDateTime.now()
)
