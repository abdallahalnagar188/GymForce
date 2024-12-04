package com.example.gymforce.ui.screens.healthyForm
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.gymforce.R
import com.example.gymforce.ui.commonUi.AppTextField
import com.example.gymforce.ui.commonUi.CustomAppBar
import com.example.gymforce.ui.navigation.Screen
import com.example.gymforce.ui.screens.profile.ProfileViewModel

@Composable
fun TrainerHealthFormContent(
    navHostController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var specialization by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var idNumber by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<String?>(null) }
    val genders = listOf("Male", "Female")
    var selectedGender by remember { mutableStateOf("") }
    var isSubmitting by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    // Image picker launcher
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        imageUri = uri?.toString()
    }

    Scaffold(
        containerColor = Color.Transparent,
        contentColor = Color.White,
        topBar = {
            CustomAppBar(
                navHostController = navHostController,
                title = stringResource(R.string.TrainerHealthForm)
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Image Picker Section
                    Box(
                        modifier = Modifier
                            .size(100.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = if (imageUri != null) {
                                rememberAsyncImagePainter(imageUri)
                            } else {
                                painterResource(R.drawable.adults) // Replace with your placeholder image resource
                            },
                            contentDescription = stringResource(R.string.image_selected),
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable { imagePickerLauncher.launch("image/*") }
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Form Fields
                    AppTextField(
                        value = name,
                        label = stringResource(R.string.name),
                        onValueChange = { name = it }
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    AppTextField(
                        value = phoneNumber,
                        label = stringResource(R.string.phone_number),
                        onValueChange = { phoneNumber = it }
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    AppTextField(
                        value = specialization,
                        label = stringResource(R.string.specialization),
                        onValueChange = { specialization = it }
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = stringResource(R.string.gender),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        genders.forEach { gender ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(vertical = 4.dp)
                            ) {
                                RadioButton(
                                    selected = (selectedGender == gender),
                                    onClick = { selectedGender = gender },
                                    colors = RadioButtonDefaults.colors(selectedColor = Color.Green)
                                )
                                Text(
                                    text = gender,
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    AppTextField(
                        value = idNumber,
                        label = stringResource(R.string.id_number),
                        onValueChange = { idNumber = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Submit Button
                    Button(
                        onClick = {
                            isSubmitting = true
                            navHostController.navigate("Trainers/$selectedGender")
                            isSubmitting = false
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.green),
                            contentColor = Color.Black
                        )
                    ) {
                        Text(
                            text = if (isSubmitting) "Submitting..." else "Submit Form",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }
        }
    )
}
