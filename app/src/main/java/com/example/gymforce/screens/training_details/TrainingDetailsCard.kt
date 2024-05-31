package com.example.gymforce.screens.training_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymforce.R

@Composable
fun TrainingDetailsCard(image: Int, set: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxSize(0.95f)
            .padding(bottom = 22.dp, top = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(0.9f)
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation()
    )
    {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Training Image",
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .padding(6.dp),
                contentScale = ContentScale.FillWidth,
            )
            Text(
                text = set,
                fontWeight = FontWeight.Medium,
                style = TextStyle(color = Color.Black),
                fontSize = 24.sp,
                modifier = Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(10.dp)
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)

                    .padding(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray.copy(0.9f)
                ),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {
                Text(
                    text = description,
                    fontWeight = FontWeight.Medium,
                    style = TextStyle(color = Color.Black),
                    fontSize = 18.sp,
                    modifier = Modifier
                        .align(
                            Alignment.CenterHorizontally
                        )
                        .padding(10.dp)
                )
            }
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(0.65f),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.orange)),
                contentPadding = ButtonDefaults.TextButtonContentPadding,
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Show On YouTube", fontSize = 20.sp, fontStyle = FontStyle.Normal)
                Icon(
                    painter = painterResource(id = R.drawable.icon_youtube),
                    contentDescription = "icon show in youtube",
                    modifier = Modifier.padding(start = 16.dp)
                )

            }
        }
    }
}