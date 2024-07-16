package com.kennek.skyspy.data.remote

import com.kennek.skyspy.data.remote.responses.GeocodeResponse
import com.kennek.skyspy.util.Constants.BASE_GEOCODE_URL
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoCodeApi {
    @GET(BASE_GEOCODE_URL)
    suspend fun getCoordinates(
        @Query("name") name: String,
        @Query("count") count: Int,
        @Query("language") lang: String
    ): GeocodeResponse
}