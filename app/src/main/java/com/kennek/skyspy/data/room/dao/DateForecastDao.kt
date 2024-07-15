package com.kennek.skyspy.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kennek.skyspy.data.room.entities.DateForecast

@Dao
interface DateForecastDao {

    @Insert
    suspend fun insertForecast(forecast: DateForecast)

    @Delete
    suspend fun deleteForecast(forecast: DateForecast)

    @Query("SELECT * FROM dateforecast")
    fun getAllForecast(): List<DateForecast>
}