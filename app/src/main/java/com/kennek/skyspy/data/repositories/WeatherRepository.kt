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

}