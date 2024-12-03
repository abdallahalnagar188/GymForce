package com.example.gymforce.ui.screens.home.categorys

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gymforce.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(item: Category, position: Int, navHostController: NavHostController) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = item.backGroundColor)
        ),
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 12.dp)
            .fillMaxWidth(),
        onClick = {
            // Navigation or click action
            navHostController.navigate(Screen.HealthForm.route)

        },
        shape = if (position % 2 == 0) {
            RoundedCornerShape(
                topStart = 16.dp, topEnd = 16.dp, bottomStart = 16.dp, bottomEnd = 0.dp
            )
        } else {
            RoundedCornerShape(
                topStart = 16.dp, topEnd = 16.dp, bottomStart = 0.dp, bottomEnd = 16.dp
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = item.drawableResId),
                contentDescription = stringResource(id = item.titleResId),
                modifier = Modifier
                    .height(140.dp)
                    .width(100.dp),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = stringResource(id = item.titleResId),
                style = TextStyle(color = Color.White),
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
