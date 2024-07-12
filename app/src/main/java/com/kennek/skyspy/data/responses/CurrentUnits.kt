package com.kennek.skyspy.data.responses

data class CurrentUnits(
    val apparent_temperature: String,
    val interval: String,
    val precipitation: String,
    val temperature_2m: String,
    val time: String,
    val wind_direction_10m: String,
    val wind_speed_10m: String
)