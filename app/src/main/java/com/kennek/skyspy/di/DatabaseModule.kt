package com.kennek.skyspy.di

import android.content.Context
import androidx.room.Room
import com.kennek.skyspy.data.room.dao.ForecastDao
import com.kennek.skyspy.data.room.db.ForecastDataBase
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
    fun provideForecastDao(
        forecastDataBase: ForecastDataBase
    ): ForecastDao {
        return forecastDataBase.forecastDao()
    }

    @Singleton
    @Provides
    fun provideForecastDatabase(@ApplicationContext context: Context): ForecastDataBase {
        return Room.databaseBuilder(
            context,
            ForecastDataBase::class.java,
            "forecast"
        ).build()
    }

}