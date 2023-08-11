package com.example.core_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core_db.models.dao.LocationDao
import com.example.core_db.models.entities.LocationDb

@Database(
    entities = [LocationDb::class],
    version = 1
)
abstract class AppDatabase(): RoomDatabase() {
    abstract val locationDao: LocationDao
}