package com.kennek.skyspy.di

import android.content.Context
import androidx.room.Room
import com.kennek.skyspy.data.room.dao.SettingsDao
import com.kennek.skyspy.data.room.db.SettingsDataBase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SettingsModule {

    fun provideSettingsDao(
        settingsDataBase: SettingsDataBase
    ): SettingsDao {
      return settingsDataBase.getSettings()
    }

    fun provideSettingsDatabase(@ApplicationContext context: Context): SettingsDataBase {
        return Room.databaseBuilder(
            context,
            SettingsDataBase::class.java,
            "settings"
        ).build()
    }

}