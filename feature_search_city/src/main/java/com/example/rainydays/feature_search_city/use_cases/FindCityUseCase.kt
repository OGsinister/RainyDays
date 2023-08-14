package com.example.rainydays.feature_search_city.use_cases

import com.example.core_data.domain.repository.WeatherRepositoryImpl
import javax.inject.Inject

class FindCityUseCase @Inject constructor(
    private val repository: WeatherRepositoryImpl
) {
    suspend fun execute(){
        // Пока не написал функционал в repository :(((
    }
}