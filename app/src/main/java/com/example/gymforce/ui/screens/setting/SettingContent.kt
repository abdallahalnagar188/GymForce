package com.example.gymforce.ui.screens.setting

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymforce.R
import com.example.gymforce.common.LocalUtil
import com.example.gymforce.common.fontMedium

@Composable
fun SettingContent() {
    val activity = LocalContext.current as Activity
    LocalUtil.init(activity) // Ensure this is initialized early.

    // Default to the current language
    var selectedLanguage by remember {
        mutableStateOf(
            when (LocalUtil.getLang()) {
                "ar" -> "Arabic"
                else -> "English"
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        LanguageDropdown(
            selectedLanguage = selectedLanguage,
            onLanguageSelected = { language ->
                selectedLanguage = language
                val languageCode = if (language == "English") "en" else "ar"
                LocalUtil.setLocal(activity, languageCode)
            }
        )
    }
}

@Composable
fun LanguageDropdown(
    selectedLanguage: String,
    onLanguageSelected: (String) -> Unit
) {
    val languages = listOf("English", "Arabic")
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = selectedLanguage,
            onValueChange = {},
            label = {
                Text(
                    text = stringResource(R.string.select_language),
                    style = TextStyle(
                        fontFamily = fontMedium,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                )
            },
            readOnly = true,
            modifier = Modifier.fillMaxWidth(0.8f),
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(id = R.color.green),
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            languages.forEach { language ->
                DropdownMenuItem(
                    onClick = {
                        onLanguageSelected(language)
                        expanded = false
                    },
                    text = { Text(text = language) }
                )
            }
        }
    }
}
