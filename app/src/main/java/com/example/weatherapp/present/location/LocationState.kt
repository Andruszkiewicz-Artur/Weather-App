package com.example.weatherapp.present.location

import com.example.weatherapp.domain.model.local.location.Location
import kotlinx.coroutines.flow.Flow

data class LocationState(
    val locations: Flow<List<Location>>? = null,
    val searchLocations: List<Location> = emptyList(),
    val searchValue: String = ""
)
