package com.example.demosmallapp

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class FeatureData(
    val title : String,
    @DrawableRes val iconId : Int,
    val lightColor :  Color,
    val darkColor : Color
)
