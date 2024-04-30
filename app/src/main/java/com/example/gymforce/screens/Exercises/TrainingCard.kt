package com.example.gymforce.screens.Exercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gymforce.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainingCard(name: String, day: String, image: Int, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(0.9f)
        ),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 7.dp
        ),
        onClick = {
            navController.navigate("TypeTrainingScreen/${name}")
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "",
                modifier = Modifier
                    .size(110.dp)
                    .padding(end = 8.dp, top = 2.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.FillHeight
            )
            Column (modifier= Modifier.fillMaxWidth(.7f).padding(start = 8.dp)){
                Text(text = day, fontSize = 22.sp, fontWeight = FontWeight.Medium)
                Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Normal)
            }
            Icon(
                painter = painterResource(id = R.drawable.icon_arrow),
                contentDescription = "icon go to training Screen ",
                modifier = Modifier.weight(0.2f)
            )
        }

    }
}