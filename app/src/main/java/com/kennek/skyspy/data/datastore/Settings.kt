package com.kennek.skyspy.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

interface Settings {
    suspend fun getLocationName(): String
    suspend fun getLatitude(): Double
    suspend fun getLongitude(): Double
    fun getDataStore(): DataStore<Preferences>
}
