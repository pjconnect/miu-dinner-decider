package com.pjone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pjone.assignment3.TableLayoutTest
import com.pjone.assignment5.quizapp.ElectronicItems
import com.pjone.assignment5.quizapp.QuizApp
import com.pjone.dinnerdecider.DeciderInput
import com.pjone.dinnerdecider.ui.theme.DinnerDeciderTheme

class AppNavHost : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DinnerDeciderTheme {
                Surface(modifier = Modifier.fillMaxSize().padding(20.dp), color = Color.White) {
                    Pages()
                }
            }
        }
    }

    @Composable
    private fun Pages() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "MainActivity") {
            composable(route = "MainActivity") { MainActivity(navController = navController) }
            composable("DinnerDecider") { DeciderInput() }
            composable("TableLayoutTest") { TableLayoutTest() }
            composable("QuizApp") { QuizApp() }
            composable("ElectronicItems") { ElectronicItems() }
        }
    }
}





