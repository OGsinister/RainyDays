package com.example.rainydays.feature_weather


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_data.domain.location.LocationTracker
import com.example.core_data.domain.model.Location
import com.example.core_network.utils.LangSwitcher
import com.example.rainydays.feature_weather.use_cases.ShowCurrentWeatherUseCase
import com.example.rainydays.feature_weather.utils.WeatherEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val showCurrentWeatherUseCase: ShowCurrentWeatherUseCase,
    private val locationTracker: LocationTracker
): ViewModel(){

    var location by mutableStateOf(Location())

    fun onEvent(event: WeatherEvents) = when(event){
        is WeatherEvents.GetWeather -> {
            viewModelScope.launch(Dispatchers.IO) {
                locationTracker.getCurrentLocation().let{
                    val result = showCurrentWeatherUseCase
                        .execute(
                                q = "${it?.latitude} ${it?.longitude}",
                                lang = LangSwitcher(Locale.getDefault())
                            )

                    viewModelScope.launch(Dispatchers.Main) {
                        location = location.copy(
                            id = result.id,
                            cityName = result.cityName,
                            code = result.code,
                            conditionText = result.conditionText,
                            feelsLikeTemp = result.feelsLikeTemp,
                            temperature = result.temperature,
                            wind = result.wind,
                            humidity = result.humidity,
                            cloud = result.cloud
                        )
                    }
                }
            }
        }
    }
}
