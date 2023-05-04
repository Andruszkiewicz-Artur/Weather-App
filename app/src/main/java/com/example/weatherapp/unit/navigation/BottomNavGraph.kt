package com.example.weatherapp.unit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weatherapp.present.location.compose.LocationPresentation
import com.example.weatherapp.present.weather.compose.WeatherPresentation

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Weather.route
    ) {
        composable(route = BottomBarScreen.Weather.route) {
            WeatherPresentation()
        }

        composable(route = BottomBarScreen.Location.route) {
            LocationPresentation()
        }
    }
}