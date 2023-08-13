package com.example.core_data.repository

import com.example.core_data.mappers.ApiLocationToLocationData
import com.example.core_data.mappers.ListLocationDbToLocationData
import com.example.core_data.mappers.LocationDataToLocationDb
import com.example.core_data.mappers.LocationDbToLocationData
import com.example.core_data.model.Location
import com.example.core_db.dao.LocationDao
import com.example.core_db.models.LocationDb
import com.example.core_network.WeatherApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val dao: LocationDao,
): WeatherRepository{
    override suspend fun getCurrentWeatherByLocation(city: String): Location {
        val location = weatherApi.getCurrentWeatherByLocation(city)
        return ApiLocationToLocationData().mapFrom(location)
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