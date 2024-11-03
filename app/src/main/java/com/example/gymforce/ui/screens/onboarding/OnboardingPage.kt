package com.example.gymforce.ui.screens.onboarding

import com.example.gymforce.R

data class OnboardingPage(
    val title: String,
    val description: String,
    val animationRes: Int // Lottie animation resource ID
)

val onboardingPages = listOf(
    OnboardingPage(
        title = "Welcome",
        description = "This is the first page description",
        animationRes = R.raw.an_one // Replace with actual animation
    ),
    OnboardingPage(
        title = "Discover",
        description = "This is the second page description",
        animationRes = R.raw.an_two // Replace with actual animation
    ),
    OnboardingPage(
        title = "Get Started",
        description = "This is the third page description",
        animationRes = R.raw.an_three // Replace with actual animation
    )
)

