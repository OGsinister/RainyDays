package com.example.rainydays.feature_weather.ui

import androidx.compose.foundation.background
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.core_data.model.Location
import com.example.rainydays.feature_weather.utils.Symbols

@Composable
fun MainScreen(location: Location) {
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
                    .background(Color.White.copy(alpha = 0.15f)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ){
            Column(
                modifier = Modifier.fillMaxWidth()
            ){
                CitySection(location)
            }
            Column(
                modifier = Modifier.fillMaxWidth()
            ){
                TemperatureSection(location)
            }
            Column(
                modifier = Modifier.fillMaxWidth()
            ){
                MoreInfoSection(location)
            }
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
            text = location.cityName,
            color = mainColor,
            style = WeatherTypography.titleLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
            //fontSize = 50.sp,
        )
        /* Icon(
             painter = painterResource(id = location.icon.toInt()),
             contentDescription = null
         )*/
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
            //fontSize = 15.sp,
        )
        Text(
            text = "Ощущается как ${location.feelsLikeTemp.toInt()}",
            color = mainColor,
            style = WeatherTypography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
            //fontSize = 15.sp,
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
            //fontSize = 120.sp,
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
                //fontSize = 15.sp
            )
            Text(
                text = "${location.wind} м/с",
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
                text = "Осадки",
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
