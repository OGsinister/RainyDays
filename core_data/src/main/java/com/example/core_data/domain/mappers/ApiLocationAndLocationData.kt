package com.example.core_data.domain.mappers

import com.example.core_data.domain.model.Forecast
import com.example.core_data.domain.model.Location
import com.example.core_network.model.current.CurrentWeather
import com.example.core_network.model.forecast.ForecastWeather
import javax.inject.Inject

class CurrentWeatherToLocationData @Inject constructor(): Mapper<CurrentWeather, Location>(){
    override fun mapFrom(from: CurrentWeather): Location {
        return Location(
            id = from.id,
            cityName = from.location.name,
            cloud = from.current.cloud,
            conditionText = from.current.condition.text,
            feelsLikeTemp = from.current.feelsLikeTemp,
            humidity = from.current.humidity,
            code = from.current.condition.code,
            temperature = from.current.temperature,
            wind = from.current.wind
        )
    }
}

class ForecastWeatherToLocationData @Inject constructor(): Mapper<ForecastWeather, Forecast>(){
    override fun mapFrom(from: ForecastWeather): Forecast {
        return Forecast(
            cityName = from.location.name,
            forecast = from.forecast.forecastday,
            conditionText = from.current.condition.text,
            code = from.current.condition.code,
            cloud = from.current.cloud,
            wind = from.current.wind_kph,
            feelsLikeTemp = from.current.feelslike_c,
            temperature = from.current.temp_c,
            humidity = from.current.humidity,
        )
    }
}
