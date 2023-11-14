package com.pjone

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainActivity(navController: NavHostController) {
    Column {
        Text(
            text = "Mobile Device Programming",
            fontSize = 22.sp,
//            modifier = Modifier.padding(bottom = 20.dp)
        )
        Column(verticalArrangement = Arrangement.Center) {
            Button(onClick = {
                navController.navigate("DinnerDecider")
            }) { Text("Assignment 2 - Dinner Decider") }
            Button(onClick = {
                navController.navigate("TableLayoutTest")
            }) { Text("Assignment 3 - TableLayoutTest") }
            Button(onClick = {
                navController.navigate("QuizApp")
            }) { Text("Assignment 5 - Quiz App") }
            Button(onClick = {
                navController.navigate("ElectronicItems")
            }) { Text("Assignment 5 - Electronic Items") }
        }
    }

}
