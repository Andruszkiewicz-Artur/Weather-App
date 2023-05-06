package com.example.weatherapp.domain.model.local.location

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Location(
    @PrimaryKey
    val id: Int = 0,
    val city: String,
    val latitude: Double,
    val longitude: Double
)
