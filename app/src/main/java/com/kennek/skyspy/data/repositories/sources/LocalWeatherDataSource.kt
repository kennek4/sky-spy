package com.kennek.skyspy.data.repositories.sources

import com.kennek.skyspy.data.remote.responses.WeatherForecast
import com.kennek.skyspy.data.room.db.CurrentWeatherDataBase
import com.kennek.skyspy.data.room.db.DateForecastDataBase
import javax.inject.Inject

class LocalWeatherDataSource @Inject constructor(
    private val currentWeatherDataBase: CurrentWeatherDataBase,
    private val forecastDataBase: DateForecastDataBase
){
    suspend fun saveForecast(forecast: WeatherForecast) {
        TODO("Parse forecast data here")
    }
}