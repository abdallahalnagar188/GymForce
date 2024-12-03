package com.example.gymforce.ui.screens.trainersScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.gymforce.R
import kotlin.random.Random

@Composable
fun TrainerList(trainers: List<Trainer>) {
    LazyColumn {
        items(trainers.size) { index ->
            TrainerCard(trainer = trainers[index])
        }
    }
}

fun generateRandomTrainers(count: Int): List<Trainer> {
    val specializations = listOf("Weight Loss", "Bodybuilding", "CrossFit", "Yoga", "Pilates", "Children")
    val randomNames = listOf("Mohamed", "Omar", "Jane", "Samer", "Abdallah", "Atef", "Hassan", "Ahmed", "Ali","Ramy","Mostafa")
    val randomLastNames = listOf("Omar", "Mohamed", "Ahmed", "Ali", "Hassan", "Mostafa", "Hany","Brown", "Davis", "Wilson", "Garcia", "Lee", "Walker")
    val phoneNumbers = listOf("01012345678", "01112345678", "01212345678", "01512345678", "01612345678", "01712345678", "01812345678", "01912345678")

    return List(count) {
        val firstName = randomNames.random()
        val lastName = randomLastNames.random()
        Trainer(
            name = "$firstName $lastName",
            specialization = specializations.random(),
            rating = "%.1f".format(Random.nextDouble(3.0, 5.0)), // Random rating between 3.0 and 5.0
            price = "${Random.nextInt(50, 150)}$ per session",
            availability = "Tue & Wed ${Random.nextInt(16, 20)}:00 to ${Random.nextInt(20, 22)}:00",
            imageUrl = "https://randomuser.me/api/portraits/men/${Random.nextInt(10, 70)}.jpg",
            schedule = "Flexible",
            phoneNumber = phoneNumbers.random()
        )
    }
}

@Preview
@Composable
fun TrainerListPreview() {
    TrainerList(trainers = generateRandomTrainers(10))
}
