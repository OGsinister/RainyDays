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
import androidx.navigation.NavHostController
import com.example.rainydays.feature_favorite.FavoriteCitiesViewModel
import com.example.rainydays.feature_favorite.FavoriteEvents

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun FavoritesScreen(
    viewModel: FavoriteCitiesViewModel,
    navController: NavHostController
) {
    val searchText by viewModel.searchText.collectAsState()

    viewModel.onEvent(FavoriteEvents.GetAllCities)

    val cityList = viewModel.favoritesCities.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp)
                .weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            FavoriteTextField(
                viewModel = viewModel,
                searchText = searchText,
                navController = navController
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
        ){
            LazyColumn{
                items(cityList.value){ city ->
                    CityListItem(city = city)
                }
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
        ) {

        }
    }
}