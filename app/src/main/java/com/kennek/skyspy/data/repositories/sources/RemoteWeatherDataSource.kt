package com.kennek.skyspy.data.repositories.sources

import com.kennek.skyspy.data.remote.WeatherApi
import com.kennek.skyspy.data.remote.responses.WeatherForecast
import com.kennek.skyspy.util.Constants.CURRENT
import com.kennek.skyspy.util.Constants.DAILY
import com.kennek.skyspy.util.Constants.HOURLY
import com.kennek.skyspy.util.Constants.TIMEZONE
import com.kennek.skyspy.util.Resource
import javax.inject.Inject

class RemoteWeatherDataSource @Inject constructor(
    private val api: WeatherApi
){
    suspend fun getForecast(
        latitude: Double,
        longitude: Double
    ): Resource<WeatherForecast> {
        return try {
            val response: WeatherForecast = api.getForecast(
                latitude,
                longitude,
                CURRENT,
                HOURLY,
                DAILY,
                TIMEZONE
            )
            Resource.Success(
                data = response
            )
        } catch (e: Exception) {
            Resource.Error(
                message = "An error has occurred.\n$e"
            )
        }
    }
}