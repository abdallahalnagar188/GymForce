package com.example.gymforce.ui.screens.meals.foodList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gymforce.ui.commonUi.CustomAppBar
import com.example.gymforce.ui.screens.meals.MealsViewModel

@Composable
fun FoodByCategoryContent(
    category: String,
    navController: NavHostController,
    viewModel: MealsViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.getFilterByCategory(category)
    }

    val foodByCategory = viewModel.filterByCategory.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp)
            .displayCutoutPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomAppBar(navHostController = navController, title = "Meals")
        Spacer(modifier = Modifier.height(10.dp))

        FoodLazyColumn(
            meals = foodByCategory.value?.meals ?: emptyList(),
            onClick = { meal ->
//                val foodId = meal.idMeal
//                navController.navigate("foodByCategory/${foodId}")
            }
        )

    }

}