package com.example.core_data.mappers

import com.example.core_data.model.Location
import com.example.core_db.models.LocationDb
import javax.inject.Inject

class LocationDataToLocationDb @Inject constructor(): Mapper<Location,LocationDb>() {
    override fun mapFrom(from: Location): LocationDb {
        return LocationDb(
            id = from.id,
            cityName = from.cityName,
            cloud = from.cloud,
            conditionText = from.conditionText,
            feelsLikeTemp = from.feelsLikeTemp,
            humidity = from.humidity,
            icon = from.icon,
            temperature = from.temperature,
            wind = from.wind
        )
    }
}

class ListLocationDbToLocationData @Inject constructor(): Mapper<List<LocationDb>, List<Location>>(){
    /* override fun mapFrom(from: LocationDb): List<Location> {
        return listOf(
            Location(
                id = from.id,
                cityName = from.cityName,
                cloud = from.cloud,
                conditionText = from.conditionText,
                feelsLikeTemp = from.feelsLikeTemp,
                humidity = from.humidity,
                icon = from.icon,
                temperature = from.temperature,
                wind = from.wind
            )
        )
    }*/
    override fun mapFrom(from: List<LocationDb>): List<Location> {
        return from.map {
            Location(
                id = it.id,
                cityName = it.cityName,
                cloud = it.cloud,
                conditionText = it.conditionText,
                feelsLikeTemp = it.feelsLikeTemp,
                humidity = it.humidity,
                icon = it.icon,
                temperature = it.temperature,
                wind = it.wind
            )
        }
    }
}


class LocationDbToLocationData @Inject constructor(): Mapper<LocationDb, Location>(){
    override fun mapFrom(from: LocationDb): Location {
        return Location(
            id = from.id,
            cityName = from.cityName,
            cloud = from.cloud,
            conditionText = from.conditionText,
            feelsLikeTemp = from.feelsLikeTemp,
            humidity = from.humidity,
            icon = from.icon,
            temperature = from.temperature,
            wind = from.wind
        )
    }

}