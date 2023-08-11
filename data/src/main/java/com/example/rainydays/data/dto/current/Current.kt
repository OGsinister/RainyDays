package com.example.rainydays.data.dto.current

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("condition")
    val condition: Condition,
    @SerializedName("feelslike_c")
    val feelsLikeCelsius: Double,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("is_day")
    val isDay: Int,
    @SerializedName("temp_c")
    val temperature: Double,
    @SerializedName("wind_kph")
    val windKph: Double,
    @SerializedName("cloud")
    val cloud: Int,
)