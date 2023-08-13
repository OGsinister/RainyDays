package com.example.rainydays.feature_weather.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                /*.clip(RoundedCornerShape(20.dp))
                .fillMaxSize()
                .blur(5.dp)
                .padding(top = 20.dp),*/,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            /*Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(450.dp),
                onDraw = {
                    drawCircle(brush)
                }
            )*/
        }
    }
}