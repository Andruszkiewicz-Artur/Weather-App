package com.example.weatherapp.present.weather.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp.present.weather.WeatherViewModel

@Composable
fun WeatherPresentation(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface)
        ) {
            item {
                WeatherCard(
                    state = viewModel.state,
                    backgroundColor = MaterialTheme.colors.primary
                )
                Spacer(modifier = Modifier.height(16.dp))
                WeatherForecast(state = viewModel.state)
                Spacer(modifier = Modifier.height(16.dp))
                DailyWeather(weatherInfo = viewModel.state.weatherInfo)
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        state.error?.let { error ->
            Text(
                text = error,
                color = Color.Red,
                textAlign = TextAlign.Center
            )
        }
    }
}