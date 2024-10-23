package com.example.gymforce.ui.commonUi

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymforce.R
import com.example.gymforce.common.fontMedium

@Composable
fun AppTextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
) {

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(
                label,
                style = TextStyle(
                    color = colorResource(id = R.color.white),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.green),
            unfocusedBorderColor = Color.Gray,
            unfocusedTextColor = Color.White,
            focusedTextColor = Color.White
        ),

        )
}


@Composable
fun PassWordAppTextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
) {

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(
                label,
                style = TextStyle(
                    color = colorResource(id = R.color.white),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                ), fontFamily = fontMedium
            )
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        visualTransformation = PasswordVisualTransformation(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.green),
            unfocusedBorderColor = Color.Gray,
            unfocusedTextColor = Color.White,
            focusedTextColor = Color.White
        ),

        )
}