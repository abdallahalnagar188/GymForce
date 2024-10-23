package com.example.gymforce.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gymforce.R

@Composable
fun MyBottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Tools,
        BottomNavItem.Setting,
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
                    if (currentRoute == item.screen_route) {
                        // Selected icon with text beside it
                        Row(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(colorResource(R.color.green)) // Background for selected item
                                .padding(horizontal = 10.dp, vertical = 5.dp) // Adjust padding as needed
                        ) {
                            Icon(
                                painterResource(id = item.icon),
                                contentDescription = item.title,
                                modifier = Modifier.size(25.dp), // Icon size
                                tint = colorResource(R.color.black_low)
                            )
                            Text(
                                text = item.title,
                                fontSize = 14.sp, // Font size
                                color = colorResource(R.color.black_low),
                                modifier = Modifier.padding(start = 8.dp) // Space between icon and text
                            )
                        }
                    } else {
                        // Unselected icon (without label)
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title,
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
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                navController.popBackStack(
                                    route = "home",
                                    inclusive = false
                                )
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}



