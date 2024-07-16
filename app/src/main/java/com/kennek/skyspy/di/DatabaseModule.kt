package com.kennek.skyspy.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.kennek.skyspy.data.room.converters.Converters
import com.kennek.skyspy.data.room.dao.CurrentWeatherDao
import com.kennek.skyspy.data.room.dao.DateForecastDao
import com.kennek.skyspy.data.room.db.CurrentWeatherDataBase
import com.kennek.skyspy.data.room.db.DateForecastDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideGsonObject() : Gson = Gson()

    // CurrentWeather DI
    @Singleton
    @Provides
    fun provideCurrentWeatherDao(
        currentWeatherDataBase: CurrentWeatherDataBase
    ): CurrentWeatherDao {
        return currentWeatherDataBase.currentWeatherDao()
    }

    @Singleton
    @Provides
    fun provideCurrentWeatherDatabase(@ApplicationContext context: Context): CurrentWeatherDataBase {
        return Room.databaseBuilder(
            context,
            CurrentWeatherDataBase::class.java,
            "current_weather"
        ).build()
    }

    // Forecast DI
    @Singleton
    @Provides
    fun provideForecastDao(
        forecastDataBase: DateForecastDataBase
    ): DateForecastDao {
        return forecastDataBase.dateForecastDao()
    }

    @Singleton
    @Provides
    fun provideForecastDatabase(@ApplicationContext context: Context, gson: Gson): DateForecastDataBase {
        return Room.databaseBuilder(
            context,
            DateForecastDataBase::class.java,
            "forecast"
        ).addTypeConverter(Converters(gson)).build()
    }

}