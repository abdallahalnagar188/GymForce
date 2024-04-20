package com.example.gymforce.navigation

import com.example.gymforce.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String) {

    data object Setting : BottomNavItem("Setting", R.drawable.setting, "setting")
    data object Exercises : BottomNavItem("Exercises", R.drawable.img_2, "exercises")
    data object Tools : BottomNavItem("Tools", R.drawable.img_1, "tools")
}