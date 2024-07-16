package com.kennek.skyspy.data.remote.responses

data class Current(
    val apparent_temperature: Double,
    val interval: Int,
    val precipitation: Int,
    val temperature_2m: Double,
    val time: String
)