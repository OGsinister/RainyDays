package com.example.rainydays.feature_favorite.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.core_data.domain.model.Location
import com.example.core_ui.Symbols
import com.example.core_ui.WeatherTypography
import com.example.core_ui.findIcon

@Composable
fun CityListItem(city: Location) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent.copy(alpha = 0.2f),
                        Color.Transparent.copy(alpha = 0.1f),
                        Color.Transparent.copy(alpha = 0.008f),
                        Color.Transparent.copy(alpha = 0.0f)
                    )
                )
            )
            .clickable {
                /// ((((
            }
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Column(
                    modifier = Modifier
                        .weight(2f)
                ){
                    Text(
                        text = city.cityName,
                        style = WeatherTypography.bodyMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Icon(
                    painter = painterResource(id = findIcon(code = city.code)),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "${city.temperature.toInt()}${Symbols.celsius}",
                    style = WeatherTypography.titleLarge
                )
                if(city.isCurrentLocation){
                    Text(
                        text = "Текущее\nместоположение",
                        style = WeatherTypography.titleMedium
                    )
                }
            }
        }
    }
}