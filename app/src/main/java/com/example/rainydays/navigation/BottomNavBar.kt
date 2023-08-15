package com.example.rainydays.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.rainydays.ui.theme.backgroundColorWithoutCircle
import com.example.rainydays.ui.theme.selectedBottomIconColor
import com.example.rainydays.ui.theme.unselectedBottomIconColor

@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = Modifier
            .padding(start = 150.dp, bottom = 35.dp, end = 150.dp),
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ){
        items.forEach{ item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                icon = {
                    Icon(
                        modifier = Modifier
                            .size(11.dp),
                        imageVector = item.icon,
                        contentDescription = null
                    )
                },
                selectedContentColor = selectedBottomIconColor,
                unselectedContentColor = unselectedBottomIconColor
            )
        }
    }
}