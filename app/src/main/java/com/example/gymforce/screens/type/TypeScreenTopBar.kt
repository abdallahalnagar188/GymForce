package com.example.gymforce.screens.type

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gymforce.R

@Composable
fun TypeScreenTopBar(trainingScreenName: String, navHostController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        IconButton(
            onClick =
            {
                navHostController.popBackStack()
            },
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_back),
                contentDescription = "icon back",
            )
        }

        Text(
            text = trainingScreenName,
            color = Color.Black,
            fontFamily = FontFamily.Default,
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 40.dp)
        )
    }
}