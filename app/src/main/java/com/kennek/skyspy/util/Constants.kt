package com.kennek.skyspy.util

object Constants {
    const val BASE_URL = "https://api.open-meteo.com/v1/forecast/"
    const val CURRENT = "current=temperature_2m,apparent_temperature,precipitation"
    const val HOURLY = "hourly=temperature_2m,precipitation"
    const val DAILY = "daily=temperature_2m_max,temperature_2m_min,sunrise,sunset"
    const val TIMEZONE = "timezone=auto"
}