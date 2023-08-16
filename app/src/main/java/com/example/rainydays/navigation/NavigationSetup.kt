package com.example.rainydays.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rainydays.feature_favorite.ui.FavoritesScreen
import com.example.rainydays.feature_forecast.ForecastViewModel
import com.example.rainydays.ui.forecast.ForecastScreen
import com.example.rainydays.feature_search_city.ui.SearchingScreen
import com.example.rainydays.feature_weather.WeatherViewModel
import com.example.rainydays.ui.home.HomeScreen

@Composable
fun NavigationSetup(
    navController: NavHostController,
    weatherViewModel: WeatherViewModel,
    forecastViewModel: ForecastViewModel
){
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route,
    ){
        composable(route = Screens.HomeScreen.route){
            HomeScreen(weatherViewModel.location, navController)
        }
        composable(route = Screens.FavoritesScreen.route){
            FavoritesScreen()
        }
        composable(route = Screens.SearchScreen.route){
            SearchingScreen(navController)
        }
        composable(route = Screens.ForecastScreen.route){
            ForecastScreen(
                forecast = forecastViewModel.forecastLocation
            )
        }
    }
}