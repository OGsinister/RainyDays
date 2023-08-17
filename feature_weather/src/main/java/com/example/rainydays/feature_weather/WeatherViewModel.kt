package com.example.rainydays.feature_weather


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_data.utils.LocationTracker
import com.example.core_data.domain.model.Location
import com.example.core_network.utils.LangSwitcher
import com.example.rainydays.feature_search_city.use_cases.AddCityToFavoriteUseCase
import com.example.rainydays.feature_weather.use_cases.ShowCurrentWeatherUseCase
import com.example.rainydays.feature_weather.utils.WeatherEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val showCurrentWeatherUseCase: ShowCurrentWeatherUseCase,
    private val addCityToFavoriteUseCase: AddCityToFavoriteUseCase,
    private val locationTracker: LocationTracker
): ViewModel(){

    //var location by mutableStateOf(Location())
    var location by mutableStateOf(Location())

    fun onEvent(event: WeatherEvents) {
        when(event){
            is WeatherEvents.GetWeatherFromApi -> {
                viewModelScope.launch {
                    locationTracker.getCurrentLocation()?.let{

                        location = location.copy(
                            errorMessage = null
                        )
                        val result = showCurrentWeatherUseCase
                            .execute(
                                q = "${it.latitude} ${it.longitude}",
                                lang = LangSwitcher(Locale.getDefault())
                            )
                        Log.d("crash((","${result.wind} ${result.cityName}")
                        location = location.copy(
                            cityName = result.cityName,
                            code = result.code,
                            conditionText = result.conditionText,
                            feelsLikeTemp = result.feelsLikeTemp,
                            temperature = result.temperature,
                            wind = result.wind,
                            humidity = result.humidity,
                            cloud = result.cloud
                        )
                    } ?: kotlin.run{
                        location = location.copy(
                            errorMessage = "Включите и разрешите использовать GPS"
                        )
                    }
                }
            }

            WeatherEvents.AddBaseCityToDb -> {
                viewModelScope.launch {
                    addCityToFavoriteUseCase.execute(location)
                }
            }
        }
    }
}
