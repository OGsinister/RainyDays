package com.example.rainydays.navigation

sealed class Screens(val route: String) {
    object MainScreen: Screens(route = "MainScreen")
    object FavoritesScreen: Screens(route = "FavoriteScreen")
    object SearchScreen: Screens(route = "SearchScreen")
    object ForecastScreen: Screens(route = "ForecastScreen")
}