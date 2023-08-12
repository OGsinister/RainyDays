package com.example.core_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core_db.dao.LocationDao
import com.example.core_db.models.FavoriteLocationDb
import com.example.core_db.models.LocationDb

@Database(
    entities = [LocationDb::class,FavoriteLocationDb::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase(): RoomDatabase() {
    abstract val locationDao: LocationDao
}