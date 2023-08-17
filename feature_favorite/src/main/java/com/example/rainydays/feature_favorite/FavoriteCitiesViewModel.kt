package com.example.rainydays.feature_favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_data.domain.model.Location
import com.example.rainydays.feature_favorite.use_cases.GetFavoritesCitiesUseCase
import com.example.rainydays.feature_search_city.use_cases.AddCityToFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteCitiesViewModel @Inject constructor(
    private val addCityToFavoriteUseCase: AddCityToFavoriteUseCase,
    private val getFavoritesCitiesUseCase: GetFavoritesCitiesUseCase
): ViewModel() {

    private val _searchText = MutableStateFlow("")
    var searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    var isSearching = _isSearching.asStateFlow()

    var cityList: List<Location> = emptyList()

    fun onSearchTextChange(query: String){
        _searchText.value = query
    }

    fun onEvent(event: FavoriteEvents){
        when(event){
            FavoriteEvents.AddCity -> {}
            FavoriteEvents.DeleteCity -> {}
            FavoriteEvents.GetAllCities -> {
                viewModelScope.launch {
                    cityList = getFavoritesCitiesUseCase.execute()
                }
            }
        }
    }
}