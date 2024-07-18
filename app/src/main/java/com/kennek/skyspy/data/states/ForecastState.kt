package com.kennek.skyspy.data.states

import com.kennek.skyspy.data.room.entities.DateForecast

data class ForecastState(
    val containsData: Boolean = false,
    val data: List<DateForecast> = emptyList(),
)
