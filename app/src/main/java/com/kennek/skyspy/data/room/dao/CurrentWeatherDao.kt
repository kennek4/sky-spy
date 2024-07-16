package com.kennek.skyspy.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kennek.skyspy.data.room.entities.CurrentWeather
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrentWeather(currentWeather: CurrentWeather)

    @Update
    suspend fun updateCurrentWeather(currentWeather: CurrentWeather)

    @Delete
    suspend fun deleteCurrentWeather(currentWeather: CurrentWeather)

    @Query("SELECT * FROM currentweather")
    fun getCurrentWeather(): Flow<List<CurrentWeather>>

    @Query("SELECT time FROM currentweather")
    suspend fun getLatestTime(): String

    @Query("SELECT (SELECT COUNT(*) FROM currentweather) == 0")
    suspend fun isEmpty(): Boolean
}