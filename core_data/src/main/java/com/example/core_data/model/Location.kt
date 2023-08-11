package com.example.core_data.model

data class Location(
    val cityName: String,
    val icon: String,
    val conditionText: String,
    val feelsLikeTemp: Double,
    val temperature: Double,
    val wind: Double,
    val humidity: Int,
    val cloud: Int,
)
