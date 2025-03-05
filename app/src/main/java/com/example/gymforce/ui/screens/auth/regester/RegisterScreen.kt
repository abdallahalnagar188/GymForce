package com.example.gymforce.ui.screens.auth.regester

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gymforce.R
import com.example.gymforce.common.UiState
import com.example.gymforce.common.fontBold
import com.example.gymforce.ui.commonUi.AppTextField
import com.example.gymforce.ui.commonUi.CircularProgressAnimated
import com.example.gymforce.ui.commonUi.GenderSelector
import com.example.gymforce.ui.commonUi.PassWordAppTextField
import com.example.gymforce.ui.commonUi.ShowToast
import com.example.gymforce.ui.commonUi.UserTypeSelector
import com.example.gymforce.ui.navigation.Screen

@Composable
fun RegisterScreen(
    navController: NavHostController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var age by remember { mutableIntStateOf(0) }
    var userType by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()
    val authState by viewModel.authState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Bold app name text
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 24.sp,
            fontFamily = fontBold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp),
            )

        AppTextField(
            value = name,
            label = stringResource(R.string.name),
            onValueChange = { name = it })
        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = email,
            label = stringResource(R.string.email),
            onValueChange = { email = it })
        Spacer(modifier = Modifier.height(16.dp))

        PassWordAppTextField(
            value = password,
            label = stringResource(R.string.password),
            onValueChange = { password = it })

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = age.toString(),
            label = stringResource(R.string.ageLable),
            onValueChange = { value -> age = value.toIntOrNull() ?: 0 }
        )
        Spacer(modifier = Modifier.height(16.dp))


        GenderSelector(
            selectedGender = gender,
            onGenderSelected = { gender = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        UserTypeSelector(
            selectedType = userType,
            onTypeSelected = { userType = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.register(
                    name = name,
                    email = email,
                    password = password,
                    gender = gender,
                    age = age,
                    userType = userType,)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.green),
                contentColor = Color.Black
            ),
            enabled = name.isNotEmpty() &&
                    email.isNotEmpty() &&
                    password.isNotEmpty() &&
                    gender.isNotEmpty() &&
                    age > 0 &&
                    userType.isNotEmpty() &&
                    authState !is UiState.Loading
        ) {
            if (authState is UiState.Loading) {
                CircularProgressAnimated(Modifier.size(24.dp))
            } else {
                Text("Register", fontFamily = fontBold, color = Color.Black, fontSize = 14.sp)
            }
        }
    }

    if (authState is UiState.Success) {
        ShowToast(message = "Registration successful")
        LaunchedEffect(Unit) {
            Log.e("RegisterScreen", "Registration successful")
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Register.route) { inclusive = true }
            }
        }
    }
}

