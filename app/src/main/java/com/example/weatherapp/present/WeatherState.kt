package com.example.weatherapp.present

import com.example.weatherapp.domain.model.remote.weather.WeatherData
import com.example.weatherapp.domain.model.remote.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val todayHourlyInfo: List<WeatherData> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
