package com.kennek.skyspy.data.sources

import com.kennek.skyspy.data.remote.WeatherApi
import com.kennek.skyspy.data.responses.WeatherForecast
import com.kennek.skyspy.util.Resource
import javax.inject.Inject

class RemoteWeatherDataSource @Inject constructor(
    private val api: WeatherApi
){
    suspend fun getForecast(
        latitude: Float,
        longitude: Float,
        current: String,
        hourly: String,
        daily: String,
        timezone: String
    ): Resource<WeatherForecast> {
        try {
            val response = api.getForecast(
                latitude,
                longitude,
                current,
                hourly,
                daily,
                timezone
            )
            return Resource.Success(
                data = response
            )
        } catch (e: Exception) {
            return Resource.Error(
                message = "An error has occurred.\n$e"
            )
        }
    }
}