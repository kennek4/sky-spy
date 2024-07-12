package com.kennek.skyspy.data.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kennek.skyspy.data.room.dao.SettingsDao
import com.kennek.skyspy.data.room.entities.Settings

@Database(
    entities = [Settings::class],
    version = 1
)
abstract class SettingsDataBase: RoomDatabase() {
    abstract fun getSettings(): SettingsDao
}