package com.kennek.skyspy.data.responses

data class HourlyUnits(
    val precipitation: String,
    val precipitation_probability: String,
    val temperature_2m: String,
    val time: String
)