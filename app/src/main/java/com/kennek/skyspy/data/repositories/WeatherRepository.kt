package com.kennek.skyspy.data.repositories

import com.kennek.skyspy.data.sources.LocalWeatherDataSource
import com.kennek.skyspy.data.sources.RemoteWeatherDataSource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class WeatherRepository @Inject constructor(
    private val localWeatherDataSource: LocalWeatherDataSource,
    private val remoteWeatherDataSource: RemoteWeatherDataSource,
){
    suspend fun getCurrentWeather(): Boolean {
        try {
            val response = remoteWeatherDataSource.getCurrentWeather(113.49f, 53.55f, "metric", "en")
            println(response)

        } catch (error: Exception) {
            println(error)
            return false
        }

        return true
    }
}