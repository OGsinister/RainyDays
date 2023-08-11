package com.example.core_network

import com.example.core_network.Constants
import com.example.core_network.model.current.CurrentWeather
import com.example.core_network.model.forecast.ForecastWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(Constants.BASE_URL + Constants.CURRENT +"key="+ Constants.API_KEY +"&aqi=no")
    suspend fun getCurrentWeatherByLocation(
        @Query("q") city: String
    ): CurrentWeather

    @GET(Constants.BASE_URL + Constants.FORECAST +"key="+ Constants.API_KEY +"q={city}&aqi=no&alerts=no")
    suspend fun getForecastWeatherByLocation(
        @Query("q") city: String
    ): ForecastWeather
}