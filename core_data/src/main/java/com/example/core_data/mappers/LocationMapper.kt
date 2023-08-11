package com.example.core_data.mappers

import com.example.core_data.model.Location
import com.example.core_db.models.entities.LocationDb
import com.example.core_network.model.current.CurrentWeather

fun CurrentWeather.toLocation() = Location(
    cityName = location.city,
    conditionText = current.condition.text,
    feelsLikeTemp = current.feelsLikeTemp,
    temperature = current.temperature,
    wind = current.wind,
    humidity = current.humidity,
    cloud = current.cloud,
    icon = current.condition.icon,
    id = id
)

fun Location.toLocationDb() = LocationDb(
    cityName = cityName,
    icon = icon,
    conditionText = conditionText,
    feelsLikeTemp = feelsLikeTemp,
    wind = wind,
    humidity = humidity,
    cloud = cloud,
    temperature = temperature,
    id = id
)

fun LocationDb.toLocation() = Location(
    cityName = cityName,
    icon = icon,
    conditionText = conditionText,
    feelsLikeTemp = feelsLikeTemp,
    wind = wind,
    humidity = humidity,
    cloud = cloud,
    temperature = temperature,
    id = id
)