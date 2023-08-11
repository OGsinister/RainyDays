package com.example.core_network.model.forecast

import com.example.core_network.model.current.Condition
import com.google.gson.annotations.SerializedName

data class Hour(
    @SerializedName("cloud")
    val cloud: Int,
    @SerializedName("condition")
    val condition: Condition,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("temp_c")
    val temperature: Double,
    @SerializedName("time")
    val time: String,
    @SerializedName("wind_kph")
    val wind: Double,
)