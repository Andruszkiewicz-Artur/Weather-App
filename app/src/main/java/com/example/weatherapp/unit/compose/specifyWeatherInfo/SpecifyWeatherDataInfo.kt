package com.example.weatherapp.unit.compose.specifyWeatherInfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.weatherapp.R
import kotlin.math.roundToInt

@Composable
fun SpecifyWeatherDataInfo(
    pressure: Double,
    humidity: Double,
    windSpeed: Double
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        WeatherDataInfo(
            value = pressure.roundToInt(),
            unit = "hpa",
            icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
            iconTint = MaterialTheme.colors.onBackground,
            title = "Pressure"
        )
        WeatherDataInfo(
            value = humidity.roundToInt(),
            unit = "%",
            icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
            iconTint = MaterialTheme.colors.primary,
            title = "Humidity"
        )
        WeatherDataInfo(
            value = windSpeed.roundToInt(),
            unit = "km/h",
            icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
            iconTint = MaterialTheme.colors.onBackground,
            title = "Wind Speed"
        )
    }
}