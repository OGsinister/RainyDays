package com.example.core_network.model.current

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name")
    val city: String,
)