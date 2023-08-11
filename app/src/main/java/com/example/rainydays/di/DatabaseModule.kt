package com.example.rainydays.di

import android.app.Application
import androidx.room.Room
import com.example.core_db.AppDatabase
import com.example.core_db.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase{
        return Room.databaseBuilder(
            context = app,
            klass = AppDatabase::class.java,
            name = Constants.DATABASE_NAME
        ).build()
    }
}