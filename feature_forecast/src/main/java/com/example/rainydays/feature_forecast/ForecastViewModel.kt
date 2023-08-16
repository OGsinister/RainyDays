package com.example.rainydays.feature_forecast

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_data.domain.model.Forecast
import com.example.core_network.utils.LangSwitcher
import com.example.rainydays.feature_forecast.use_cases.GetForecastUseCase
import com.example.rainydays.feature_forecast.utils.ForecastEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getForecastUseCase: GetForecastUseCase
): ViewModel(){

    var forecastLocation by mutableStateOf(Forecast())
    fun onEvent(event: ForecastEvents){
        when(event){
            is ForecastEvents.GetForecastFromApi -> {
                viewModelScope.launch {
                    val result = getForecastUseCase
                        .execute(
                            q = "Moscow",
                            lang = LangSwitcher(Locale.getDefault())
                        )

                    forecastLocation = forecastLocation.copy(
                        cityName = result.cityName,
                        code = result.code,
                        conditionText = result.conditionText,
                        feelsLikeTemp = result.feelsLikeTemp,
                        wind = result.wind,
                        humidity = result.humidity,
                        cloud = result.cloud,
                        forecast = result.forecast,
                        temperature = result.temperature
                    )
                }
            }
        }
    }
}