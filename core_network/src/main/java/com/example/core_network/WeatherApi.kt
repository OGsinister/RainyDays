package com.example.core_network

import com.example.core_network.model.current.CurrentWeather
import com.example.core_network.model.forecast.ForecastWeather
import com.example.core_network.utils.ApiEndPoints
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(ApiEndPoints.CURRENT + ApiEndPoints.API_KEY + ApiEndPoints.AQI)
    suspend fun getCurrentWeatherByLocation(
        @Query("q") q: String,
        @Query("lang") lang: String
    ): CurrentWeather

    @GET(ApiEndPoints.FORECAST + ApiEndPoints.API_KEY + ApiEndPoints.DAYS + ApiEndPoints.AQI + ApiEndPoints.ALERTS)
    suspend fun getForecastWeatherByLocation(
        @Query("q") q: String,
        @Query("lang") lang: String
    ): ForecastWeather
}