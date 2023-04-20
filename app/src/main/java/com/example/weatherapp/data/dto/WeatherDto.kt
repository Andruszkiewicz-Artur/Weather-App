package com.example.weatherapp.data.dto

import com.example.weatherapp.data.remote.WeatherDataDto
import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "hourly")
    val weatherData: WeatherDataDto
)
