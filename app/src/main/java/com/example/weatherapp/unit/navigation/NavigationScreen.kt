package com.example.weatherapp.unit.navigation

sealed class NavigationScreen(
    val route: String
) {
    object Today: NavigationScreen(
        route = "today_route"
    )

    object Daily: NavigationScreen(
        route = "daily_route"
    )
}
