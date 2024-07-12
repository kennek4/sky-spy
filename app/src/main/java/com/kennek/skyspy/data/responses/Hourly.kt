package com.kennek.skyspy.data.responses

data class Hourly(
    val precipitation: List<Double>,
    val temperature_2m: List<Double>,
    val time: List<String>
)