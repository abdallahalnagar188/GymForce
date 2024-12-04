package com.example.gymforce.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.domain.models.User
import com.example.gymforce.R
import com.example.gymforce.common.fontBold
import com.example.gymforce.common.fontMedium
import com.example.gymforce.ui.commonUi.CustomAppBar
import com.example.gymforce.ui.screens.home.HomeAppBar

@Composable
fun ProfileScreenContent(
    user: User,
    onSignOut: () -> Unit,
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .displayCutoutPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeAppBar(title = stringResource(R.string.profile))

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = user.name,
                fontSize = 20.sp,
                fontFamily = fontBold,
                color = colorResource(id = R.color.white)
            )
        }

        ProfileCard(image = R.drawable.user, text = "Username: ${user.name}", onClick = {})
        Spacer(modifier = Modifier.height(12.dp))

        ProfileCard(image = R.drawable.age, text = "Age: ${user.age}", onClick = {})
        Spacer(modifier = Modifier.height(12.dp))

        ProfileCard(image = R.drawable.envelope, text = "Email: ${user.email}", onClick = {})
        Spacer(modifier = Modifier.height(12.dp))

        ProfileCard(image = R.drawable.venus_mars, text = "Gender: ${user.gender}", onClick = {})
        Spacer(modifier = Modifier.height(12.dp))

        ProfileCard(image = R.drawable.user, text = "User Type: ${user.userType}", onClick = {})
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onSignOut,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = colorResource(R.color.black_low),
                containerColor = colorResource(R.color.green)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.sign_out),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                stringResource(R.string.sign_out),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontFamily = fontMedium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}
