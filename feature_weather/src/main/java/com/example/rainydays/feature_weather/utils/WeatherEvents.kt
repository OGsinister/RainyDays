package com.example.rainydays.feature_weather.utils

sealed class WeatherEvents{
    object GetWeather: WeatherEvents()
}