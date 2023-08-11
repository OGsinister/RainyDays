package com.example.rainydays.domain.use_cases

import com.example.rainydays.domain.repository.CurrentWeatherRepository
import javax.inject.Inject

class ShowCurrentWeatherUseCase @Inject constructor(
    private val repository: CurrentWeatherRepository
) {
    suspend operator fun invoke(city: String) = repository.getCurrentWeather(city = city)
}