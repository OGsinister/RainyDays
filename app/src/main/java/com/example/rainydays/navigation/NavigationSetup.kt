package com.example.rainydays.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.core_ui.screens.Screens
import com.example.rainydays.feature_favorite.FavoriteCitiesViewModel
import com.example.rainydays.feature_favorite.ui.FavoritesScreen
import com.example.rainydays.feature_forecast.ForecastViewModel
import com.example.rainydays.feature_forecast.ui.ForecastScreen
import com.example.rainydays.feature_weather.WeatherViewModel
import com.example.rainydays.feature_weather.ui.HomeScreen

@SuppressLint("CommitPrefEdits")
@Composable
fun NavigationSetup(
    navController: NavHostController,
    weatherViewModel: WeatherViewModel,
    forecastViewModel: ForecastViewModel,
    favoriteCitiesViewModel: FavoriteCitiesViewModel
){
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route,
    ){
        composable(route = Screens.HomeScreen.route){
            HomeScreen(
                location = weatherViewModel.location,
                navController = navController,
                viewModel = weatherViewModel
            )
        }
        composable(route = Screens.FavoritesScreen.route){
            FavoritesScreen(
                viewModel = favoriteCitiesViewModel,
                navController = navController
            )
        }
        composable(route = Screens.ForecastScreen.route){
            ForecastScreen(
                forecast = forecastViewModel.forecastLocation,
                navController = navController
            )
        }
    }
}