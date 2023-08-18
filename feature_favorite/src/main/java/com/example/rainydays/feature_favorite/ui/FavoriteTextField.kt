package com.example.rainydays.feature_favorite.ui

import android.annotation.SuppressLint
import android.util.Log
import android.view.SearchEvent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.core_data.domain.model.SearchLocation
import com.example.rainydays.feature_favorite.FavoriteCitiesViewModel
import com.example.rainydays.feature_favorite.FavoriteEvents
import com.example.rainydays.feature_weather.ui.bottomTextColor

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun FavoriteTextField(
    modifier: Modifier,
    viewModel: FavoriteCitiesViewModel,
    searchText: String
) {
    val foundedCities = viewModel.foundedCities.collectAsState()
    //val isSearching by viewModel.isSearching.collectAsState()
    val isSearching = viewModel.isSearching.collectAsState()

    TextField(
        value = searchText,
        onValueChange = viewModel::onSearchTextChange,
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .padding(10.dp)
            .fillMaxWidth(),
        placeholder = {
            Text(text = "Введите город...")
        },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                tint = bottomTextColor
            )
        }
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ){
        items(foundedCities.value){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ){
                Text(
                    text = it.location.toString()
                )
                Text(text = it.region.toString())
                Text(text = it.country.toString())
            }
            Log.d("checkCities",it.location.toString())
            Log.d("checkCities",it.region.toString())
            Log.d("checkCities",it.country.toString())
        }
    }

    if(isSearching.value){
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }else{
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(foundedCities.value) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    Text(
                        text = it.location.toString()
                    )
                    Text(text = it.region.toString())
                    Text(text = it.country.toString())
                }
                Log.d("checkCities", it.location.toString())
                Log.d("checkCities", it.region.toString())
                Log.d("checkCities", it.country.toString())
            }
        }
    }
}