package com.example.core_db.models.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Location",
    indices = [Index("id")]
)
data class Location(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val cityName: String,
    val temperature: Double,
    val icon: String
)
