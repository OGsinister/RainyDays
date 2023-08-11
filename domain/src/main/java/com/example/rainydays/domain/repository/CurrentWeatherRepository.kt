package com.example.rainydays.domain.repository

import com.example.rainydays.domain.model.current.CurrentWeather

interface CurrentWeatherRepository {
    suspend fun getCurrentWeather(city: String): Result<CurrentWeather>
}