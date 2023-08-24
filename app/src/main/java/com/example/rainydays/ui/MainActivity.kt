package com.example.rainydays.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.rememberNavController
import com.example.rainydays.feature_favorite.FavoriteCitiesViewModel
import com.example.rainydays.feature_forecast.ForecastViewModel
import com.example.rainydays.feature_forecast.utils.ForecastEvents
import com.example.rainydays.feature_weather.WeatherViewModel
import com.example.core_data.utils.WeatherEvents
import com.example.rainydays.navigation.BottomNavBar
import com.example.rainydays.navigation.BottomNavItem
import com.example.rainydays.navigation.NavigationSetup
import com.example.rainydays.toasts.showToast
import com.example.rainydays.ui.theme.RainyDaysTheme
import com.example.rainydays.utils.BackgroundImageManager
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    private val weatherViewModel: WeatherViewModel by viewModels()
    private val forecastViewModel: ForecastViewModel by viewModels()
    private val favoriteCitiesViewModel: FavoriteCitiesViewModel by viewModels()
    private var systemUiController: SystemUiController? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){
            weatherViewModel.viewModelScope.launch(Dispatchers.IO) {
                weatherViewModel.onEvent(WeatherEvents.GetWeatherFromApi)
                weatherViewModel.onEvent(WeatherEvents.AddBaseCityToDb)
                forecastViewModel.onEvent(ForecastEvents.GetForecastFromApi)
            }
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
                Scaffold(
                    bottomBar = {
                        BottomNavBar(
                            items = listOf(
                                BottomNavItem(
                                    route = "HomeScreen",
                                    icon = Icons.Default.Circle
                                ),
                                BottomNavItem(
                                    route = "FavoriteScreen",
                                    icon = Icons.Default.Circle
                                ),
                                BottomNavItem(
                                    route = "ForecastScreen",
                                    icon = Icons.Default.Circle
                                )
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    },
                    content = {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .systemBarsPadding()
                                .paint(
                                    painterResource(
                                        BackgroundImageManager(
                                            weatherViewModel.location.conditionText
                                        )
                                    ),
                                    contentScale = ContentScale.FillHeight
                                )
                        ){
                            weatherViewModel.location.errorMessage?.let { error ->
                                showToast(context, error)
                            }
                            NavigationSetup(
                                navController = navController,
                                weatherViewModel = weatherViewModel,
                                forecastViewModel = forecastViewModel,
                                favoriteCitiesViewModel = favoriteCitiesViewModel
                            )
                        }
                    }
                )
            }
        }
    }
    override fun onResume() {
        super.onResume()
        systemUiController?.isSystemBarsVisible = false
    }
}