package com.pjone.assignment5.quizapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("In Kotlin, what is the keyword used to declare a variable that cannot be reassigned after its initial assignment?")
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment =  Alignment.CenterVertically,
                    ) {
                        RadioButton(onClick = { answer1 = 1 }, selected = answer1 == 1)
                        Text("a) var")

                        RadioButton(onClick = { answer1 = 2 }, selected = answer1 == 2)
                        Text("b) val")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment =  Alignment.CenterVertically,
                    ) {
                        RadioButton(onClick = { answer1 = 3 }, selected = answer1 == 3)
                        Text("c) const")

                        RadioButton(onClick = { answer1 = 4 }, selected = answer1 == 4)
                        Text("d) final")
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Which Kotlin keyword is used to define a function?")
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment =  Alignment.CenterVertically,
                    ) {
                        RadioButton(onClick = { answer2 = 1 }, selected = answer2 == 1)
                        Text("a) function")

                        RadioButton(onClick = { answer2 = 2 }, selected = answer2 == 2)
                        Text("b) fun")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment =  Alignment.CenterVertically,
                    ) {
                        RadioButton(onClick = { answer2 = 3 }, selected = answer2 == 3)
                        Text("c) funct")

                        RadioButton(onClick = { answer2 = 4 }, selected = answer2 == 4)
                        Text("d) define")
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White, contentColor = Color.Red
                ), onClick = { answer1 = 0; answer2 = 0 }) { Text("Reset") }
                Button(onClick = { calculateQuizScore() }) { Text("Submit") }
            }
            QuizResultDialog(
                showDialog,
                dialogTitle = "Quiz Score",
                dialogText = scoreText,
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
        AlertDialog(title = {
            Text(text = dialogTitle)
        }, text = {
            Text(text = dialogText)
        }, onDismissRequest = {}, confirmButton = {
            TextButton(onClick = {
                onConfirmation()
            }) {
                Text("Okay")
            }
        }, dismissButton = {})
    }
}
