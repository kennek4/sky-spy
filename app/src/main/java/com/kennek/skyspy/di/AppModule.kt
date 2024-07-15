package com.kennek.skyspy.di

import com.kennek.skyspy.data.datastore.SettingsRepository
import com.kennek.skyspy.data.remote.WeatherApi
import com.kennek.skyspy.data.repositories.WeatherRepository
import com.kennek.skyspy.data.repositories.sources.LocalWeatherDataSource
import com.kennek.skyspy.data.repositories.sources.RemoteWeatherDataSource
import com.kennek.skyspy.data.room.db.CurrentWeatherDataBase
import com.kennek.skyspy.data.room.db.DateForecastDataBase
import com.kennek.skyspy.util.Constants.BASE_URL
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
    fun provideWeatherApi(): WeatherApi {
        val instance: WeatherApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(WeatherApi::class.java)

        return instance
    }

    @Singleton
    @Provides
    fun provideWeatherRepository(
        localWeatherDataSource: LocalWeatherDataSource,
        remoteWeatherDataSource: RemoteWeatherDataSource,
        settingsRepository: SettingsRepository
    ): WeatherRepository = WeatherRepository(localWeatherDataSource, remoteWeatherDataSource, settingsRepository)

    @Singleton
    @Provides
    fun provideLocalWeatherDataSource(
        currentWeatherDataBase: CurrentWeatherDataBase,
        forecastDataBase: DateForecastDataBase
    ): LocalWeatherDataSource = LocalWeatherDataSource(currentWeatherDataBase, forecastDataBase)

    @Singleton
    @Provides
    fun provideRemoteWeatherDataSource(
        api: WeatherApi,
    ) : RemoteWeatherDataSource = RemoteWeatherDataSource(api)
}