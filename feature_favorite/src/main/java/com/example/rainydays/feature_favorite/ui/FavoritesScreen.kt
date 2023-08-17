package com.example.rainydays.feature_favorite.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rainydays.feature_favorite.FavoriteCitiesViewModel
import com.example.rainydays.feature_favorite.FavoriteEvents
import com.example.rainydays.feature_weather.WeatherViewModel
import com.example.rainydays.feature_weather.utils.WeatherEvents

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun FavoritesScreen(
    viewModel: FavoriteCitiesViewModel,
    weatherViewModel: WeatherViewModel
) {
    val searchText by viewModel.searchText.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    weatherViewModel.onEvent(WeatherEvents.AddBaseCityToDb)
    viewModel.onEvent(FavoriteEvents.GetAllCities)

    val cityList = viewModel.cityList

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp)
                .weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            FavoriteTextField(
                modifier = Modifier,
                viewModel = viewModel,
                searchText = searchText,
                isSearching = isSearching
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
        ){
            LazyColumn{
                items(cityList){ city ->
                    CityListItem(city = city)
                }
            }
        }
    }
}