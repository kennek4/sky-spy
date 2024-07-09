package com.kennek.skyspy.data.sources

import com.kennek.skyspy.data.remote.WeatherApi
import javax.inject.Inject

class RemoteWeatherDataSource @Inject constructor(
    private val api: WeatherApi
) {

}