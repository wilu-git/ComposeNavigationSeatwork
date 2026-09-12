package com.example.composenavigationseatwork

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onViewDetails: (String, String, String) -> Unit
) {
    var loginAttempts by remember {
        mutableStateOf(0)
    }

    var studentName by remember {
        mutableStateOf("Venalouie Cruz")
    }
    var studentId by remember {
        mutableStateOf("20-0023-924")
    }

    var studentCourse by remember{
        mutableStateOf("Computer Engineering")
    }

    var studentYear by remember{
        mutableStateOf("4")
    }

    var errorMessage by remember {
        mutableStateOf("")
    }

    var showConfirmation by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Student Information"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        TextField(studentId,
            onValueChange = {
                studentId = it
            },
            label = {
                Text("Student ID")
            },
            modifier = Modifier.padding(bottom = 6.dp)
        )

        TextField(studentName,
            onValueChange = {
                studentName = it
            },
            label = {
                Text("Student Name")
            },
            modifier = Modifier.padding(bottom = 6.dp)
        )

        TextField(studentCourse,
            onValueChange = {
                studentCourse = it
            },
            label = {
                Text("Course")
            },
            modifier = Modifier.padding(bottom = 6.dp)
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "Name: "
        )
        Text(
            text = studentName,
            modifier = Modifier.padding(bottom = 6.dp)
        )

        Text(
            text = "Course: ",

        )
        Text(
            text = studentCourse,
            modifier = Modifier.padding(bottom = 6.dp)
        )

        Text(
            text = "Year: "
        )
        Text(
            text = studentYear,
            modifier = Modifier.padding(bottom = 6.dp)
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
        if(errorMessage.isNotEmpty()){
            Text(
                text = errorMessage,
                color = Color.Red
                //color = MaterialTheme.colorScheme.error
                //Possible tanungin ni sir: colorScheme set by material 3,
                // built in validation color. That adjusts to
                // different themes (dark modes and dynamic color support (device wallpaper others)
            )
            Spacer(
                modifier = Modifier.height(12.dp)
            )
        }

        Button(
            onClick = {
                if(studentId.isBlank()) {
                    errorMessage = "Student ID is required"
                } else if (studentName.isBlank()){
                    errorMessage = "Name is required"
                } else if (studentCourse.isBlank()){
                    errorMessage = "Course is required."
                } else {
                    errorMessage = ""
                    showConfirmation = true
                }
            }
        ) {
            Text(
                text = "View Details"
            )
        }
    }

    if(showConfirmation){
        AlertDialog(
            onDismissRequest = {
                showConfirmation = false
            },
            title = {
                Text(
                    text = "Confirm Student Information"
                )
            },

            text = {
                Text(
                    text = "View details for:\n$studentName?"
                )
            },

            confirmButton = {
                TextButton(
                    onClick = {
                        showConfirmation = false

                        onViewDetails(
                            studentId,
                            studentName,
                            studentCourse
                        )
                    }

                ){
                    Text("Continue")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showConfirmation = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}