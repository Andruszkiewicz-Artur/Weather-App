package com.example.weatherapp.present.dailyWeather.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.data.mappers.toWeatherDailyData
import com.example.weatherapp.domain.model.remote.weather.WeatherInfo

@Composable
fun DailyWeatherPresentation(
    weatherInfo: WeatherInfo?
) {
    weatherInfo?.weatherDataPerDay?.let { data ->
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            DailyCardWeather(
                weatherDailyData = weatherInfo.toWeatherDailyData(0)
            )

            Spacer(modifier = Modifier.height(16.dp))

            data.forEach {
                if (it.key != 0) {
                    DailyWeather(
                        weatherDailyData = weatherInfo.toWeatherDailyData(it.key)
                    )
                }
            }
        }
    }
}