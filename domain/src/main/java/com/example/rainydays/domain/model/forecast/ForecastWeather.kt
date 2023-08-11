package com.example.rainydays.domain.model.forecast

data class ForecastWeather(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)