package com.example.rainydays.feature_weather.utils

sealed class WeatherEvents{
    object GetWeatherFromApi: WeatherEvents()
    object AddBaseCityToDb: WeatherEvents()
}