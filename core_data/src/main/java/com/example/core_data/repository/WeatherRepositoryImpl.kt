package com.example.core_data.repository

import com.example.core_data.mappers.toLocation
import com.example.core_data.model.Location
import com.example.core_network.WeatherApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    // private val weatherDb...
): WeatherRepository{
    override suspend fun getCurrentWeatherByLocation(city: String): Location {
        val locations = weatherApi.getCurrentWeatherByLocation(city)
        return locations.toLocation()
    }
}