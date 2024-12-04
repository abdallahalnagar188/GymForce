package com.example.gymforce.ui.screens.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymforce.R
import com.example.gymforce.common.fontMedium

@Composable
fun ProfileCard(
    image: Int,
    text: String,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.transparent)
        ),
//        elevation = CardDefaults.cardElevation(8.dp),
        shape = CardDefaults.shape
    ) {
        Row(
            modifier = Modifier
                .padding(start = 4.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.size(26.dp),
                tint = Color.White
            )

            Text(
                text = text,
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 16.sp,
                color = Color.White,
                fontFamily = fontMedium,
                maxLines = 1
            )
        }
    }
}

@Preview
@Composable
fun ProfileCardPreview() {
    ProfileCard(R.drawable.user, "Account")
}
