package com.pjone.assignment5.quizapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pjone.dinnerdecider.R

@Composable
fun ElectronicItems(navController: NavHostController) {
    Column {
        LazyColumn(modifier = Modifier.fillMaxHeight(.9f)) {
            itemsIndexed(ItemRepository()) { index, item ->
                Item(item.id, item.img, item.name, item.description, item.price, navController)
            }
        }
        Button(
            onClick = {}, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) { Text("Checkout") }
    }

}

@Composable
fun Item(id: Int, img: Int, title: String, description: String, price: Float, navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("ElectronicItemView/$id") },
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