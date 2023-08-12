package com.example.core_data.repository

import com.example.core_data.model.Location
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getCurrentWeatherByLocation(city: String): Location

    suspend fun getAllLocation(): List<Location>

    suspend fun getLocationById(id: Int): Location?

    // getForecast()
    // searchCity()
    // CRUD
}