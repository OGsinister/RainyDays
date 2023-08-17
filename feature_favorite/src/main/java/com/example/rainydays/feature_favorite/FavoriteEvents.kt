package com.example.rainydays.feature_favorite

sealed class FavoriteEvents{
    object AddCity: FavoriteEvents()
    object DeleteCity: FavoriteEvents()
    object GetAllCities: FavoriteEvents()
}
