package com.example.gymforce.ui.screens.meals.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.domain.repo.MealsDetailsRepo
import com.example.gymforce.ui.screens.meals.MealsViewModel

@Composable
fun MealsDetailsScreen(
    navController: NavController,
    viewModel: MealsViewModel = hiltViewModel(),
    mealId: String
) {
    MealsDetailsContent()
}