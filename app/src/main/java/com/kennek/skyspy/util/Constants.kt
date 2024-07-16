package com.kennek.skyspy.util

object Constants {
    const val BASE_API_URL = "https://api.open-meteo.com/v1/forecast/"
    const val CURRENT = "temperature_2m,apparent_temperature,precipitation"
    const val HOURLY = "temperature_2m,precipitation"
    const val DAILY = "temperature_2m_max,temperature_2m_min,sunrise,sunset"
    const val TIMEZONE = "auto"

    const val BASE_GEOCODE_URL = "https://geocoding-api.open-meteo.com/v1/search/"
    const val GEOCODE_COUNT = 1
    const val GEOCODE_LANG = "en"
}