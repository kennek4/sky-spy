package com.kennek.skyspy.data.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kennek.skyspy.data.room.dao.CurrentWeatherDao
import com.kennek.skyspy.data.room.entities.CurrentWeather

@Database(
    entities = [CurrentWeather::class],
    version = 1
)
abstract class CurrentWeatherDataBase: RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao
}