package com.example.gymforce.screens.Exercises

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymforce.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainingCard(name: String, day: String, image: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(0.9f)),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        onClick = {
        }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = image),
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 8.dp, top = 2.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(text = day, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(text = name, fontSize = 22.sp, fontWeight = FontWeight.Normal)
            }
            Icon(
                painter = painterResource(id = R.drawable.icon_arrow),
                contentDescription = "icon go to training Screen ",
                modifier = Modifier.padding(start = 120.dp)
            )
        }

    }
}