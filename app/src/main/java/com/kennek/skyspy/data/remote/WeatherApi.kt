package com.kennek.skyspy.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET()
    suspend fun getCurrentWeather()

    @GET()
    suspend fun getForecast()
}