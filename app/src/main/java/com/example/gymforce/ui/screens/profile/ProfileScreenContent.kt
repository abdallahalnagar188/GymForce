package com.example.gymforce.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.domain.models.User
import com.example.gymforce.R
import com.example.gymforce.common.fontMedium

@Composable
fun ProfileScreenContent(
    user: User,
    onSignOut: () -> Unit // Add the sign-out callback
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Display user information
        Text(text = user.name, fontSize = 30.sp, color = Color.White, fontFamily = fontMedium)
        Text(text = user.email, fontSize = 30.sp, color = Color.White, fontFamily = fontMedium)
        Text(text = user.gender, fontSize = 30.sp, color = Color.White, fontFamily = fontMedium)
        Text(text = user.age.toString(), fontSize = 30.sp, color = Color.White, fontFamily = fontMedium)
        Text(text = user.userType, fontSize = 30.sp, color = Color.White, fontFamily = fontMedium)

        // Sign Out Button
        Button(
            onClick = onSignOut,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = colorResource(R.color.green)
            ), shape = RoundedCornerShape(20)
        ) {
            Text("Sign Out", textAlign = TextAlign.Center)
        }
    }
}
