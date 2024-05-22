package com.example.demosmallapp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.demosmallapp.ui.theme.BlueViolet1

@Composable
fun SecondScreen(value: String = "Hello Yash",valuetwo: String = "nice") {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(BlueViolet1)
        .padding(20.dp)) {
        Text(text = "$value $valuetwo", color = Color.White)
    }
}