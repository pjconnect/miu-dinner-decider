package com.pjone.dinnerdecider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.pjone.dinnerdecider.ui.theme.DinnerDeciderTheme
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController


class DinnerHome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                DeciderInput()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeciderInput() {
    var dinnerName by remember { mutableStateOf("") }
    val dinnerSelection by remember {
        mutableStateOf(
            arrayListOf(
                "Hamburger", "Pizza",
                "Mexican", "American", "Chinese"
            )
        )
    }

    fun decideFood() {
        val randIndex = (0 until dinnerSelection.size - 1).random();
        dinnerName = dinnerSelection[randIndex];
    }

    fun addFood() {
        dinnerSelection.add(dinnerName);
        dinnerName = ""
    }
    Column(modifier = Modifier) {
        Column(
            modifier = Modifier.fillMaxHeight(.9f).fillMaxWidth().padding(top = 20.dp),
//            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.dd_logo),
                modifier = Modifier.defaultMinSize(100.dp, minHeight = 100.dp),
                contentDescription = null,

            )
            Text(
                text = "Dinner Decider",
                fontSize = 30.sp,
                modifier = Modifier.padding(15.dp),
            )
            TextField(
                value = dinnerName,
                onValueChange = { dinnerName = it },
                label = {
                    Text("Enter your desire dinner")
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            )
            Button(onClick = { addFood() }) { Text("Add Food") }
        }
        Button(modifier = Modifier.fillMaxWidth(), onClick = { decideFood() }) { Text("Decide") }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DinnerDeciderTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            DeciderInput()
        }
    }
}


