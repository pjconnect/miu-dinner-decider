package com.pjone.assignment5.quizapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pjone.dinnerdecider.R

@Composable
fun ElectronicItems(navController: NavHostController) {
    var showDialog by remember { mutableStateOf(false) }
    val items = ProductRepository();
    var cartText by remember { mutableStateOf("Empty Cart") }
    val itemAdded = mutableListOf<String>()
    Column {
        LazyColumn(modifier = Modifier.fillMaxHeight(.9f)) {
            itemsIndexed(items) { index, item ->
                Row (modifier = Modifier.padding(bottom = 10.dp)) {
                    Item(item.id, item.img, item.name, item.description, item.price, {
                        itemAdded.add(it)
                    }, navController)
                }
            }
        }
        Button(
            onClick = {
                cartText = itemAdded.joinToString(separator = ", ")
                showDialog = true
            }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) { Text("Checkout") }
    }
    QuizResultDialog(showDialog, dialogTitle = "Cart", dialogText = cartText,
        onConfirmation = { showDialog = false })

}

@Composable
fun Item(
    id: Int, img: Int, title: String, description: String, price: Float,
    onAddToCart: (String) -> Unit,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(10.dp)
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
                Image(
                    painter = painterResource(R.drawable.apple_logo),
                    modifier =
                    Modifier
                        .width(30.dp)
                        .padding(10.dp),
                    contentDescription = null,
                )
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
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp)) {
                Button(
                    modifier = Modifier.padding(top = 20.dp),
                    onClick = { onAddToCart(title) }) { Text("Add to cart") }
            }
        }
    }
}