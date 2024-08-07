package com.kennek.skyspy.data.remote

import com.kennek.skyspy.data.remote.responses.WeatherForecast
import com.kennek.skyspy.util.Constants.BASE_API_URL
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(BASE_API_URL)
    suspend fun getForecast(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") current: String,
        @Query("hourly") hourly: String,
        @Query("daily") daily: String,
        @Query("timezone") timezone: String
    ): WeatherForecast
}