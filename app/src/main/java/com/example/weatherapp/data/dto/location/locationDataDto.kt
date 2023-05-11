package com.example.weatherapp.data.dto.location

import com.squareup.moshi.Json

data class locationDataDto(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "wikiDataId")
    val wikiDataId: String,
    @field:Json(name = "type")
    val type: String,
    @field:Json(name = "city")
    val city: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "country")
    val country: String,
    @field:Json(name = "countryCode")
    val countryCode: String,
    @field:Json(name = "region")
    val region: String,
    @field:Json(name = "regionCode")
    val regionCode: Int,
    @field:Json(name = "latitude")
    val latitude: Double,
    @field:Json(name = "longitude")
    val longitude: Double,
    @field:Json(name = "population")
    val population: Int,
)