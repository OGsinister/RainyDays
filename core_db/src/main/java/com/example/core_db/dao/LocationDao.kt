package com.example.core_db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_db.models.LocationDb

@Dao
interface LocationDao {
    @Query("SELECT * FROM Location")
    suspend fun getAllLocations(): List<LocationDb>

    @Query("SELECT * FROM Location WHERE id = :id")
    suspend fun getLocationById(id: Int): LocationDb?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLocation(locationDb: LocationDb)

    @Delete
    suspend fun deleteLocation(locationDb: LocationDb)
}