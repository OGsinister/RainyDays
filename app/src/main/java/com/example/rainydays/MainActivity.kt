package com.example.rainydays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rainydays.feature_favorite.ui.FavoritesScreen
import com.example.rainydays.feature_forecast.ui.ForecastScreen
import com.example.rainydays.feature_search_city.ui.SearchingScreen
import com.example.rainydays.feature_weather.WeatherViewModel
import com.example.rainydays.feature_weather.ui.MainScreen
import com.example.rainydays.feature_weather.utils.WeatherEvents
import com.example.rainydays.feature_search_city.navigation.Screens
import com.example.rainydays.toasts.showToast
import com.example.rainydays.ui.theme.RainyDaysTheme
import com.example.rainydays.utils.BackgroundImageManager
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    private val viewModel: WeatherViewModel by viewModels()
    private var systemUiController: SystemUiController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){
            viewModel.onEvent(WeatherEvents.GetWeatherFromApi)
        }
        permissionLauncher.launch(arrayOf(
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        ))
        setContent {
            RainyDaysTheme {
                val navController = rememberNavController()
                val context = LocalContext.current
                systemUiController = rememberSystemUiController()
                systemUiController?.isSystemBarsVisible = false

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                        .paint(
                            painterResource(BackgroundImageManager(viewModel.location.conditionText)),
                            contentScale = ContentScale.FillHeight
                        )
                ){
                    viewModel.location.errorMessage?.let { error ->
                        showToast(context, error)
                    }
                    NavHost(
                        navController = navController,
                        startDestination = Screens.MainScreen.route,
                    ){
                        composable(route = Screens.MainScreen.route){
                            MainScreen(viewModel.location, navController)
                        }
                        composable(route = Screens.FavoritesScreen.route){
                            FavoritesScreen()
                        }
                        composable(route = Screens.SearchScreen.route){
                            SearchingScreen(navController)
                        }
                        composable(route = Screens.ForecastScreen.route){
                            ForecastScreen()
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        systemUiController?.isSystemBarsVisible = false
    }
}
@Composable
@Preview(showBackground = true)
fun DefaultPreview(){
    RainyDaysTheme {
        //MainScreen()
    }
}
