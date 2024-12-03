package com.example.gymforce.ui.screens.trainersScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymforce.R
import com.example.gymforce.common.fontBold
import com.example.gymforce.common.fontMedium

@Composable
fun TrainerCard(
    trainerName: String,
    specialization: String,
    rating: String,
    price: String,
    availability: String,
    image: Int = R.drawable.adults
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(20.dp)) // Rounded corners for the border
            .border(
                1.dp,
                colorResource(R.color.green),
                RoundedCornerShape(20.dp)
            ) // Green border with rounded corners
            .background(colorResource(R.color.black_low)) // Background color inside the border
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp)), // Ensure the card also has rounded corners
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(R.color.black_low)),
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "TrainerImage",
                    modifier = Modifier
                        .size(180.dp)
                        .padding(top = 30.dp)
                )

                Column(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Co.$trainerName",
                        fontFamily = fontBold,
                        fontSize = 22.sp,
                        color = colorResource(R.color.green)
                    )
                    Text(
                        text = "Specialization: $specialization",
                        fontFamily = fontMedium,
                        color = colorResource(R.color.teal_700)
                    )
                    Text(
                        text = "Rating: $rating",
                        fontFamily = fontMedium,
                        color = colorResource(R.color.teal_700)

                    )
                    Text(
                        text = "Price: $price",
                        fontFamily = fontMedium,
                        color = colorResource(R.color.teal_700)

                    )

                    Text(
                        text = "Availability: $availability",
                        fontFamily = fontMedium,
                        color = colorResource(R.color.teal_700)

                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, end = 16.dp, bottom = 10.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(
                            modifier = Modifier.size(height = 40.dp, width = 80.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(R.color.green), // Set the green color as background
                                contentColor = colorResource(R.color.white) // Optional: Set the text color
                            ),
// Set rounded corners for the button
                            onClick = { /*TODO*/ }
                        ) {
                            Text(
                                text = "Call",
                                color = colorResource(R.color.teal_700),
                                fontFamily = fontMedium,

                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun TrainerCardPreview() {
    TrainerCard("Mohamed Atef",
        "Children",
        "4.5", "100$",
        "Tue & Wed 18:00 to 20:00", R.drawable.adults)
}
