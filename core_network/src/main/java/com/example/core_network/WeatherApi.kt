package com.example.core_network

import com.example.core_network.model.current.CurrentWeather
import com.example.core_network.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(Constants.CURRENT + Constants.API_KEY + Constants.AQI)
    suspend fun getCurrentWeatherByLocation(
        @Query("q") q: String,
        @Query("lang") lang: String
    ): CurrentWeather
}