package com.example.gymforce.navigation

import com.example.gymforce.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String) {

    object Setting : BottomNavItem("Setting", R.drawable.setting, "setting")
    object Exercises : BottomNavItem("Exercises", R.drawable.img_2, "exercises")
    object Tools : BottomNavItem("Tools", R.drawable.img_1, "tools")
}