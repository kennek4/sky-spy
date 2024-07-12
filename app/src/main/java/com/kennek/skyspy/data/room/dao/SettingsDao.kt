package com.kennek.skyspy.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kennek.skyspy.data.room.entities.Settings

@Dao
interface SettingsDao {

    @Insert
    fun insertSettings(settings: Settings)

    @Delete
    fun deleteSettings(settings: Settings)

    @Query("SELECT * FROM settings")
    fun getSettings(): Settings
}