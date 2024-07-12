package com.kennek.skyspy.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kennek.skyspy.data.room.entities.Forecast

@Dao
interface ForecastDAO {

    @Insert
    suspend fun insertForecast(forecast: Forecast)

    @Delete
    suspend fun deleteForecast(forecast: Forecast)

    @Query("SELECT * FROM forecastentity")
    fun getAllForecast(): List<Forecast>

}
