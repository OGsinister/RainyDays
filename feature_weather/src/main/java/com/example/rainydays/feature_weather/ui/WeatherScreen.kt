package com.example.rainydays.feature_weather.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core_data.model.Location
import com.example.rainydays.feature_weather.utils.Symbols

@Composable
fun MainScreen(location: Location) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 40.dp, end = 40.dp)
    ){
        Column(modifier = Modifier.weight(1f)) {

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
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(
                text = location.cityName,
                color = mainColor,
                style = WeatherTypography.titleLarge
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
                style = WeatherTypography.titleMedium
                //fontSize = 15.sp,
            )
            Text(
                text = "Ощущается как ${location.feelsLikeTemp.toInt()}",
                color = mainColor,
                style = WeatherTypography.titleMedium
                //fontSize = 15.sp,
            )
        }
        Spacer(modifier = Modifier.padding(20.dp))
    }
}
@Composable
fun TemperatureSection(location: Location){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Row{
            Text(
                text = "${location.temperature.toInt()}",
                color = mainColor,
                style = WeatherTypography.headlineLarge
                //fontSize = 120.sp,
            )
            Text(
                text = Symbols.celsius,
                style = WeatherTypography.headlineLarge,
                color = mainColor
            )
        }
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
                style = WeatherTypography.titleMedium
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
                style = WeatherTypography.titleMedium
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
                style = WeatherTypography.titleMedium
            )
            Text(
                text = "${location.cloud} ${Symbols.percent}",
                color = mainColor
            )
        }
    }
}
