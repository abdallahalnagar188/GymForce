package com.example.gymforce.ui.commonUi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymforce.R

@Composable
fun ProfileCard(image: Int, text: String, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.baby_blue))
            .clickable { onClick() }
    ) {
        Row(modifier = Modifier.fillMaxWidth().background(color = colorResource(id = R.color.baby_blue)),
            verticalAlignment = Alignment.CenterVertically) {

            Icon(
                modifier = Modifier
                    .size(35.dp)
                    .padding(start = 16.dp),
                painter = painterResource(id = image),
                contentDescription = null,
                tint = colorResource(id = R.color.white)

            )

            Text(modifier = Modifier.padding(start = 8.dp),
                text = text,
                fontSize = 16.sp,
                maxLines = 1,
                color = colorResource(id = R.color.white)
            )

        }

    }
}

@Preview
@Composable
fun ProfileCardPreview() {
    ProfileCard(R.drawable.user, "Account")
}