package com.example.core_db.models.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.core_db.models.entities.Location
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {
    @Query("SELECT * FROM Location")
    suspend fun getAllLocations(): Flow<List<Location>>

    @Query("SELECT * FROM Location WHERE id = :id")
    suspend fun getLocationById(id: Int): Location?

    @Insert
    suspend fun addLocation(location: Location)

    @Delete
    suspend fun deleteLocation(location: Location)
}