package com.example.rainydays.feature_forecast.utils

sealed class ForecastEvents{
    object GetForecastFromApi: ForecastEvents()
}
