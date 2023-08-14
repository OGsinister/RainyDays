package com.example.rainydays.di

import com.example.core_data.domain.repository.WeatherRepository
import com.example.core_network.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideWeatherRepository(): WeatherRepository =
        NetworkModule.provideRetrofit().create(WeatherRepository::class.java)
}