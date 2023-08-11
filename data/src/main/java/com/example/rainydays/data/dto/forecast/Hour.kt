package com.example.rainydays.data.dto.forecast

import com.google.gson.annotations.SerializedName

data class Hour(
    @SerializedName("temp_c")
    val tempCelsius: String,
    @SerializedName("time")
    val timeByHour: String,
    @SerializedName("wind_kph")
    val windKph: Double,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("cloud")
    val cloud: Int,
)