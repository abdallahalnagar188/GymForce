package com.example.gymforce.ui.screens.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gymforce.R
import com.example.gymforce.common.UiState
import com.example.gymforce.common.fontBold
import com.example.gymforce.common.fontMedium
import com.example.gymforce.ui.commonUi.AppTextField
import com.example.gymforce.ui.commonUi.CircularProgressAnimated
import com.example.gymforce.ui.commonUi.PassWordAppTextField
import com.example.gymforce.ui.navigation.BottomNavItem

@Composable
fun LoginScreen(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Observing authState from ViewModel
    val authState = viewModel.authState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Email TextField
        AppTextField(
            value = email,
            label = "Email",
            onValueChange = { email = it },
            leadingIcon = R.drawable.ic_email
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password TextField
        PassWordAppTextField(
            value = password,
            label = "Password",
            onValueChange = { password = it },
            leadingIcon = R.drawable.ic_password
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Login Button
        Button(
            onClick = {
                viewModel.signIn(email, password) // Trigger login
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.green), contentColor = Color.Black
            ),
            enabled = email.isNotEmpty() && password.isNotEmpty() && authState !is UiState.Loading
        ) {
            if (authState is UiState.Loading) {
                CircularProgressAnimated(Modifier.size(24.dp))
            } else {
                Text(stringResource(R.string.login), color = Color.Black, fontFamily = fontBold)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Error Message
        if (authState is UiState.Error) {
            val errorMessage = authState.message
            Text(text = errorMessage, color = Color.Red)
        }

        // Sign-up Text with Navigation to RegisterScreen
        Text(
            text =stringResource(R.string.don_t_have_an_account),
            color = Color.White,
            modifier = Modifier.clickable {
                navController.navigate("Register")
            },
            fontFamily = fontMedium
        )

        // Navigate to Home on successful login
        if (authState is UiState.Success) {
            navController.navigate(BottomNavItem.Home.screenRoute) {
                // Clear the back stack so the user can't navigate back to the login screen
                popUpTo("Login") { inclusive = true }
            }
        }
    }
}


