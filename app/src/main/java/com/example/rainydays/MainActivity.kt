package com.example.rainydays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rainydays.navigation.Screens
import com.example.rainydays.ui.favorites_screen.FavoritesScreen
import com.example.rainydays.ui.forecast_screen.ForecastScreen
import com.example.rainydays.ui.main_screen.MainScreen
import com.example.rainydays.ui.search_city_screen.SearchingScreen
import com.example.rainydays.ui.theme.RainyDaysTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RainyDaysTheme {
                val navController = rememberNavController()
                Column(
                    modifier = Modifier.fillMaxSize()
                ){
                    NavHost(
                        navController = navController,
                        startDestination = Screens.MainScreen.route,
                    ){
                        composable(route = Screens.MainScreen.route){
                            MainScreen()
                        }
                        composable(route = Screens.FavoritesScreen.route){
                            FavoritesScreen()
                        }
                        composable(route = Screens.SearchScreen.route){
                            SearchingScreen()
                        }
                        composable(route = Screens.ForecastScreen.route){
                            ForecastScreen()
                        }
                    }
                }
            }
        }
    }
}
