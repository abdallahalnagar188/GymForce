package com.example.gymforce.ui.screens.setting

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.gymforce.common.fontMedium
import com.example.gymforce.ui.commonUi.CustomDatePicker

@Composable
fun SettingContent(context: Context = LocalContext.current) {
    // Initialize preferences
    LocalUtil.initPreferences(context)

    // Load saved language or default to Arabic
    var selectedLanguage by remember { mutableStateOf(
        if (LocalUtil.loadSavedLanguage() == "en") "English" else "Arabic"
    )}

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        LanguageDropdown(
            selectedLanguage = selectedLanguage,
            onLanguageSelected = { language ->
                selectedLanguage = language
                val languageCode = if (language == "English") "en" else "ar"
                LocalUtil.setLanguage(context, languageCode)
                context.recreateActivity() // Apply changes
            }
        )
    }
}



fun Context.recreateActivity() {
    if (this is Activity) {
        this.recreate()
    }
}


@Composable
fun LanguageDropdown(
    selectedLanguage: String,
    onLanguageSelected: (String) -> Unit
) {
    val languages = listOf("Arabic", "English")
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = selectedLanguage,
            onValueChange = { },
            label = {
                Text(
                    stringResource(R.string.select_language),
                    style = TextStyle(
                        fontFamily = fontMedium,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = Color.White)
                )
            },
            readOnly = true,
            modifier = Modifier.fillMaxWidth(0.8f),
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null
                    )
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(id = R.color.green),
                unfocusedBorderColor = Color.Gray,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White
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

