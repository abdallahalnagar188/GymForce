package com.example.gymforce.ui.navigation

import com.example.gymforce.R

sealed class BottomNavItem(var title: String, var icon: Int, var screenRoute: String) {
    data object Home : BottomNavItem("home", R.drawable.ic_home, "home")
    data object Setting : BottomNavItem("Setting", R.drawable.settings, "setting")
    data object Tools : BottomNavItem("Tools", R.drawable.ic_tools, "tools")
    data object Profile : BottomNavItem("Profile", R.drawable.ic_proflle, "profile")
}


