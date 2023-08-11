package com.example.rainydays.domain.repository

import com.example.rainydays.domain.model.forecast.ForecastWeather

interface ForecastWeatherRepository {
    suspend fun getForecastWeather(days: Int): Result<ForecastWeather>
}