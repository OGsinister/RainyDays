package com.example.core_db.models.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Location",
    indices = [Index("id")]
)
data class LocationDb(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val cityName: String,
    val icon: String,
    val conditionText: String,
    val feelsLikeTemp: Double,
    val temperature: Double,
    val wind: Double,
    val humidity: Int,
    val cloud: Int,
)
