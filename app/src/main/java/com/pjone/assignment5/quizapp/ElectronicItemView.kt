package com.pjone.assignment5.quizapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ElectronicItemView(productId: String?, navController: NavHostController) {
    val itemInfo = ItemRepository().find { item -> item.id == productId?.toInt() }
    itemInfo?.name?.let { Log.d("prod", it) }
    if (itemInfo == null) {
        Text("No item found with this ID")
        return;
    }
    Column {
        Image(
            painter = painterResource(itemInfo.img),
            modifier =
            Modifier
                .width(100.dp)
                .height(100.dp)
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
                    Text(itemInfo.name)
                    Text(itemInfo.description)
                }
                Text(text = "$${itemInfo.price}", fontSize = 30.sp)
            }
        }
        Button(onClick = {navController.navigate("ElectronicItems")}){ Text("Home") }
    }


}