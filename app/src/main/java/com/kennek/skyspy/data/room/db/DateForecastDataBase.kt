package com.kennek.skyspy.data.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kennek.skyspy.data.room.dao.DateForecastDao
import com.kennek.skyspy.data.room.converters.Converters
import com.kennek.skyspy.data.room.entities.DateForecast

@Database(
    entities = [DateForecast::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class DateForecastDataBase: RoomDatabase() {
    abstract fun dateForecastDao(): DateForecastDao
}