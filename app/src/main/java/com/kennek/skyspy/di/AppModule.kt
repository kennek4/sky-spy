package com.kennek.skyspy.di

import com.kennek.skyspy.data.remote.WeatherApi
import com.kennek.skyspy.data.repositories.WeatherRepository
import com.kennek.skyspy.data.sources.LocalWeatherDataSource
import com.kennek.skyspy.data.sources.RemoteWeatherDataSource
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
        val instance = Retrofit.Builder()
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
    ) = WeatherRepository(localWeatherDataSource, remoteWeatherDataSource)

    @Singleton
    @Provides
    fun provideLocalWeatherDataSource() = LocalWeatherDataSource()

    @Singleton
    @Provides
    fun provideRemoteWeatherDataSource(
        api: WeatherApi,
    ) = RemoteWeatherDataSource(api)
}