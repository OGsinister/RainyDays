package com.example.rainydays.feature_favorite.use_cases

import com.example.core_data.mappers.LocationDataToLocationDb
import com.example.core_data.model.Location
import com.example.core_data.repository.WeatherRepositoryImpl
import javax.inject.Inject

class DeleteFavoriteCityUseCase @Inject constructor(
    private val repository: WeatherRepositoryImpl
) {
    suspend fun execute(location: Location){
        return repository.deleteLocation(locationDb = LocationDataToLocationDb().mapFrom(location))
    }
}