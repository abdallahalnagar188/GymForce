package com.example.gymforce.ui.commonUi

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymforce.R
import com.example.gymforce.common.fontMedium

@Composable
fun AppTextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    leadingIcon: Int? = null // Optional leading icon
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(
                label,
                style = TextStyle(
                    color = colorResource(id = R.color.white),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        },
        leadingIcon = leadingIcon?.let {
            {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    tint = colorResource(id = R.color.white) // Change color as needed
                )
            }
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.green),
            unfocusedBorderColor = Color.Gray,
            unfocusedTextColor = Color.White,
            focusedTextColor = Color.White
        )
    )
}

@Composable
fun PassWordAppTextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    leadingIcon: Int? = null // Optional leading icon
) {
    // State to manage password visibility
    val passwordVisible = remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(
                label,
                style = TextStyle(
                    color = colorResource(id = R.color.white),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                ),
                fontFamily = fontMedium
            )
        },
        leadingIcon = leadingIcon?.let {
            {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    tint = colorResource(id = R.color.white) // Change color as needed
                )
            }
        },
        trailingIcon = {
            // Toggle icon based on password visibility state
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(
                    painter = painterResource(id = if (passwordVisible.value) R.drawable.ic_visibility else R.drawable.ic_visibility_off),
                    contentDescription = if (passwordVisible.value) "Hide password" else "Show password",
                    tint = colorResource(id = R.color.white) // Change color as needed
                )
            }
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.green),
            unfocusedBorderColor = Color.Gray,
            unfocusedTextColor = Color.White,
            focusedTextColor = Color.White
        )
    )
}

