package com.example.gymforce.ui.screens.healthyForm

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gymforce.R
import com.example.gymforce.ui.commonUi.AppTextField
import com.example.gymforce.ui.commonUi.CustomAppBar
import com.example.gymforce.ui.commonUi.GenderSelector
import com.example.gymforce.ui.navigation.Screen
import com.example.gymforce.ui.screens.profile.ProfileViewModel

@Composable
fun HealthFormContent(
    navHostController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val user = viewModel.getCurrentUser()
    val userName by viewModel.userName.collectAsState()
    val email by viewModel.userEmail.collectAsState()

    var name by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var age by remember { mutableIntStateOf(0) }
    var healthyProblem by remember { mutableStateOf("") }
    var selectedProblem by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }
    val problems = listOf("Thin", "Fat")
    val genders = listOf("Male", "Female")
    var isSubmitting by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = Color.Transparent,
        contentColor = Color.White,
        topBar = {
            CustomAppBar(
                navHostController = navHostController,
                title = stringResource(R.string.HealthForm)
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
                    // Name Text Field
                    AppTextField(
                        value = name,
                        label = stringResource(R.string.name),
                        onValueChange = { name = it },
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
                    // Gender Selector using Radio Buttons

                    Spacer(modifier = Modifier.height(6.dp))

                    // Age Text Field
                    AppTextField(
                        value = age.toString(),
                        label = stringResource(R.string.age),
                        onValueChange = { value -> age = value.toIntOrNull() ?: 0 },
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    // Healthy Problem Text Field
                    AppTextField(
                        value = healthyProblem,
                        label = stringResource(R.string.healthProblem),
                        onValueChange = { healthyProblem = it },
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    // Problem Selector using Radio Buttons
                    Text(
                        text = stringResource(R.string.select_problem_to_solve),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        problems.forEach { problem ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(vertical = 4.dp)
                            ) {
                                RadioButton(
                                    selected = (selectedProblem == problem),
                                    onClick = { selectedProblem = problem },
                                    colors = RadioButtonDefaults.colors(selectedColor = Color.Green)
                                )
                                Text(
                                    text = problem,
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                        }
                    }

                    // Submit Button
                    Button(
                        onClick = {
                            isSubmitting = true
                            // Simulate submission process
                            navHostController.navigate(Screen.Trainers.route)
                            isSubmitting = false
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.green),
                            contentColor = Color.Black
                        ),
                        enabled = true // Always enabled as inputs are optional
                    ) {
                        Text(
                            text = if (isSubmitting) "Submitting..." else "Search for Trainer",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }

                }
            }
        }
    )
}



