package com.example.rainydays.domain.use_cases

import com.example.rainydays.domain.repository.ForecastWeatherRepository
import javax.inject.Inject

class ShowForecastWeatherUseCase @Inject constructor(
    private val repository: ForecastWeatherRepository
) {
    suspend operator fun invoke(days: Int) = repository.getForecastWeather(days = days)
}