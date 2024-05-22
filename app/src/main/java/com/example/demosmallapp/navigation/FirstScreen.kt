package com.example.demosmallapp.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demosmallapp.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.FirstScreen.route) {
        composable(route = Screens.FirstScreen.route) {
            FirstScreenn(navController = navController)
        }
        composable(route = Screens.SecondScreen.route + "/{name}/{surname}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "Yash"
                } ,navArgument("surname"){
                    type = NavType.StringType
                    defaultValue = "more"
                }
            )
        )
        {
            SecondScreen(it.arguments?.getString("name").toString(),it.arguments?.getString("surname").toString())
        }
        composable(route = Screens.HomeScreen.route)
        {
            HomeScreen()
        }
    }
}

@Composable
fun FirstScreenn(navController: NavController) {

    var text by remember {
        mutableStateOf("")
    }
    var secondtext by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        TextField(value = text, onValueChange = {
            text = it
        },
            modifier = Modifier.fillMaxWidth())
        TextField(value = secondtext, onValueChange = {
            secondtext = it
        },
            modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            if (text.isEmpty()) {
                navController.navigate(Screens.HomeScreen.route)
            }else{
                navController.navigate(Screens.SecondScreen.withArg(text,secondtext))
            }
        }) {
            Text(text = "send")
        }
    }
}

@Preview
@Composable
fun Preview() {

}