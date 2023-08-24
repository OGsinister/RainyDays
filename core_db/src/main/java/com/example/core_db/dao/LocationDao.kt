package com.example.core_db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_db.models.FavoriteLocationDb

@Dao
interface LocationDao {

    @Query("SELECT * FROM Favorite")
    suspend fun getAllFavorites(): List<FavoriteLocationDb>

    @Query("SELECT * FROM Favorite WHERE cityName = :name")
    suspend fun getFavoriteLocationByName(name: String): FavoriteLocationDb?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorite(locationDb: FavoriteLocationDb)

    @Delete
    suspend fun deleteLocation(locationDb: FavoriteLocationDb)
}