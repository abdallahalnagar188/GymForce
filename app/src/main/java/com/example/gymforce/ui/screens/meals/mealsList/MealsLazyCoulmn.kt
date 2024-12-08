package com.example.gymforce.ui.screens.meals.mealsList

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.dto.meals.Category

@Composable
fun MealsLazyColumn(meals: List<Category>, onClick: (Category) -> Unit = {}) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        val filteredMeals = meals.filterIndexed { index, _ -> index != 6 }

        items(filteredMeals.size) { index ->
            val meal = filteredMeals[index]
            MealCard(meal = meal, onClick = { onClick(meal) })
        }
    }
}
