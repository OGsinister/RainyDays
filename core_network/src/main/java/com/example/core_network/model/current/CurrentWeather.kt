package com.example.core_network.model.current

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName("custom_id")
    val id: Int,
    val current: Current,
    val location: Location
)