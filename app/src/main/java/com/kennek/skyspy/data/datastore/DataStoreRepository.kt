package com.kennek.skyspy.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.kennek.skyspy.data.repositories.GeocodeRepository
import com.kennek.skyspy.util.Resource
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class DataStoreRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val geocodeRepository: GeocodeRepository
) : DataStoreSettings {

    override suspend fun updateCoordinates(latitude: Double, longitude: Double) {
        dataStore.edit { settings ->
            val latitudeKey: Preferences.Key<Double> = doublePreferencesKey("latitude")
            val longitudeKey: Preferences.Key<Double> = doublePreferencesKey("longitude")

            settings[latitudeKey] = latitude
            settings[longitudeKey] = longitude
        }
    }

    override suspend fun updateLocationName(newLocationName: String) {
        dataStore.edit { settings ->
            val locationKey: Preferences.Key<String> = stringPreferencesKey("location")
            settings[locationKey] = newLocationName
        }
    }

    override suspend fun getLatitude(): Double {
        val latitudeKey: Preferences.Key<Double> = doublePreferencesKey("latitude")
        val settings: Preferences = dataStore.data.first()
        return settings[latitudeKey]!!
    }

    override suspend fun getLongitude(): Double {
        val longitudeKey: Preferences.Key<Double> = doublePreferencesKey("longitude")
        val settings: Preferences = dataStore.data.first()
        return settings[longitudeKey]!!
    }

    override suspend fun getLocationName(): String {
        val locationKey: Preferences.Key<String> = stringPreferencesKey("location")
        val settings: Preferences = dataStore.data.first()
        return settings[locationKey]!!
    }

    override suspend fun isLocationNameValid(locationName: String): Resource<Pair<Double, Double>> {
        return geocodeRepository.isLocationNameValid(locationName)
    }

    override fun getDataStore(): DataStore<Preferences> = dataStore
}