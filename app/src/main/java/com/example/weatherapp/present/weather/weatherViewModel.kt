package com.example.weatherapp.present.weather

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.data_source.LocationDatabase
import com.example.weatherapp.domain.location.LocationTracker
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker,
    private val dao: LocationDatabase
):  ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    private val _eventFlow = MutableSharedFlow<WeatherUiEvent>()

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
                        state = state.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            weatherInfo = null,
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

    fun onEvent(event: WeatherEvent) {
        when (event) {
            is WeatherEvent.removeLocation -> {
                viewModelScope.launch {
                    dao.dao.removeLocation(event.location)
                    _eventFlow.emit(WeatherUiEvent.removeLocation)
                }
            }
        }
    }
}