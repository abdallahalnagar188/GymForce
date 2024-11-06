package com.example.gymforce.ui.screens.home.exercise_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.gymforce.R
import com.example.gymforce.common.fontBold

@Composable
fun ExerciseDetailsContent(
    exerciseId: String,
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        AppBar(
            navHostController = navHostController,
            exerciseId = exerciseId
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 230.dp, width = 250.dp)
                .clip(RoundedCornerShape(42.dp)),
            painter = painterResource(id = R.drawable.on_boarding_two),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier= Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                text = "Exercise Name",
                color = Color.White,
                fontFamily = fontBold,
                textAlign = TextAlign.Start,
                fontSize = 24.sp
            )
            Text(
                modifier = Modifier
                    .padding(top = 40.dp, end = 8.dp),
                text = "Target Muscle",
                color = Color.White,
                fontFamily = fontBold,
                textAlign = TextAlign.End,
                fontSize = 24.sp
            )

        }

        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            text = "Overview :",
            color = Color.White,
            fontFamily = fontBold,
            textAlign = TextAlign.Start,
            fontSize = 24.sp
        )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        width = 2.dp, // Set the thickness of the border
                        color = colorResource(id = R.color.green),
                        shape = RoundedCornerShape(16.dp) // Matches the shape of the clipping
                    )
            ) {
                item{

                }
            }





    }


}

@Preview
@Composable
 fun DetailsPreview () {
    ExerciseDetailsContent(
        exerciseId = "1",
        navHostController = NavHostController(context = LocalContext.current)
    )
}