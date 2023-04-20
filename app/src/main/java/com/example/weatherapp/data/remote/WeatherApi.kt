package com.example.weatherapp.data.remote

interface WeatherApi {

    suspend fun getWeatherData(
        @Query()
    )

}