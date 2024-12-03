package com.example.gymforce.ui.commonUi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymforce.R

@Composable
fun GenderSelector(selectedGender: String, onGenderSelected: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = stringResource(R.string.gender),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.width(22.dp))

        Row(
            modifier = Modifier.fillMaxWidth(), // Ensures the row spans the full width
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f) // Equal weight for "Male" section
            ) {
                RadioButton(
                    selected = selectedGender == "Male",
                    onClick = { onGenderSelected("Male") },
                    colors = RadioButtonDefaults.colors(selectedColor = Color.Green)
                )
                Text("Male", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f) // Equal weight for "Female" section
            ) {
                RadioButton(
                    selected = selectedGender == "Female",
                    onClick = { onGenderSelected("Female") },
                    colors = RadioButtonDefaults.colors(selectedColor = Color.Green)
                )
                Text("Female", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}

