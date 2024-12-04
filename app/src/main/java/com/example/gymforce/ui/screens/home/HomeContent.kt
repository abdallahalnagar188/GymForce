package com.example.gymforce.ui.screens.home

import androidx.benchmark.Profiler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gymforce.R
import com.example.gymforce.common.fontBold
import com.example.gymforce.ui.screens.profile.ProfileViewModel

@Composable
fun HomeContent(
    navHostController: NavHostController,
    profilerViewModel: ProfileViewModel = hiltViewModel()
) {
    val userType by profilerViewModel.userType.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top app bar
        HomeAppBar(
            navHostController = navHostController,
            ivProfileId = R.drawable.ic_proflle
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Categories header
        Text(
            text = stringResource(R.string.Categories),
            fontSize = 20.sp,
            fontFamily = fontBold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // LazyColumn content
        if (userType == "Trainer") {
            HomeLazyColumnForTrainers(navHostController)
        } else{
            HomeLazyColumn(navHostController)
        }
    }
}


