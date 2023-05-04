package com.example.weatherapp.unit.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Weather: BottomBarScreen(
        route = "weather_route",
        title = "Weather",
        icon = Icons.Default.Home
    )

    object Location: BottomBarScreen(
        route = "location_route",
        title = "Location",
        icon = Icons.Default.LocationOn
    )
}
