package com.example.core_data.mappers

import com.example.core_data.model.Location
import com.example.core_network.model.current.CurrentWeather
import javax.inject.Inject

class ApiLocationToLocationData @Inject constructor(): Mapper<CurrentWeather, Location>(){
    override fun mapFrom(from: CurrentWeather): Location {
        return Location(
            id = from.id,
            cityName = from.location.city,
            cloud = from.current.cloud,
            conditionText = from.current.condition.text,
            feelsLikeTemp = from.current.feelsLikeTemp,
            humidity = from.current.humidity,
            icon = from.current.condition.icon,
            temperature = from.current.temperature,
            wind = from.current.wind
        )
    }
}