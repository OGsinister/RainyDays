package com.example.rainydays.feature_weather.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.core_data.domain.model.Location
import com.example.core_ui.TranslateCity
import com.example.core_ui.screens.Screens
import com.example.rainydays.ui.bottomTextColor
import com.example.rainydays.ui.mainColor

@Composable
fun HomeScreen(
    location: Location,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 40.dp, end = 40.dp)
    ){
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 70.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End
        ) {
            Column(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(70.dp)
                    .background(Color.White.copy(alpha = 0.15f))
                    .clickable {
                        navController.navigate(Screens.SearchScreen.route)
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ){
            CitySection(location)
            TemperatureSection(location)
            MoreInfoSection(location)
        }
    }
}

@Composable
fun CitySection(location: Location) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Text(
            text = TranslateCity(location.cityName),
            color = mainColor,
            style = if(location.cityName.length < 8)
                         com.example.core_ui.WeatherTypography.titleLarge
                    else com.example.core_ui.WeatherTypography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Icon(
            painter = painterResource(
                id = com.example.core_ui.findIcon(location.code)
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
            text = "${location.conditionText},",
            color = mainColor,
            style = com.example.core_ui.WeatherTypography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Ощущается как ${location.feelsLikeTemp.toInt()} ${com.example.core_ui.Symbols.celsius}",
            color = mainColor,
            style = com.example.core_ui.WeatherTypography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
@Composable
fun TemperatureSection(location: Location){
    Row{
        Text(
            text = "${location.temperature.toInt()}",
            color = mainColor,
            style = com.example.core_ui.WeatherTypography.headlineLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = com.example.core_ui.Symbols.celsius,
            style = com.example.core_ui.WeatherTypography.headlineLarge,
            color = mainColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun MoreInfoSection(location: Location){
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
                style = com.example.core_ui.WeatherTypography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${location.wind.toInt()} м/с",
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
                style = com.example.core_ui.WeatherTypography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${location.humidity} ${com.example.core_ui.Symbols.percent}",
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
                style = com.example.core_ui.WeatherTypography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${location.cloud} ${com.example.core_ui.Symbols.percent}",
                color = mainColor
            )
        }
    }
}
