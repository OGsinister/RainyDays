package com.example.rainydays.data.dto.forecast

data class ForecastWeather(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)