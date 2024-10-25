package com.example.gymforce.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymforce.R
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

//@Composable
//fun OnboardingPagerScreen(onComplete: () -> Unit) {
//    val pagerState = rememberPagerState()
//    val coroutineScope = rememberCoroutineScope()
//
////    // Onboarding pages data
////    val onboardingPages = listOf(
////        OnboardingPage(
////            title = "Welcome to GymForce",
////            description = "Track your workouts and progress.",
////            imageRes = R.drawable.image_one
////        ),
////        OnboardingPage(
////            title = "Track Your Workouts",
////            description = "Keep a detailed record of your workout routines.",
////            imageRes = R.drawable.image_two
////        ),
////        OnboardingPage(
////            title = "Achieve Your Goals",
////            description = "Set goals and achieve them with personalized plans.",
////            imageRes = R.drawable.image_tree
////        )
////    )
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        HorizontalPager(
//            count = onboardingPages.size,
//            state = pagerState,
//            modifier = Modifier.weight(1f)
//        ) { page ->
//            OnboardingPageContent(page = onboardingPages[page])
//        }
//
//        // Optional: Dots indicator for pager
//        HorizontalPagerIndicator(
//            pagerState = pagerState,
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .padding(16.dp)
//        )
//
//        // Button to finish the onboarding flow
//        Button(
//            onClick = {
//                coroutineScope.launch {
//                    if (pagerState.currentPage == onboardingPages.size - 1) {
//                        onComplete() // End the onboarding
//                    } else {
//                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
//                    }
//                }
//            },
//            modifier = Modifier.padding(16.dp)
//        ) {
//            Text(text = if (pagerState.currentPage == onboardingPages.size - 1) "Finish" else "Next")
//        }
//    }
//}

@Composable
fun OnboardingPageContent(page: OnboardingPage) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = page.imageRes),
            contentDescription = "Onboarding Image",
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = page.title,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = page.description,
            fontSize = 16.sp
        )
    }
}