package com.example.core_db.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Favorite",
    indices = [Index("cityName", unique = true)]
)
data class FavoriteLocationDb(
    @PrimaryKey
    val cityName: String,
    val temperature: Double,
    val code: Int,
    val isCurrentLocation: Boolean,
)
