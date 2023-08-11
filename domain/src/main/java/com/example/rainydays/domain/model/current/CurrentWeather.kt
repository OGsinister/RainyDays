package com.example.rainydays.domain.model.current

data class CurrentWeather(
    val city: String,
    val icon: String,
    val conditionText: String,
    val feelsLike: String,
    val temperature: String,
    val wind: String,
    val humidity: String,
    val cloud: Int
)
