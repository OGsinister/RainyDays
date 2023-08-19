package com.example.core_data.utils

sealed class WeatherEvents{
    object GetWeatherFromApi: WeatherEvents()
    object AddBaseCityToDb: WeatherEvents()
}