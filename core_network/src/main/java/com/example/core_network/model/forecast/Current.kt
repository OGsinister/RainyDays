package com.example.core_network.model.forecast

data class Current(
    val cloud: Int,
    val condition: Condition,
    val feelslike_c: Double,
    val humidity: Int,
    val temp_c: Double,
    val wind_kph: Double,
)