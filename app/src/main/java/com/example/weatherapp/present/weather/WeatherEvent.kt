package com.example.weatherapp.present.weather

import com.example.weatherapp.domain.model.local.location.Location

sealed interface WeatherEvent {
    data class removeLocation(val location: Location) : WeatherEvent
}