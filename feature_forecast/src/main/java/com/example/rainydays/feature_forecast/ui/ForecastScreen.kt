package com.example.rainydays.feature_forecast.ui

import ForecastTypography
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.core_data.domain.model.Forecast
import com.example.core_network.model.forecast.Hour
import com.example.core_ui.TranslateCity
import com.example.core_ui.screens.Screens
import com.example.rainydays.ui.bottomTextColor
import com.example.rainydays.ui.mainColor

@Composable
fun ForecastScreen(
    forecast: Forecast,
    navController: NavController
) {
    val flattenList = forecast.forecast?.map{it.hour}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 40.dp, end = 40.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ){
            SearchSection(navController = navController)
        }
        Column(
            modifier = Modifier
                .weight(2f)
        ) {
            CurrentWeatherSection(forecast)
            ForecastSection(
                hours = flattenList!!.flatten()
            )
            MoreInfoSection(forecast)
        }
    }
}
@Composable
fun SearchSection(
    navController: NavController
){
    Column(
        modifier = Modifier
            .clip(CircleShape)
            .size(70.dp)
            .background(Color.White.copy(alpha = 0.15f))
            .clickable {
                navController.navigate(Screens.FavoritesScreen.route)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            Icons.Default.Search,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
fun CurrentWeatherSection(forecast: Forecast){
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Text(
            text = TranslateCity(forecast.cityName),
            color = mainColor,
            style = if(forecast.cityName.length < 8)
                ForecastTypography.titleLarge
            else ForecastTypography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Icon(
            painter = painterResource(
                id = com.example.core_ui.findIcon(forecast.code)
            ),
            tint = Color.White,
            contentDescription = null
        )
    }
    Spacer(modifier = Modifier.padding(10.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Text(
            text = "${forecast.conditionText},",
            color = mainColor,
            style = ForecastTypography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Ощущается как ${forecast.feelsLikeTemp.toInt()} ${com.example.core_ui.Symbols.celsius}",
            color = mainColor,
            style = ForecastTypography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }

    Row{
        Text(
            text = "${forecast.temperature.toInt()}",
            color = mainColor,
            style = ForecastTypography.headlineLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = com.example.core_ui.Symbols.celsius,
            style = ForecastTypography.headlineLarge,
            color = mainColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun ForecastSection(hours: List<Hour>){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LazyRow{
                items(hours){
                    ForecastItem(hour = it)
                }
            }
        }
    }
}

@Composable
fun MoreInfoSection(forecast: Forecast){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            modifier = Modifier
                .padding(2.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Ветер",
                color = bottomTextColor,
                style = ForecastTypography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${forecast.wind} м/с",
                color = mainColor
            )
        }
        Column(
            modifier = Modifier
                .padding(2.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Влажность",
                color = bottomTextColor,
                style = ForecastTypography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${forecast.humidity} ${com.example.core_ui.Symbols.percent}",
                color = mainColor,
            )
        }
        Column(
            modifier = Modifier
                .padding(2.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Облачность",
                color = bottomTextColor,
                style = ForecastTypography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${forecast.cloud} ${com.example.core_ui.Symbols.percent}",
                color = mainColor
            )
        }
    }
}