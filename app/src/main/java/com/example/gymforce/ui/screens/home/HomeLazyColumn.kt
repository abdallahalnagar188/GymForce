package com.example.gymforce.ui.screens.home

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.gymforce.ui.screens.home.categorys.CategoryCard
import com.example.gymforce.ui.screens.home.categorys.categories
import com.example.gymforce.ui.screens.home.categorys.categoriesForTrainers

@Composable
fun HomeLazyColumn(navHostController: NavHostController) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(4) {
            val item = categories[it]
            CategoryCard(item = item, position = it, navHostController)
        }
    }
}
@Composable
fun HomeLazyColumnForTrainers(navHostController: NavHostController) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(2) {
            val item = categoriesForTrainers[it]
            CategoryCard(item = item, position = it, navHostController)
        }
    }
}