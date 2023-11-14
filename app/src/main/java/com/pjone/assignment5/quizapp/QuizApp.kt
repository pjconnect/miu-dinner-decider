package com.pjone.assignment5.quizapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun QuizApp() {
    var answer1 by remember { mutableIntStateOf(0) }
    var answer2 by remember { mutableIntStateOf(0) }
    var scoreText by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    fun calculateQuizScore() {
        var total = 0;
        if (answer1 == 2) {
            total += 50;
        }
        if (answer2 == 2) {
            total += 50;
        }
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val d = LocalDateTime.now().format(formatter).toString()
        scoreText = "Congratulations! You submitted on the $d, you achieved $total%";
        showDialog = true
    }

    Surface(modifier = Modifier.padding(20.dp)) {
        Column {
            Column {
                Text("Question 1: What is the primary purpose of the val keyword in Kotlin?")
                Column {
                    Row {
                        RadioButton(onClick = { answer1 = 1 }, selected = answer1 == 1)
                        Text("a) It is used to declare mutable variables.")
                    }
                    Row {
                        RadioButton(onClick = { answer1 = 2 }, selected = answer1 == 2)
                        Text("b) It is used to declare read-only (immutable) variables")
                    }
                }
            }
            Column {
                Text("Question 3: How does Kotlin handle nullability in variable declarations?")
                Column {
                    Row {
                        RadioButton(onClick = { answer2 = 1 }, selected = answer2 == 1)
                        Text("a) All variables in Kotlin are non-nullable by default.")
                    }
                    Row {
                        RadioButton(onClick = { answer2 = 2 }, selected = answer2 == 2)
                        Text("b) Kotlin introduces nullable types using the ? symbol, allowing variables to hold a null value.")
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth().padding(top = 20.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Red
                ),
                    onClick = { answer1 = 0; answer2 = 0 }) { Text("Reset") }
                Button(onClick = { calculateQuizScore() }) { Text("Submit") }
            }
            QuizResultDialog(showDialog, dialogTitle = "Quiz Score", dialogText = scoreText,
                onConfirmation = { showDialog = false })
        }
    }
}

@Composable
fun QuizResultDialog(
    show: Boolean,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
) {
    if (show) {
        AlertDialog(
            title = {
                Text(text = dialogTitle)
            },
            text = {
                Text(text = dialogText)
            },
            onDismissRequest = {
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onConfirmation()
                    }
                ) {
                    Text("Okay")
                }
            },
            dismissButton = {
            }
        )
    }
}
