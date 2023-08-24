package com.example.core_data.domain.repository

import com.example.core_data.domain.model.Forecast
import com.example.core_data.domain.model.Location
import com.example.core_data.domain.model.SearchLocation
import com.example.core_db.models.FavoriteLocationDb

interface WeatherRepository {
    suspend fun getCurrentWeatherByLocation(q: String, lang: String): Location

    suspend fun getForecastWeatherByLocation(q: String, lang: String): Forecast

    suspend fun getWeatherBySearch(q: String): List<SearchLocation>

    suspend fun getAllFavorites(): List<Location>

    suspend fun getLocationByName(name: String): Location?

    suspend fun addToFavorite(favoritesDb: Location)

    suspend fun deleteLocation(locationDb: FavoriteLocationDb)
}