package com.kennek.skyspy.data.responses

data class Forecast(
    val cnt: Int,
    val cod: String,
    val list: List<Any>,
    val message: Int
)