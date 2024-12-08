package com.example.gymforce.ui.screens.meals.foodList

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gymforce.ui.screens.meals.MealsViewModel

@Composable
fun FoodByCategoryScreen(navController: NavHostController, category: String) {
    FoodByCategoryContent(category, navController)
}