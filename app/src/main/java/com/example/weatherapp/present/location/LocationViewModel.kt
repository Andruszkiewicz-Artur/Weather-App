package com.example.weatherapp.present.location

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.data_source.LocationDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val dao: LocationDatabase
): ViewModel() {

    private val _state = mutableStateOf(LocationState())
    val state: State<LocationState> = _state
    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            _state.value = state.value.copy(
                locations = dao.dao.getLocationsById()
            )
        }
    }

    fun onEvent(event: LocationEvent) {
        when (event) {
            is LocationEvent.addLocation -> {
                viewModelScope.launch {
                    dao.dao.insertLocation(event.location)
                }
            }
            is LocationEvent.search -> {
                _state.value = state.value.copy(
                    searchValue = event.value
                )
            }
            is LocationEvent.removeLocation -> {
                viewModelScope.launch {
                    dao.dao.removeLocation(event.location)
                }
            }
        }
    }
}