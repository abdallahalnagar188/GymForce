package com.example.gymforce.ui.screens.trainersScreen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.gymforce.R
import com.example.gymforce.common.fontBold
import com.example.gymforce.common.fontMedium

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TrainerCard(
    trainer: Trainer
) {
    val context = LocalContext.current // Get context for creating an intent

    Box(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(20.dp))
            .border(
                1.dp,
                colorResource(R.color.green),
                RoundedCornerShape(20.dp)
            )
            .background(colorResource(R.color.baby_blue))
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(R.color.baby_blue)),
            ) {
                GlideImage(
                    model = trainer.imageUrl, // Trainer image URL
                    contentDescription = "TrainerImage",
                    modifier = Modifier.padding(start = 8.dp)
                        .size(100.dp)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(50.dp)), // Rounded corners for image
                )

                Column(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Co. ${trainer.name}",
                        fontFamily = fontBold,
                        fontSize = 20.sp,
                        color = colorResource(R.color.white)
                    )
                    Text(
                        text = "Specialization: ${trainer.specialization}",
                        fontFamily = fontMedium,
                        fontSize = 16.sp,
                        color = colorResource(R.color.white)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        // Call Button with Icon
                        Button(
                            modifier = Modifier,
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(R.color.green),
                                contentColor = colorResource(R.color.white)
                            ),
                            onClick = {
                                val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${trainer.phoneNumber}"))
                                context.startActivity(dialIntent)
                            }
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Call, // Phone icon
                                    contentDescription = "Call",
                                    tint = colorResource(R.color.white),
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Call",
                                    color = colorResource(R.color.white),
                                    fontFamily = fontMedium,
                                )
                            }
                        }

                        // WhatsApp Button with Icon
                        Button(
                            modifier = Modifier
                                .padding(start = 8.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(R.color.green),
                                contentColor = colorResource(R.color.white)
                            ),
                            onClick = {
                                val whatsappIntent = Intent(Intent.ACTION_VIEW).apply {
                                    data = Uri.parse("https://wa.me/${trainer.phoneNumber}")
                                }
                                context.startActivity(whatsappIntent)
                            }
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_whatsapp), // Replace with your WhatsApp icon
                                    contentDescription = "WhatsApp",
                                    tint = colorResource(R.color.white),
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "WhatsApp",
                                    color = colorResource(R.color.white),
                                    fontFamily = fontMedium,
                                )
                            }
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
    TrainerCard(
        Trainer(
            name = "Mohamed Atef",
            specialization = "Children",
            rating = "4.5",
            price = "100$",
            availability = "Tue & Wed 18:00 to 20:00",
            imageUrl = "https://example.com/adults.jpg",
            schedule = "Tue & Wed 18:00 to 20:00",
            phoneNumber = "01012345678"
        )
    )
}

