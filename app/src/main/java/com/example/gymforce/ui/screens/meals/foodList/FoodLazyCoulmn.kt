package com.example.gymforce.ui.screens.meals.foodList

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.dto.filterByCategory.Meal
import com.example.domain.dto.meals.Category
@Composable
fun FoodLazyColumn(meals: List<Meal>, onClick: (Meal) -> Unit = {}) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        items(meals.size) { index ->
            val meal = meals[index] // Get the meal at the current index
            FoodCard(meal = meal, onClick = { onClick(meal) }) // Pass the correct meal to onClick
        }
    }
}
