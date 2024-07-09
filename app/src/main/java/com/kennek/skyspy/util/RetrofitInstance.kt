package com.kennek.skyspy.util

import com.kennek.skyspy.data.remote.WeatherApi
import com.kennek.skyspy.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(WeatherApi::class.java)
    }
}