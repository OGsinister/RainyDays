package com.example.core_data.repository

import com.example.core_data.model.Location

interface WeatherRepository {
    suspend fun getCurrentWeatherByLocation(city: String): Location

    suspend fun getAllLocation(): List<Location>

    // getForecast()
    // searchCity()
    // CRUD
}