package com.example.core_data.domain.repository

import com.example.core_data.domain.model.Location
import com.example.core_db.models.LocationDb

interface WeatherRepository {
    suspend fun getCurrentWeatherByLocation(city: String): Location

    suspend fun getAllLocation(): List<Location>

    suspend fun getLocationById(id: Int): Location?

    suspend fun addLocation(locationDb: LocationDb)

    suspend fun deleteLocation(locationDb: LocationDb)

    // getForecast()
    // searchCity()
}