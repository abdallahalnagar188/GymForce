package com.example.gymforce.ui.screens.auth.regester

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.gymforce.R
import com.example.gymforce.common.UiState
import com.example.gymforce.common.fontBold
import com.example.gymforce.ui.commonUi.AppTextField
import com.example.gymforce.ui.commonUi.CircularProgressAnimated
import com.example.gymforce.ui.commonUi.PassWordAppTextField
import com.example.gymforce.ui.commonUi.ShowToast
import com.example.gymforce.ui.navigation.Screen


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
    var imageUri by remember { mutableStateOf<Uri?>(null) } // To hold image URI

    // Image picker launcher
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri -> imageUri = uri }
    )

    val scrollState = rememberScrollState()
    val authState by viewModel.authState.collectAsState() // Improved state collection

    Column(
        modifier = Modifier
            .fillMaxSize()
            .displayCutoutPadding()
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image picker composable
        ImagePicker(
            imageUri = imageUri,
            onClick = { imagePickerLauncher.launch("image/*") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Input fields
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

        // Register button
        Button(
            onClick = {
                val parsedWeight = weight.toDoubleOrNull()
                val parsedHeight = height.toDoubleOrNull()

                if (parsedWeight != null && parsedHeight != null) {
                    viewModel.register(
                        name = name,
                        email = email,
                        password = password,
                        weight = parsedWeight,
                        height = parsedHeight,
                        imageUri = imageUri // Pass image URI to register function
                    )
                } else {
                    Log.e("RegisterScreen", "Invalid weight or height")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.green),
                contentColor = Color.Black
            ),
            enabled = name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() &&
                    weight.isNotEmpty() && height.isNotEmpty() &&
                    weight.toDoubleOrNull() != null && height.toDoubleOrNull() != null &&
                    authState !is UiState.Loading,
        ) {
            if (authState is UiState.Loading) {
                CircularProgressAnimated(Modifier.size(24.dp))
            } else {
                Text("Register", fontFamily = fontBold, color = Color.Black, fontSize = 14.sp)
            }
        }
    }

    // Handle successful registration
    if (authState is UiState.Success) {
        ShowToast(message = "Registration successful")
        LaunchedEffect(Unit) {
            Log.e("RegisterScreen", "Registration successful")
            // Clear fields after success
            name = ""
            email = ""
            password = ""
            weight = ""
            height = ""
            imageUri = null

            // Navigate to login screen
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Register.route) { inclusive = true }
            }
        }
    }
}

@Composable
fun ImagePicker(imageUri: Uri?, onClick: () -> Unit) {
    imageUri?.let {
        Image(
            painter = rememberImagePainter(it),
            contentDescription = "Selected Image",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
                .clickable(onClick = onClick)
        )
    } ?: run {
        Box(
            modifier = Modifier
                .size(100.dp)
                .border(2.dp, Color.Gray, CircleShape)
                .clickable(onClick = onClick)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Select Photo")
        }
    }
}



