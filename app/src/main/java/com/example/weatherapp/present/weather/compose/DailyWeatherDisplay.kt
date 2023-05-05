package com.example.weatherapp.present.weather.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.domain.weather.WeatherDailyData
import java.time.format.DateTimeFormatter

@Composable
fun DailyWeatherDisplay(
    weatherDailyData: WeatherDailyData
) {
    val timeFormatted = remember(weatherDailyData) {
        weatherDailyData.data?.format(
            DateTimeFormatter.ofPattern("E")
        )
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        MaterialTheme.colors.primary,
                        MaterialTheme.colors.primaryVariant
                    )
                ),
                alpha = 0.5f,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(vertical = 16.dp, horizontal = 32.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .width(100.dp)
        ) {
            Text(
                text = "${timeFormatted}",
                color = MaterialTheme.colors.onBackground,
                fontWeight = FontWeight.Bold
            )

            Image(
                painter = painterResource(id = weatherDailyData.weatherType?.iconRes ?: 0),
                contentDescription = null,
                modifier = Modifier.width(40.dp)
            )
        }

        Text(
            text = "${weatherDailyData.minDegree} C/${weatherDailyData.maxDegree} C",
            color = MaterialTheme.colors.onBackground
        )
    }
}