package com.example.demosmallapp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.demosmallapp.dialogbox.DialogBox
import com.example.demosmallapp.ui.theme.BlueViolet1

@Composable
fun SecondScreen(value: String = "Hello Yash", valuetwo: String = "nice") {

    var dialogShow by remember {
        mutableStateOf(false)
    }

    if (dialogShow){
        DialogBox(onDismiss = {
           dialogShow = false
        })
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlueViolet1)
            .padding(20.dp)
    ) {
        Button(onClick = { dialogShow = true}) { Text(text = "$value  $valuetwo") }
    }
}