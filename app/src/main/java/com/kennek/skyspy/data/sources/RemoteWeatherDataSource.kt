package com.kennek.skyspy.data.sources

import com.kennek.skyspy.data.remote.WeatherApi
import com.kennek.skyspy.data.responses.CurrentWeather
import com.kennek.skyspy.data.responses.Forecast
import com.kennek.skyspy.util.Resource
import javax.inject.Inject

class RemoteWeatherDataSource @Inject constructor(
    private val api: WeatherApi
) {

    suspend fun getCurrentWeather(
        lon: Float,
        lat: Float,
        units: String,
        lang: String,
        appId: String
    ): Resource<CurrentWeather> {
        val response = try {
            api.getCurrentWeather(lon, lat, units, lang, appId)
        } catch (error: Exception) {
            return Resource.Error(message = "An error has occurred. $error")
        }

        return Resource.Success(response)
    }

    suspend fun getForecast(
        lon: Float,
        lat: Float,
        units: String,
        lang: String,
        appId: String
    ): Resource<Forecast> {

        val response = try {
            api.getForecast(lon, lat, units, lang, appId)
        } catch (error: Exception) {
            return Resource.Error(message = "An error has occurred. $error")
        }

        return Resource.Success(response)
    }
}