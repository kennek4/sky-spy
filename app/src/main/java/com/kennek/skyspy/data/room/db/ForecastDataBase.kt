package com.kennek.skyspy.data.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.kennek.skyspy.data.room.dao.ForecastDao
import com.kennek.skyspy.data.room.entities.Forecast

@Database(
    entities = [Forecast::class],
    version = 1
)
abstract class ForecastDataBase: RoomDatabase() {
    abstract fun forecastDao(): ForecastDao
}
