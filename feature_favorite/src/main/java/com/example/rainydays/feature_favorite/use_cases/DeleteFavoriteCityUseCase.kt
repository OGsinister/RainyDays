package com.example.rainydays.feature_favorite.use_cases

import com.example.core_data.domain.mappers.LocationDataToFavoritesDb
import com.example.core_data.domain.model.Location
import com.example.core_data.domain.repository.WeatherRepositoryImpl
import javax.inject.Inject

class DeleteFavoriteCityUseCase @Inject constructor(
    private val repository: WeatherRepositoryImpl
) {
    suspend fun execute(location: Location){
        return repository.deleteLocation(locationDb = LocationDataToFavoritesDb().mapFrom(location))
    }
}