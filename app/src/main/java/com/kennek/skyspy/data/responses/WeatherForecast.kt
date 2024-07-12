package com.kennek.skyspy.data.responses

data class WeatherForecast(
    val current: Current,
    val current_units: CurrentUnits,
    val daily: Daily,
    val daily_units: DailyUnits,
    val elevation: Int,
    val generationtime_ms: Double,
    val hourly: Hourly,
    val hourly_units: HourlyUnits,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val timezone_abbreviation: String,
    val utc_offset_seconds: Int
)