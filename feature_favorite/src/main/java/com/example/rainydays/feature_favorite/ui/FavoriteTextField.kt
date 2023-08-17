package com.example.rainydays.feature_favorite.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.rainydays.feature_favorite.FavoriteCitiesViewModel
import com.example.rainydays.feature_weather.ui.bottomTextColor

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun FavoriteTextField(
    modifier: Modifier,
    viewModel: FavoriteCitiesViewModel,
    searchText: String,
    isSearching: Boolean,
) {
    TextField(
        value = searchText,
        onValueChange = viewModel::onSearchTextChange,
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .padding(10.dp)
            .fillMaxWidth(),
        placeholder = {Text(text = "Введите город...")},
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                tint = bottomTextColor
            )
        }
    )
}