package com.example.rainydays.utils

import com.example.rainydays.R

fun BackgroundImageManager(conditionText: String): Int{
    when(conditionText) {
        "Солнечно" -> return R.drawable.ic_sunny_weather_background
        "Дождь" -> return R.drawable.ic_rain_weather_background
        "Снег" -> return R.drawable.ic_snow_weather_background
        else -> {}
    }
    return R.drawable.ic_rain_weather_background
}