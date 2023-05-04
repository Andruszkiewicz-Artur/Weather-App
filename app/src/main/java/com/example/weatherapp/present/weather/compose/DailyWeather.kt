package com.example.weatherapp.present.weather.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.data.mappers.toWeatherDailyData
import com.example.weatherapp.domain.weather.WeatherInfo

@Composable
fun DailyWeather(
    weatherInfo: WeatherInfo?
) {
    weatherInfo?.weatherDataPerDay?.let { data ->
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Daily weather",
                fontSize = 20.sp,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(16.dp))

            data.forEach {
                DailyWeatherDisplay(
                    weatherDailyData = weatherInfo.toWeatherDailyData(it.key)
                )
            }
        }
    }
}