package com.kennek.skyspy.di

import com.kennek.skyspy.data.remote.GeoCodeApi
import com.kennek.skyspy.data.remote.WeatherApi
import com.kennek.skyspy.data.repositories.GeocodeRepository
import com.kennek.skyspy.data.repositories.WeatherRepository
import com.kennek.skyspy.data.repositories.sources.LocalWeatherDataSource
import com.kennek.skyspy.data.repositories.sources.RemoteWeatherDataSource
import com.kennek.skyspy.data.room.dao.CurrentWeatherDao
import com.kennek.skyspy.data.room.dao.DateForecastDao
import com.kennek.skyspy.util.Constants.BASE_API_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGeocodeApi(): GeoCodeApi {
        val instance: GeoCodeApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_API_URL)
            .build()
            .create(GeoCodeApi::class.java)

        return instance
    }

    @Singleton
    @Provides
    fun provideGeocodeRepository(
        geoCodeApi: GeoCodeApi
    ): GeocodeRepository = GeocodeRepository(geoCodeApi)

    @Singleton
    @Provides
    fun provideWeatherApi(): WeatherApi {
        val instance: WeatherApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_API_URL)
            .build()
            .create(WeatherApi::class.java)

        return instance
    }

    @Singleton
    @Provides
    fun provideWeatherRepository(
        localWeatherDataSource: LocalWeatherDataSource,
        remoteWeatherDataSource: RemoteWeatherDataSource,
        geocodeRepository: GeocodeRepository
    ): WeatherRepository = WeatherRepository(localWeatherDataSource, remoteWeatherDataSource, geocodeRepository)

    @Singleton
    @Provides
    fun provideLocalWeatherDataSource(
        currentWeatherDao: CurrentWeatherDao,
        forecastDao: DateForecastDao
    ): LocalWeatherDataSource = LocalWeatherDataSource(currentWeatherDao, forecastDao)

    @Singleton
    @Provides
    fun provideRemoteWeatherDataSource(
        api: WeatherApi,
    ) : RemoteWeatherDataSource = RemoteWeatherDataSource(api)
}