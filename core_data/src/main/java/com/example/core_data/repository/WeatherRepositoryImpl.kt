package com.example.core_data.repository

import com.example.core_data.mappers.toLocation
import com.example.core_data.model.Location
import com.example.core_db.AppDatabase
import com.example.core_db.models.dao.LocationDao
import com.example.core_db.models.entities.LocationDb
import com.example.core_network.WeatherApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val dao: LocationDao,
): WeatherRepository{
    override suspend fun getCurrentWeatherByLocation(city: String): Location {
        val locations = weatherApi.getCurrentWeatherByLocation(city)
        return locations.toLocation()
    }

    override suspend fun getAllLocation(): List<Location> =
        dao.getAllLocations().map{ it.toLocation() }
}