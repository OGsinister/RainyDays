package com.example.rainydays.feature_forecast.use_cases

import com.example.core_data.domain.model.Forecast
import com.example.core_data.domain.repository.WeatherRepositoryImpl
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(
    private val repository: WeatherRepositoryImpl
){
    suspend fun execute(q: String, lang: String): Forecast{
        return repository.getForecastWeatherByLocation(q,lang)
    }
}