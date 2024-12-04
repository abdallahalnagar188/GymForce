package com.example.gymforce.ui.screens.home.categorys

import com.example.gymforce.R

data class Category(
    val apiID:String,
    val drawableResId:Int,
    val titleResId:Int,
    val backGroundColor:Int,
)
val categories = listOf(
    Category(
        "children", R.drawable.children, R.string.children, R.color.red
    ),Category(
        "teenagers", R.drawable.teenagers, R.string.teenagers, R.color.blue
    ),Category(
        "adults", R.drawable.adults, R.string.adults, R.color.light_blue
    ),Category(
        "old", R.drawable.old, R.string.old, R.color.bony
    )
)

val categoriesForTrainers = listOf(
    Category(
        "men", R.drawable.adults, R.string.adults, R.color.red
    ),Category(
        "women", R.drawable.woman, R.string.women, R.color.blue
    )
)