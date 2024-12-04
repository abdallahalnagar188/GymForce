package com.example.gymforce.ui.screens.trainersScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

// Male Trainer List
@Composable
fun TrainerListMen(trainers: List<Trainer>) {
    LazyColumn {
        items(trainers.size) { index ->
            TrainerCard(trainer = trainers[index])
        }
    }
}

fun generateRandomMenTrainers(count: Int): List<Trainer> {
    val specializations = listOf("Weight Loss", "Bodybuilding", "CrossFit", "Yoga", "Pilates", "Children")
    val randomNames = listOf("Mohamed", "Omar", "Ahmed", "Ali", "Hassan", "Mostafa", "Hany", "Tarek", "Ramy", "Amr")
    val randomLastNames = listOf("Omar", "Ahmed", "Ali", "Hassan", "Mostafa", "Tarek", "Brown", "Davis", "Wilson", "Garcia")
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
            imageUrl = "https://randomuser.me/api/portraits/men/${Random.nextInt(10, 70)}.jpg", // Male portraits
            schedule = "Flexible",
            phoneNumber = phoneNumbers.random()
        )
    }
}

// Female Trainer List
@Composable
fun TrainerListWomen(trainers: List<Trainer>) {
    LazyColumn {
        items(trainers.size) { index ->
            TrainerCard(trainer = trainers[index])
        }
    }
}

fun generateRandomWomenTrainers(count: Int): List<Trainer> {
    val specializations = listOf("Weight Loss", "Bodybuilding", "CrossFit", "Yoga", "Pilates", "Children")
    val randomNames = listOf("Sara", "Mona", "Fatima", "Dina", "Noha", "Rania", "Layla", "Huda", "Noura", "Amina", "Jana")
    val randomLastNames = listOf("Mohamed", "Ali", "Ahmed", "Hassan", "Sayed", "Abbas", "Khaled", "Ramadan")
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
            imageUrl = "https://randomuser.me/api/portraits/women/${Random.nextInt(10, 70)}.jpg", // Female portraits
            schedule = "Flexible",
            phoneNumber = phoneNumbers.random()
        )
    }
}

// Preview for Male Trainers
@Preview
@Composable
fun TrainerListMenPreview() {
    TrainerListMen(trainers = generateRandomMenTrainers(10))
}

// Preview for Female Trainers
@Preview
@Composable
fun TrainerListWomenPreview() {
    TrainerListWomen(trainers = generateRandomWomenTrainers(10))
}
