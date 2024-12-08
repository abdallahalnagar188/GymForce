package com.example.gymforce.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gymforce.R

@Composable
fun MyBottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Setting,
        BottomNavItem.BrainGym,
        BottomNavItem.Home,
        BottomNavItem.Meals,
        BottomNavItem.Profile
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.black_low),
        contentColor = Color.Black,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    if (currentRoute == item.screenRoute) {
                        // Selected icon with text beside it
                        Row(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(20.dp))
                                .background(colorResource(R.color.green)) // Background for selected item
                                .padding(
                                    horizontal = 10.dp,
                                    vertical = 5.dp
                                ) // Adjust padding as needed
                        ) {
                            Icon(
                                painterResource(id = item.icon),
                                contentDescription = stringResource(item.titleRes) ,
                                modifier = Modifier.size(25.dp), // Icon size
                                tint = colorResource(R.color.black_low)
                            )
//                            Text(
//                                text = stringResource(item.titleRes),
//                                fontSize = 12.sp, // Font size
//                                color = colorResource(R.color.black_low),
//                                modifier = Modifier.padding(start = 8.dp) // Space between icon and text
//                            )
                        }
                    } else {
                        // Unselected icon (without label)
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = stringResource(item.titleRes),
                            modifier = Modifier
                                .padding(top = 6.dp)
                                .size(25.dp)
                        )
                    }
                },
                //   label = { /* Hide label for unselected items */ },
                selectedContentColor = colorResource(R.color.green),
                unselectedContentColor = Color.Gray,
                alwaysShowLabel = false, // Hide labels for unselected items
                selected = currentRoute == item.screenRoute,
                onClick = {
                    if (currentRoute != item.screenRoute) {
                        navController.navigate(item.screenRoute) {
                            popUpTo(navController.graph.startDestinationRoute ?: "home") {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}



