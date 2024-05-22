package com.example.demosmallapp.navigation

sealed class Screens (val route : String){
    object FirstScreen : Screens("first_screen")
    object SecondScreen : Screens("second_screen")
    object HomeScreen : Screens("home_screen")

    fun withArg(vararg args : String) : String{
        return buildString {
            append(route)
            args.forEach { args->
                append("/$args")
            }
        }

    }
}