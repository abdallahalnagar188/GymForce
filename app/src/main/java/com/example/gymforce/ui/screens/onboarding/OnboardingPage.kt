package com.example.gymforce.ui.screens.onboarding

import com.example.gymforce.R

data class OnboardingPage(val title: String, val description: String, val image: Int)

val onboardingPages = listOf(
    OnboardingPage("Welcome", "This is the first page description", R.drawable.gym),
    OnboardingPage("Discover", "This is the second page description", R.drawable.ic_gym),
    OnboardingPage("Get Started", "This is the third page description", R.drawable.icon_app)
)
