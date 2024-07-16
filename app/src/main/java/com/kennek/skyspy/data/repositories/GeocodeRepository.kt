package com.kennek.skyspy.data.repositories

import com.kennek.skyspy.data.remote.GeoCodeApi
import com.kennek.skyspy.data.remote.responses.Result
import com.kennek.skyspy.util.Constants.GEOCODE_COUNT
import com.kennek.skyspy.util.Constants.GEOCODE_LANG
import com.kennek.skyspy.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class GeocodeRepository @Inject constructor(
    private val geoCodeApi: GeoCodeApi
){
    private suspend fun getCoordinates(newLocationName: String): Resource<Pair<Double, Double>> {
        return try {
            val response: Result = geoCodeApi.getCoordinates(newLocationName, GEOCODE_COUNT, GEOCODE_LANG).results.first()
            val coordinates: Pair<Double, Double> = Pair(response.latitude, response.longitude)
            Resource.Success(coordinates)
        } catch (e: Exception) {
            Resource.Error(
                message = "An error has occurred\n$e"
            )
        }
    }

    suspend fun isLocationNameValid(locationName: String): Resource<Pair<Double, Double>> {
        val response: Resource<Pair<Double, Double>> = getCoordinates(locationName)
        return response
    }
}