package com.example.rainydays.data.dto.current

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("county")
    val country: String,
    @SerializedName("lat")
    val latitude: Double,
    @SerializedName("localtime")
    val localTime: String,
    @SerializedName("lon")
    val longitude: Double,
    @SerializedName("name")
    val city: String,
)