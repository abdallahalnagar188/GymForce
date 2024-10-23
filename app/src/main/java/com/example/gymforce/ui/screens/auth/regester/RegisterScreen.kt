package com.example.gymforce.ui.screens.auth.register

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gymforce.common.fontMedium
import com.example.gymforce.ui.commonUi.AppTextField
import com.example.gymforce.ui.commonUi.PassWordAppTextField
import com.example.gymforce.common.UiState
import com.example.gymforce.ui.navigation.BottomNavItem
import com.example.gymforce.ui.screens.auth.regester.RegisterViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun RegisterScreen(
    navController: NavHostController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }

    // Observing authState from ViewModel
    val authState = viewModel.authState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppTextField(
            value = name,
            label = "Name",
            onValueChange = { name = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = email,
            label = "Email",
            onValueChange = { email = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        PassWordAppTextField(
            value = password,
            label = "Password",
            onValueChange = { password = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Add fields for weight and height
        AppTextField(
            value = weight,
            label = "Weight (kg)",
            onValueChange = { weight = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = height,
            label = "Height (cm)",
            onValueChange = { height = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Register Button
        Button(
            onClick = {
                // Validate and convert weight and height to Double before calling register
                viewModel.register(
                    name = name,
                    email = email,
                    password = password,
                    weight = weight.toDoubleOrNull() ?: 0.0,
                    height = height.toDoubleOrNull() ?: 0.0
                )
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() &&
                    weight.isNotEmpty() && height.isNotEmpty() && authState !is UiState.Loading,
        ) {
            if (authState is UiState.Loading) {
                CircularProgressIndicator(color = Color.White)
            } else {
                Text("Register", fontFamily = fontMedium)
            }
        }

        // ... Existing error message and navigation to Login code ...
    }
}

