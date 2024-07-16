package com.kennek.skyspy.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.kennek.skyspy.util.Resource

interface DataStoreSettings {
    suspend fun updateLocationName(newLocationName: String)
    suspend fun updateCoordinates(latitude: Double, longitude: Double)
    suspend fun getLatitude(): Double
    suspend fun getLongitude(): Double
    suspend fun getLocationName(): String
    suspend fun isLocationNameValid(locationName: String): Resource<Pair<Double, Double>>
    fun getDataStore(): DataStore<Preferences>
}