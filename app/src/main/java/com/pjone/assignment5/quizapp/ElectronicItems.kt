package com.pjone.assignment5.quizapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pjone.dinnerdecider.R

@Composable
fun ElectronicItems() {
    Column {
        LazyColumn (modifier = Modifier.fillMaxHeight(.9f)) {
            item {
                Item(R.drawable.desktop, "Monitor", "Apple Monitor 4K 24-inc", 400.0f)
            }
            item {
                Item(R.drawable.ipad, "Ipad", "Apple Monitor 4K 24-inc", 400.0f)
            }
            item {
                Item(R.drawable.keyboard, "Magic Keyboard", "Apple Monitor 4K 24-inc", 400.0f)
            }
            item {
                Item(R.drawable.iphone, "IPhone", "Apple Monitor 4K 24-inc", 400.0f)
            }
            item {
                Item(R.drawable.mouse, "Magic Mouse", "Apple Monitor 4K 24-inc", 400.0f)
            }
            item {
                Item(R.drawable.laptop, "Apple Mac", "Apple Monitor 4K 24-inc", 400.0f)
            }
        }
        Button(onClick = {}, modifier = Modifier.fillMaxWidth(),colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )) { Text("Checkout") }
    }

}

@Composable
fun Item(img: Int, title: String, description: String, price: Float) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top

    ) {
        Image(
            painter = painterResource(img),
            modifier =
            Modifier
                .width(100.dp)
                .padding(10.dp),
            contentDescription = null,
        )
        Column() {
            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Text(title)
                    Text(description)
                }
                Text("$$price")
            }
            Button(modifier = Modifier.padding(top = 20.dp), onClick = {}) { Text("Add to cart") }
        }
    }
}