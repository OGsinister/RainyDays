package com.example.rainydays.feature_favorite.use_cases

import com.example.core_data.model.Location
import com.example.core_data.repository.WeatherRepositoryImpl
import javax.inject.Inject

class GetFavoritesCitiesUseCase @Inject constructor(
    private val repository: WeatherRepositoryImpl
){
    suspend fun execute(): List<Location>{
       return repository.getAllLocation()
    }
}