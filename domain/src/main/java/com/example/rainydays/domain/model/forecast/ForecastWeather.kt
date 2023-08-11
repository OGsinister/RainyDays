package com.example.rainydays.domain.model.forecast

data class ForecastWeather(
    val city: String,
    val hour: List<Hour>
)