package com.pjone.dinnerdecider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.pjone.dinnerdecider.ui.theme.DinnerDeciderTheme
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DinnerDeciderTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    DeciderInput()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeciderInput() {
    var text by remember { mutableStateOf("")}
    val dinnerNames by remember  { mutableStateOf(arrayListOf("Hamburger", "Pizza",
        "Mexican", "American", "Chinese")) }

    fun decideFood() {
        val randIndex = (0 until  dinnerNames.size-1).random();
        text = dinnerNames[randIndex];
    }

    Column(modifier = Modifier) {
        Column (modifier = Modifier.fillMaxHeight(.9f).fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(R.drawable.dd_logo), modifier = Modifier.defaultMinSize(250.dp), contentDescription = null)
            Text(
                text = "Dinner Check",
            )
            TextField(
                value = text,
                onValueChange = {text = it},
                label ={
                    Text("Enter your desire dinner")
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            )
            Button(onClick = { dinnerNames.add(text); text = "" }) { Text("Add Food") }
        }
        Button(modifier = Modifier.fillMaxWidth(), onClick = {decideFood()}) { Text("Decide") }
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


