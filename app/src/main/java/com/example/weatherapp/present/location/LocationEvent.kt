package com.example.weatherapp.present.location

import com.example.weatherapp.domain.model.local.location.Location

sealed interface LocationEvent {
    data class search(val value: String): LocationEvent
    data class addLocation(val location: Location): LocationEvent
    data class removeLocation(val location: Location): LocationEvent
}