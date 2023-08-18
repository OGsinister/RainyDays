package com.example.core_data.domain.repository

import android.util.Log
import com.example.core_data.domain.mappers.CurrentWeatherToLocationData
import com.example.core_data.domain.mappers.ForecastWeatherToLocationData
import com.example.core_data.domain.mappers.SearchWeatherToSearchLocation
import com.example.core_data.domain.mappers.toFavoriteLocationDb
import com.example.core_data.domain.mappers.toLocationData
import com.example.core_data.domain.model.Forecast
import com.example.core_data.domain.model.Location
import com.example.core_data.domain.model.SearchLocation
import com.example.core_db.dao.LocationDao
import com.example.core_db.models.FavoriteLocationDb
import com.example.core_network.WeatherApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val dao: LocationDao,
): WeatherRepository {
    override suspend fun getCurrentWeatherByLocation(q: String,lang: String): Location {
        val currentWeather = weatherApi.getCurrentWeatherByLocation(q,lang)
        return CurrentWeatherToLocationData().mapFrom(currentWeather)
    }

    override suspend fun getForecastWeatherByLocation(q: String, lang: String): Forecast {
        val currentWeather = weatherApi.getForecastWeatherByLocation(q, lang)
        return ForecastWeatherToLocationData().mapFrom(currentWeather)
    }

    override suspend fun getWeatherBySearch(q: String): List<SearchLocation>{
        val searchWeather = weatherApi.getLocationBySearch(q)
        return SearchWeatherToSearchLocation().mapFrom(searchWeather)
    }

    override suspend fun getAllFavorites(): List<Location> {
        return dao.getAllFavorites().map{
            it.toLocationData()
        }
    }

    override suspend fun getLocationById(id: Int): Location? {
        val locationDb = dao.getFavoriteLocationById(id)
        return locationDb?.toLocationData()
    }

    override suspend fun addToFavorite(favoritesDb: Location) {
        return dao.addToFavorite(favoritesDb.toFavoriteLocationDb())
    }


    override suspend fun deleteLocation(locationDb: FavoriteLocationDb) {
        return dao.deleteLocation(locationDb)
    }
}