package com.kennek.skyspy.data.remote

import com.kennek.skyspy.data.responses.CurrentWeather
import com.kennek.skyspy.data.responses.Forecast
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather?lat={lat}&lon={lon}&units={units}&lang={lang}&appid={appId}")
    suspend fun getCurrentWeather(
        @Query("lon") lon: Float,
        @Query("lat") lat: Float,
        @Query("units") units: String,
        @Query("lang") lang: String,
        @Query("appId") appId: String
    ): CurrentWeather

    @GET("data/2.5/forecast?lat={lat}&lon={lon}&units={units}&lang={lang}&appid={appId}")
    suspend fun getForecast(
        @Query("lon") lon: Float,
        @Query("lat") lat: Float,
        @Query("units") units: String,
        @Query("lang") lang: String,
        @Query("appId") appId: String
    ): Forecast
}