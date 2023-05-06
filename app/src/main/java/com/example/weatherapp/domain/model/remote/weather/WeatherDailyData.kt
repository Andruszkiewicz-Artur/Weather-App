package com.example.weatherapp.domain.model.remote.weather

import java.time.LocalDateTime

data class WeatherDailyData(
    val data: LocalDateTime?,
    val maxDegree: Double?,
    val minDegree: Double?,
    val weatherType: WeatherType?
)
