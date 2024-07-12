package com.kennek.skyspy.data.responses

data class Hourly(
    val precipitation: List<Double>,
    val precipitation_probability: List<Int>,
    val temperature_2m: List<Double>,
    val time: List<String>
)