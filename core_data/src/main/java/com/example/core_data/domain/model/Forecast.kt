package com.example.core_data.domain.model

import com.example.core_network.model.forecast.Forecastday

data class Forecast(
    val errorMessage: String? = null,
    val cityName: String = "",
    val code: Int = 374,
    val conditionText: String = "",
    val feelsLikeTemp: Double = 0.0,
    val wind: Double = 0.0,
    val humidity: Int = 1,
    val cloud: Int = 1,
    val forecast: List<Forecastday>? = null,
    val time: String? = null,
    val temp: Double? = null,
    val temperature: Double = 0.0
)