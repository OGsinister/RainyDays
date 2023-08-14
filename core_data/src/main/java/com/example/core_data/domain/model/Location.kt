package com.example.core_data.domain.model

import com.example.core_network.Constants

data class Location(
    val id: Int? = null,
    val cityName: String = "",
    val icon: String = "",
    val conditionText: String = "",
    val feelsLikeTemp: Double = 0.0,
    val temperature: Double = 0.0,
    val wind: Double = 0.0,
    val humidity: Int = 1,
    val cloud: Int = 1,
)
