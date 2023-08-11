package com.example.rainydays.ui.main_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_data.repository.WeatherRepository
import com.example.core_data.repository.WeatherRepositoryImpl
import com.example.core_network.WeatherApi
import com.example.rainydays.ui.main_screen.use_cases.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val repository: WeatherRepositoryImpl
): ViewModel() {

    fun showWeather(city: String){
        viewModelScope.launch(Dispatchers.IO) {
            getWeatherUseCase.execute(city)
        }
    }
}