package com.example.rainydays.feature_favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_data.domain.model.Location
import com.example.core_data.domain.model.SearchLocation
import com.example.rainydays.feature_favorite.use_cases.GetFavoritesCitiesUseCase
import com.example.rainydays.feature_favorite.use_cases.SearchCityUseCase
import com.example.rainydays.feature_search_city.use_cases.AddCityToFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteCitiesViewModel @Inject constructor(
    private val addCityToFavoriteUseCase: AddCityToFavoriteUseCase,
    private val getFavoritesCitiesUseCase: GetFavoritesCitiesUseCase,
    private val searchCityUseCase: SearchCityUseCase
): ViewModel() {

    private val _searchText = MutableStateFlow("")
    var searchText = _searchText.asStateFlow()

    var isSearching = MutableStateFlow(false)

    // Database
    var favoritesCities: List<Location> = emptyList()

    // server
    private val _foundedCities = MutableStateFlow(listOf(SearchLocation()))
    var foundedCities = _foundedCities

    fun onSearchTextChange(query: String){
        _searchText.value = query
        viewModelScope.launch {
            if(query.isBlank() || query.isEmpty()) {
                Log.d("Error","blankedEmptyRequest")
            }else{
                _foundedCities.value = searchCityUseCase.execute(query)
            }
        }
    }
    fun onEvent(event: FavoriteEvents){
        when(event){
            is FavoriteEvents.AddCity -> {

            }
            is FavoriteEvents.DeleteCity -> {

            }
            is FavoriteEvents.GetAllCities -> {
                viewModelScope.launch {
                    favoritesCities = getFavoritesCitiesUseCase.execute()
                }
            }

            is FavoriteEvents.SearchingCity -> {
                viewModelScope.launch {
                    //
                }
            }
        }
    }
}