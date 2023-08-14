package com.example.core_data.domain.repository

import com.example.core_data.domain.mappers.ApiLocationToLocationData
import com.example.core_data.domain.mappers.ListLocationDbToLocationData
import com.example.core_data.domain.mappers.LocationDbToLocationData
import com.example.core_data.domain.model.Location
import com.example.core_db.dao.LocationDao
import com.example.core_db.models.LocationDb
import com.example.core_network.WeatherApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val dao: LocationDao,
): WeatherRepository {
    override suspend fun getCurrentWeatherByLocation(city: String): Location {
        val currentWeather = weatherApi.getCurrentWeatherByLocation(city)
        return ApiLocationToLocationData().mapFrom(currentWeather)
    }

    override suspend fun getAllLocation(): List<Location> {
        val locationData = dao.getAllLocations()
        return ListLocationDbToLocationData().mapFrom(locationData)
    }

    override suspend fun getLocationById(id: Int): Location? {
        val locationData = dao.getLocationById(id)
        return locationData?.let { LocationDbToLocationData().mapFrom(it) }
    }

    override suspend fun addLocation(locationDb: LocationDb) {
        return dao.addLocation(locationDb)
    }

    override suspend fun deleteLocation(locationDb: LocationDb) {
        return dao.deleteLocation(locationDb)
    }
}