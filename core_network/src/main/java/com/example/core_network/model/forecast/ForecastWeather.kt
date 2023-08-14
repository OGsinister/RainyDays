package com.example.core_network.model.forecast

import com.example.core_network.model.current.Current

data class ForecastWeather(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)