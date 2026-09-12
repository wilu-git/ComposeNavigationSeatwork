package com.example.composenavigationseatwork


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen(
    studentId: String,
    studentName: String,
    studentCourse: String,
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Student Details"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Student ID: $studentId"
        )

        Text(
            text = "Name: $studentName"
        )

        Text(
            text = "Course: $studentCourse"
        )

        Text(
            text = "Year: 4"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                onBack()
            }
        ) {
            Text(
                text = "Back"
            )
        }
    }
}