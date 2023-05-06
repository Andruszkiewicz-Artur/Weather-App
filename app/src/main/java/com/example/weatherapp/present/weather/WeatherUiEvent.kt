package com.example.weatherapp.present.weather

sealed class WeatherUiEvent {
    object removeLocation: WeatherUiEvent()
}