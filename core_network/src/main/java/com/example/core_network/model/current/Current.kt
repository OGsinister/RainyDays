package com.example.core_network.model.current

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("cloud")
    val cloud: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("wind_kph")
    val wind: Double,
    @SerializedName("feelslike_c")
    val feelsLikeTemp: Double,
    @SerializedName("temp_c")
    val temperature: Double,
    @SerializedName("condition")
    val condition: Condition,
)