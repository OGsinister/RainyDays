package com.example.rainydays.di

import android.app.Application
import com.example.core_data.utils.DefaultLocationTracker
import com.example.core_data.utils.LocationTracker
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ClientModule {
    @Provides
    @Singleton
    fun provideLocationClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }

    @Provides
    @Singleton
    fun provideLocationTracker(
        defaultLocationTracker: DefaultLocationTracker
    ): LocationTracker {
        return defaultLocationTracker
    }
}