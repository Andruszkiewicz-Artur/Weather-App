package com.example.weatherapp.present

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.location.LocationTracker
import com.example.weatherapp.domain.model.remote.weather.WeatherData
import com.example.weatherapp.domain.model.remote.weather.WeatherInfo
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
):  ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    init {
        loadWeatherInfo()
    }

    fun loadWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let { location ->
                when(val result = repository.getWeatherData(location.latitude, location.longitude)) {
                    is Resource.Success -> {
                        val todayHourlyInfo: List<WeatherData> = emptyList()



                        state = state.copy(
                            weatherInfo = result.data,
                            todayHourlyInfo = take24HWeather(result.data),
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            weatherInfo = null,
                            todayHourlyInfo = emptyList(),
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Make sure to grant permission"
                )
            }
        }
    }

    private fun take24HWeather(weather: WeatherInfo?): List<WeatherData> {
        val currentWeather = mutableListOf<WeatherData>()
        val currentHour = LocalDateTime.now().hour + 1

        weather?.weatherDataPerDay?.forEach {
            if (it.key == 0) {
                for (i in currentHour..23) {
                    currentWeather.add(it.value[i])
                }
            } else if (it.key == 1) {
                for (i in 0..23 - (23 - currentHour)) {
                    currentWeather.add(it.value[i])
                }
            }
        }

        return currentWeather
    }
}