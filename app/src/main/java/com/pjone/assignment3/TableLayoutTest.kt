package com.pjone.assignment3

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pjone.MainActivity
import com.pjone.dinnerdecider.DeciderInput

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TableLayoutTest() {

    var values by remember { mutableStateOf(arrayListOf("")) }

    Column {
        TextField(value = "", onValueChange = {})
        TextField(value = "", onValueChange = {})
        Button(onClick = {}){ Text("Add") }

    }

}