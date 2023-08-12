package com.example.core_db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Favorite",
    indices = [Index("id_fav")]
)
data class FavoriteLocationDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id_fav")
    val idFav: Int,
    val cityName: String,
    val temperature: Double,
    val icon: String,
    val isFavorite: Boolean,
    val isCurrentLocation: Boolean,
)
