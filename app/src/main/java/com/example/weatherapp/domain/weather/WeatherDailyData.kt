package com.example.weatherapp.domain.weather

import java.time.LocalDateTime

data class WeatherDailyData(
    val data: LocalDateTime?,
    val maxDegree: Double?,
    val minDegree: Double?,
    val weatherType: WeatherType?
)
