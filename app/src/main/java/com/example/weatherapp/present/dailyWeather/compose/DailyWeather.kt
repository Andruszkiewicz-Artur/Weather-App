package com.example.weatherapp.present.dailyWeather.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.domain.model.remote.weather.WeatherDailyData
import com.example.weatherapp.unit.extensions.toDegree
import java.time.format.DateTimeFormatter

@Composable
fun DailyWeather(
    weatherDailyData: WeatherDailyData
) {
    val timeFormatted = remember(weatherDailyData) {
        weatherDailyData.data?.format(
            DateTimeFormatter.ofPattern("E")
        )
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = "${timeFormatted}",
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.4f),
            fontWeight = FontWeight.Bold
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = weatherDailyData.weatherType?.iconRes ?: 0),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = weatherDailyData.weatherType?.weatherDesc ?: ""
            )
        }

        Row {
            Text(
                text = weatherDailyData.minDegree?.toDegree() ?: "",
                color = MaterialTheme.colors.onBackground
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = weatherDailyData.maxDegree?.toDegree() ?: "",
                color = MaterialTheme.colors.onBackground.copy(alpha = 0.4f)
            )
        }
    }

}