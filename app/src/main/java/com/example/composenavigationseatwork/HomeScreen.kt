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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onViewDetails: () -> Unit
) {

    var loginAttempts by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Student Information"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Name: Venalouie Cruz"
        )

        Text(
            text = "Course: BS Computer Engineering"
        )

        Text(
            text = "Year: 4"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Login Attempts: $loginAttempts"
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Button(
            onClick = {
                loginAttempts++
            }
        ) {
            Text(
                text = "Add Attempt"
            )
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Button(
            onClick = {
                onViewDetails()
            }
        ) {
            Text(
                text = "View Details"
            )
        }
    }
}