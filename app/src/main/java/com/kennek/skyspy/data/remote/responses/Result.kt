package com.kennek.skyspy.data.remote.responses

data class Result(
    val admin1: String,
    val admin1_id: Int,
    val admin3: String,
    val admin3_id: Int,
    val admin4: String,
    val admin4_id: Int,
    val country: String,
    val country_code: String,
    val country_id: Int,
    val elevation: Int,
    val feature_code: String,
    val id: Int,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val population: Int,
    val postcodes: List<String>,
    val timezone: String
)