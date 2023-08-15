package com.example.rainydays.navigation

sealed class Screens(val route: String) {
    object HomeScreen: Screens(route = "HomeScreen")
    object FavoritesScreen: Screens(route = "FavoriteScreen")
    object SearchScreen: Screens(route = "SearchScreen")
    object ForecastScreen: Screens(route = "ForecastScreen")
}