package com.example.rainydays.feature_favorite.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.core_ui.WeatherTypography
import com.example.rainydays.feature_favorite.FavoriteCitiesViewModel
import com.example.rainydays.ui.bottomTextColor

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun FavoriteTextField(
    viewModel: FavoriteCitiesViewModel,
    searchText: String,
    navController: NavController
) {
    val foundedCities = viewModel.foundedCities.collectAsState()

    TextField(
        value = searchText,
        onValueChange = viewModel::onSearchTextChange,
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
        placeholder = {
            Text(
                text = "Введите город...",
                style = WeatherTypography.titleMedium,
                color = Color.White.copy(alpha = 0.5f)
            )
        },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                tint = bottomTextColor
            )
        },

        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedContainerColor = Color.Transparent.copy(alpha = 0.7f),
            unfocusedContainerColor = Color.Transparent.copy(alpha = 0.7f)
        ),




        shape = RoundedCornerShape(30.dp)
    )
    if(searchText.isNotBlank()){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ){
            items(foundedCities.value){
                SearchCityListItem(
                    searchLocation = it,
                    viewModel = viewModel,
                    navController = navController
                )
            }
        }
    }

}