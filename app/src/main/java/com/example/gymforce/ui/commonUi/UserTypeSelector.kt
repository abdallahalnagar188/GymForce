package com.example.gymforce.ui.commonUi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymforce.R

@Composable
fun UserTypeSelector(selectedType: String, onTypeSelected: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = stringResource(R.string.user_type),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.width(22.dp))

        Row(
            modifier = Modifier.fillMaxWidth(), // Fill available width
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f) // Equal weight for "User" section
            ) {
                RadioButton(
                    selected = selectedType == "User",
                    onClick = { onTypeSelected("User") },
                    colors = RadioButtonDefaults.colors(selectedColor = Color.Green)
                )
                Text("User", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f) // Equal weight for "Trainer" section
            ) {
                RadioButton(
                    selected = selectedType == "Trainer",
                    onClick = { onTypeSelected("Trainer") },
                    colors = RadioButtonDefaults.colors(selectedColor = Color.Green)
                )
                Text("Trainer", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}

