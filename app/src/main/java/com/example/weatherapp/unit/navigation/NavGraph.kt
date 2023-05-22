package com.example.weatherapp.unit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weatherapp.present.weather.compose.WeatherPresentation

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.Today.route
    ) {
        composable(route = NavigationScreen.Today.route) {
            WeatherPresentation()
        }
        composable(route = NavigationScreen.Daily.route) {
            WeatherPresentation()
        }
    }
}