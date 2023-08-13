package com.example.rainydays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rainydays.navigation.Screens
import com.example.rainydays.feature_favorite.ui.FavoritesScreen
import com.example.rainydays.feature_forecast.ui.ForecastScreen
import com.example.rainydays.feature_weather.ui.MainScreen
import com.example.rainydays.feature_search_city.ui.SearchingScreen
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
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                ){
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ){
                        Image(
                            painterResource(randomWeather()),
                            contentDescription = null,
                            contentScale = ContentScale.FillHeight,
                            modifier = Modifier.matchParentSize()
                        )
                    }
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

@Composable
fun randomWeather(): Int {
    return listOf(
        R.drawable.ic_snow_weather_background,
        R.drawable.ic_sunny_weather_background,
        R.drawable.ic_rain_weather_background
    ).random()
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview(){
    RainyDaysTheme {
        //MainScreen()
    }
}
