package com.example.gymforce.ui.screens.home.bodyPart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BodyPartLazyColumn(bodyPartList: List<String>, onClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize().displayCutoutPadding()
            .padding(bottom = 50.dp, start = 8.dp, end = 8.dp, top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(bodyPartList.size) { index ->
            BodyPartCard(
                bodyPartName = bodyPartList[index],
                onClick = { onClick(bodyPartList[index]) } // Each card calls onClick with its name
            )
        }
    }
}
