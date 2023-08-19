package com.example.rainydays.feature_forecast.ui

import ForecastTypography
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_network.model.forecast.Hour
import com.example.rainydays.ui.bottomTextColor

@Composable
fun ForecastItem(hour: Hour){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(
                text = hour.time.substringAfter(" "),
                color = bottomTextColor,
                style = ForecastTypography.bodySmall
            )
        }
        Spacer(modifier = Modifier.padding(2.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "${hour.temp_c.toInt()}${com.example.core_ui.Symbols.celsius}",
                color = com.example.rainydays.ui.mainColor,
                style = ForecastTypography.bodyLarge
            )
        }
    }
}