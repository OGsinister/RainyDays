package com.example.core_db.models.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.core_db.models.entities.LocationDb

@Dao
interface LocationDao {
    @Query("SELECT * FROM Location")
    suspend fun getAllLocations(): List<LocationDb>

    @Query("SELECT * FROM Location WHERE id = :id")
    suspend fun getLocationById(id: Int): LocationDb?

    @Insert
    suspend fun addLocation(location: LocationDb)

    @Delete
    suspend fun deleteLocation(location: LocationDb)
}