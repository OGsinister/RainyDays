package com.example.core_data.domain.mappers

import com.example.core_data.domain.model.Location
import com.example.core_db.models.FavoriteLocationDb
import javax.inject.Inject

class LocationDataToFavoritesDb @Inject constructor(): Mapper<Location, FavoriteLocationDb>() {
    override fun mapFrom(from: Location): FavoriteLocationDb {
        return FavoriteLocationDb(
            idFav = 1,
            temperature = from.temperature,
            cityName = from.cityName,
            code = from.code,
            isCurrentLocation = from.isCurrentLocation
        )
    }
}

fun FavoriteLocationDb.toLocationData() = Location(
    cityName = cityName,
    temperature = temperature,
    code = code,
    isCurrentLocation = isCurrentLocation
)

fun Location.toFavoriteLocationDb() = FavoriteLocationDb(
    idFav = 1,
    cityName = cityName,
    temperature = temperature,
    code = code,
    isCurrentLocation = isCurrentLocation
)