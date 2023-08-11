package com.example.rainydays.di

import com.example.core_network.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi =
        NetworkModule.provideRetrofit().create(WeatherApi::class.java)
}