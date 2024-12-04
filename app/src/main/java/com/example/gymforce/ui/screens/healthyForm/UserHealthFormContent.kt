package com.example.gymforce.ui.screens.healthyForm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavHostController
import com.example.gymforce.R
import com.example.gymforce.common.fontMedium
import com.example.gymforce.ui.commonUi.AppTextField
import com.example.gymforce.ui.commonUi.CustomAppBar

@Composable
fun UserHealthFormContent(
    navHostController: NavHostController,
) {
    var name by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var age by remember { mutableIntStateOf(0) }
    var healthyProblem by remember { mutableStateOf("") }
    var selectedProblem by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("Male") }
    val problems = listOf("Thin", "Fat")
    val genders = listOf("Male", "Female")
    var isSubmitting by remember { mutableStateOf(false) }
    var isDialogOpen by remember { mutableStateOf(false) }
    val allHealthProblems = listOf(
        "Diabetes", "Hypertension", "Obesity", "Asthma", "Heart Disease",
        "Back Pain", "Arthritis", "Migraine", "Depression", "Anxiety",
        "Cholesterol", "Thyroid Issues", "Chronic Pain", "Cancer Recovery",
        "Lung Issues", "Allergies", "Digestive Problems", "Fatigue",
        "Sleep Disorders", "Skin Conditions"
    )

    val selectedHealthProblems = remember { mutableStateOf(setOf<String>()) }

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

                    // Gender Selector using Radio Buttons
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
                        onValueChange = {
                            healthyProblem = it
                        },
                        readOnly = false,
                        onClick = { isDialogOpen = true }
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
                            text = if (isSubmitting) "Submitting..." else "Search for Trainer",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }

            if (isDialogOpen) {
                AlertDialog(modifier = Modifier.background(colorResource(R.color.baby_blue)),
                    onDismissRequest = { isDialogOpen = false },
                    title = {
                        Text(text = stringResource(R.string.select_health_problem))
                    },
                    text = {
                        LazyColumn(
                            modifier = Modifier.fillMaxHeight(0.6f) // Adjust height if needed
                        ) {
                            items(allHealthProblems) { problem ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                ) {
                                    Checkbox(
                                        checked = selectedHealthProblems.value.contains(problem),
                                        onCheckedChange = { isChecked ->
                                            selectedHealthProblems.value = if (isChecked) {
                                                selectedHealthProblems.value + problem
                                            } else {
                                                selectedHealthProblems.value - problem
                                            }
                                        }
                                    )
                                    Text(text = problem, modifier = Modifier.padding(start = 8.dp))
                                }
                            }
                        }
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                healthyProblem = selectedHealthProblems.value.joinToString(", ")
                                isDialogOpen = false
                            }, shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.green),
                                contentColor = colorResource(R.color.white)
                            )
                        ) {
                            Text(
                                stringResource(R.string.submit),
                                fontSize = 14.sp,
                                color = colorResource(R.color.baby_blue),
                                fontFamily = fontMedium
                            )
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = { isDialogOpen = false }, shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.green),
                                contentColor = colorResource(R.color.white)
                            )
                        ) {
                            Text(
                                stringResource(R.string.cancel),
                                fontSize = 14.sp,
                                color = colorResource(R.color.baby_blue),
                                fontFamily = fontMedium
                            )
                        }
                    }
                )
            }

        }
    )
}




