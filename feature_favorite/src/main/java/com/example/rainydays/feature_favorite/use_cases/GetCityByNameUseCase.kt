package com.example.rainydays.feature_favorite.use_cases

import com.example.core_data.domain.model.Location
import com.example.core_data.domain.repository.WeatherRepositoryImpl
import javax.inject.Inject

class GetCityByNameUseCase @Inject constructor(
    private val repository: WeatherRepositoryImpl
) {
    suspend fun execute(name: String): Location?{
        return repository.getLocationByName(name)
    }
}