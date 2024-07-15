package com.kennek.skyspy.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SettingsRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
): Settings {

    override suspend fun getLocationName(): String {
        val locationKey: Preferences.Key<String> = stringPreferencesKey("location")
        val preferences: Preferences = dataStore.data.first()
        return preferences[locationKey] ?: ""
    }

    override suspend fun getLatitude(): Double {
        val latitudeKey: Preferences.Key<Double> = doublePreferencesKey("latitude")
        val preferences: Preferences = dataStore.data.first()
        return preferences[latitudeKey] ?: 0.0
    }

    override suspend fun getLongitude(): Double {
        val longitudeKey: Preferences.Key<Double> = doublePreferencesKey("longitude")
        val preferences: Preferences = dataStore.data.first()
        return preferences[longitudeKey] ?: 0.0
    }

    override fun getDataStore(): DataStore<Preferences> {
        return dataStore
    }
}