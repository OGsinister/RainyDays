package com.example.core_data.repository

import com.example.core_network.WeatherApi
import com.example.core_network.model.current.CurrentWeather
import com.example.core_network.model.forecast.ForecastWeather
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
): WeatherApi{
    override suspend fun getCurrentWeatherByLocation(city: String): CurrentWeather {
        return weatherApi.getCurrentWeatherByLocation(city)
    }

    override suspend fun getForecastWeatherByLocation(city: String): ForecastWeather {
        TODO("Not yet implemented")
    }

}