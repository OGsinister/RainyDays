package com.example.core_network.model.forecast

data class ForecastWeather(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)