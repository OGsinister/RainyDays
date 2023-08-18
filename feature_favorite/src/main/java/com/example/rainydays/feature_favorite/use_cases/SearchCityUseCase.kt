package com.example.rainydays.feature_favorite.use_cases

import com.example.core_data.domain.model.SearchLocation
import com.example.core_data.domain.repository.WeatherRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class SearchCityUseCase @Inject constructor(
    private val repository: WeatherRepositoryImpl
) {
    suspend fun execute(q: String): List<SearchLocation> {
        return repository.getWeatherBySearch(q)
    }
}