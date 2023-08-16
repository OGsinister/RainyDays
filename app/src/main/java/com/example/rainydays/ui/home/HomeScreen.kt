package com.example.rainydays.ui.home

import android.util.Log
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
import com.example.core_data.utils.TranslateCity
import com.example.core_data.utils.findIcon
import com.example.rainydays.feature_weather.ui.WeatherTypography
import com.example.rainydays.feature_weather.ui.bottomTextColor
import com.example.rainydays.feature_weather.ui.mainColor
import com.example.rainydays.feature_weather.utils.Symbols
import com.example.rainydays.navigation.Screens

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
    Log.d("check Icon code",location.code.toString())
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Text(
            text = TranslateCity(location.cityName),
            color = mainColor,
            style = if(location.cityName.length < 8)
                         WeatherTypography.titleLarge
                    else WeatherTypography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Icon(
            painter = painterResource(
                id = findIcon(location.code)
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
            style = WeatherTypography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Ощущается как ${location.feelsLikeTemp.toInt()} ${Symbols.celsius}",
            color = mainColor,
            style = WeatherTypography.titleMedium,
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
            style = WeatherTypography.headlineLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = Symbols.celsius,
            style = WeatherTypography.headlineLarge,
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
                style = WeatherTypography.titleMedium,
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
                style = WeatherTypography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${location.humidity} ${Symbols.percent}",
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
                style = WeatherTypography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${location.cloud} ${Symbols.percent}",
                color = mainColor
            )
        }
    }
}
