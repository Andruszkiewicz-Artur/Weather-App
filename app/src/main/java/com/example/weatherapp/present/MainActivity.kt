package com.example.weatherapp.present

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.present.weather.WeatherViewModel
import com.example.weatherapp.present.weather.compose.DailyWeather
import com.example.weatherapp.present.weather.compose.WeatherCard
import com.example.weatherapp.present.weather.compose.WeatherForecast
import com.example.weatherapp.present.weather.compose.WeatherPresentation
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.unit.navigation.BottomNavGraph
import com.example.weatherapp.unit.view.BottomBarPresentation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            viewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ))

        setContent {
            WeatherAppTheme {
                val navController = rememberNavController()

                installSplashScreen()

                Scaffold(
                    bottomBar = {
                        BottomBarPresentation(navController = navController)
                    }
                ) {
                    BottomNavGraph(navController = navController)
                }
            }
        }
    }

}