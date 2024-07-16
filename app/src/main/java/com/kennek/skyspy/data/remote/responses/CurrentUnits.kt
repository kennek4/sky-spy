package com.kennek.skyspy.data.remote.responses

data class CurrentUnits(
    val apparent_temperature: String,
    val interval: String,
    val precipitation: String,
    val temperature_2m: String,
    val time: String
)