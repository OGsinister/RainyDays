package com.example.rainydays.data.dto.current

data class Current(
    val cloud: Int,
    val condition: Condition,
    val feelslike_c: Double,
    val gust_kph: Double,
    val humidity: Int,
    val is_day: Int,
    val temp_c: Double,
    val vis_km: Double,
    val wind_kph: Double,
)