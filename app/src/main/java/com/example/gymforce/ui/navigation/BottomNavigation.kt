package com.example.gymforce.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
        modifier = Modifier.height(55.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    if (currentRoute == item.screen_route) {
                        // Selected icon with circular background
                        Box(
                            modifier = Modifier
                                .size(40.dp) // Adjust size as needed
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(colorResource(R.color.green)) // Circular background
                        ) {
                            Icon(
                                painterResource(id = item.icon),
                                contentDescription = item.title,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .size(25.dp), // Adjust size as needed
                                tint = Color.White
                            )
                        }
                    } else {
                        // Unselected icon (default)
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title,
                            modifier = Modifier
                                .padding(top = 6.dp)
                                .size(25.dp)
                        )
                    }
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 11.sp
                    )
                },
                selectedContentColor = colorResource(R.color.green),
                unselectedContentColor = Color.Gray,
                alwaysShowLabel = true,
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

