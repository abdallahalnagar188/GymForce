package com.example.gymforce.ui.navigation

import androidx.compose.ui.res.stringResource
import com.example.gymforce.R

sealed class BottomNavItem(val titleRes: Int, val icon: Int, val screenRoute: String) {
    data object Home : BottomNavItem(R.string.home, R.drawable.ic_home, "home")
    data object Setting : BottomNavItem(R.string.setting, R.drawable.settings, "setting")
    data object Meals : BottomNavItem(R.string.meals, R.drawable.meal, "meals")
    data object Profile : BottomNavItem(R.string.profile, R.drawable.ic_proflle, "profile")
    data object BrainGym : BottomNavItem(R.string.brain_gym, R.drawable.ic_brain, "brain")
}


