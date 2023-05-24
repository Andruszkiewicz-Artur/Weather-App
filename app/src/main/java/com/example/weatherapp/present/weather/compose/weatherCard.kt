package com.example.weatherapp.present.weather.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.present.WeatherState
import com.example.weatherapp.unit.compose.specifyWeatherInfo.SpecifyWeatherDataInfo
import com.example.weatherapp.unit.compose.specifyWeatherInfo.WeatherDataInfo
import kotlin.math.roundToInt

@Composable
fun WeatherCard(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.currentWeatherData?.let { data ->
        Box(
            modifier = modifier
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = data.weatherType.weatherDesc,
                    modifier = Modifier.fillMaxWidth(0.9f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${data.temperatureCelsius}°",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onBackground
                )
                Text(
                    text = data.weatherType.weatherDesc,
                    style = TextStyle().copy(
                        color = MaterialTheme.colors.onBackground.copy(alpha = 0.4f),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = modifier.height(32.dp))
                SpecifyWeatherDataInfo(
                    pressure = data.pressure,
                    humidity = data.humidity,
                    windSpeed = data.windSpeed
                )
            }
        }
    }
}