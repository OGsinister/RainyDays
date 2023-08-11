package com.example.rainydays.ui.main_screen.use_cases

import com.example.core_data.repository.WeatherRepositoryImpl
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepositoryImpl
){
    suspend fun execute(city: String){
        repository.getCurrentWeatherByLocation(city)
    }
}