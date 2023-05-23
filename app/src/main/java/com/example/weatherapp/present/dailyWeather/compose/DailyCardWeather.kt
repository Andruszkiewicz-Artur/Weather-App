package com.example.weatherapp.present.dailyWeather.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.domain.model.remote.weather.WeatherDailyData

@Composable
fun DailyCardWeather(
    weatherDailyData: WeatherDailyData
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(0.95f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = weatherDailyData.weatherType!!.iconRes),
            contentDescription = weatherDailyData.weatherType.weatherDesc,
            modifier = Modifier
                .fillMaxWidth(0.4f)
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Tommorow",
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal
            )

            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "${weatherDailyData.maxDegree}",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.ExtraBold,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "/${weatherDailyData.minDegree}°",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.4f)
                )
            }

            Text(
                text = weatherDailyData.weatherType.weatherDesc,
                style = MaterialTheme.typography.subtitle2.copy(color = MaterialTheme.colors.onBackground.copy(alpha = 0.4f))
            )
        }
    }
}