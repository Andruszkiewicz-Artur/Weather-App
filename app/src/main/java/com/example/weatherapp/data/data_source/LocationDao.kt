package com.example.weatherapp.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.weatherapp.domain.model.local.location.Location
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {

    @Insert
    suspend fun insertLocation(location: Location)

    @Delete
    suspend fun removeLocation(location: Location)

    @Query("SELECT * FROM Location ORDER BY id ASC")
    fun getLocationsById(): Flow<List<Location>>

}