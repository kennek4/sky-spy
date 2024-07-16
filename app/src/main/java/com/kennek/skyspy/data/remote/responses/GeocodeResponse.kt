package com.kennek.skyspy.data.remote.responses

data class GeocodeResponse(
    val generationtime_ms: Double,
    val results: List<Result>
)