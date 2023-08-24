package com.example.rainydays.feature_favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_data.domain.model.Location
import com.example.core_data.domain.model.SearchLocation
import com.example.rainydays.feature_favorite.use_cases.GetFavoritesCitiesUseCase
import com.example.rainydays.feature_favorite.use_cases.SearchCityUseCase
import com.example.rainydays.feature_weather.use_cases.AddCityToFavoriteUseCase
import com.example.rainydays.feature_weather.use_cases.ShowCurrentWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteCitiesViewModel @Inject constructor(
    private val getFavoritesCitiesUseCase: GetFavoritesCitiesUseCase,
    private val searchCityUseCase: SearchCityUseCase,
    private val addCityToFavoriteUseCase: AddCityToFavoriteUseCase,
    private val showCurrentWeatherUseCase: ShowCurrentWeatherUseCase
): ViewModel() {

    private val _searchText = MutableStateFlow("")
    var searchText = _searchText.asStateFlow()

    // Database
    private val _favoritesCities = MutableStateFlow(listOf(Location()))
    var favoritesCities = _favoritesCities.asStateFlow()
    //var favoritesCities = MutableStateFlow(listOf(Location()))

    // server
    private val _foundedCities = MutableStateFlow(listOf(SearchLocation()))
    var foundedCities = _foundedCities.asStateFlow()

    var location = Location()

    fun onSearchTextChange(query: String){
        _searchText.value = query
        try{
            if(query != ""){
                viewModelScope.launch {
                    _foundedCities.value = searchCityUseCase.execute(query)
                }
            }
        }catch (e: Exception){
            Log.d("[psss",e.message.toString())
        }
    }
    suspend fun getCityBySearch(query: String){
        location = showCurrentWeatherUseCase.execute(query, lang = "ru")
    }

    suspend fun addNewLocationToDb(){
        addCityToFavoriteUseCase.execute(location)
    }

    fun onEvent(event: FavoriteEvents){
        when(event){
            is FavoriteEvents.GetAllCities -> {
                viewModelScope.launch {
                    _favoritesCities.value = getFavoritesCitiesUseCase.execute()
                }
            }
        }
    }
}