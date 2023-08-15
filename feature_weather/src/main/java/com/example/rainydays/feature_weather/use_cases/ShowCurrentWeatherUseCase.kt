package com.example.rainydays.feature_weather.use_cases

import com.example.core_data.domain.model.Location
import com.example.core_data.domain.repository.WeatherRepositoryImpl
import javax.inject.Inject

class ShowCurrentWeatherUseCase @Inject constructor(
    private val repository: WeatherRepositoryImpl
) {
    suspend fun execute(q: String, lang: String): Location {
        return repository.getCurrentWeatherByLocation(q,lang)
    }
}