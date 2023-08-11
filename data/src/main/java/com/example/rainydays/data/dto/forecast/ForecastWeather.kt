package com.example.rainydays.data.dto.forecast

import com.example.rainydays.data.dto.current.Current
import com.example.rainydays.data.dto.current.Location

data class ForecastWeather(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)