package com.kennek.skyspy.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.kennek.skyspy.data.room.entities.CurrentWeather

@Dao
interface CurrentWeatherDao {
    @Insert
    suspend fun insertCurrentWeather(currentWeather: CurrentWeather)

    @Update
    suspend fun updateCurrentWeather(currentWeather: CurrentWeather)

    @Delete
    suspend fun deleteCurrentWeather(currentWeather: CurrentWeather)
}