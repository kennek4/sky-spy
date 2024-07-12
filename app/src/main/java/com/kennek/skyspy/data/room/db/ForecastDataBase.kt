package com.kennek.skyspy.data.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kennek.skyspy.data.room.dao.ForecastDAO
import com.kennek.skyspy.data.room.entities.Forecast

@Database(
    entities = [Forecast::class],
    version = 1
)
abstract class ForecastDataBase: RoomDatabase() {
    abstract val dao: ForecastDAO
}
