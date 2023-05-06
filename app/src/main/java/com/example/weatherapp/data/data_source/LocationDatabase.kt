package com.example.weatherapp.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherapp.domain.model.local.location.Location

@Database(
    entities = [Location::class],
    version = 1
)
abstract class LocationDatabase: RoomDatabase() {

    abstract val dao: LocationDao

    companion object {
        const val DATABASE_NAME = "location_db"
    }

}