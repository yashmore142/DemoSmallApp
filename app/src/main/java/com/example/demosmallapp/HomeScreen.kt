package com.example.demosmallapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demosmallapp.ui.theme.AquaBlue
import com.example.demosmallapp.ui.theme.Beige3
import com.example.demosmallapp.ui.theme.BlueViolet1
import com.example.demosmallapp.ui.theme.BlueViolet2
import com.example.demosmallapp.ui.theme.ButtonBlue
import com.example.demosmallapp.ui.theme.DarkerButtonBlue
import com.example.demosmallapp.ui.theme.DeepBlue
import com.example.demosmallapp.ui.theme.DemoSmallAppTheme
import com.example.demosmallapp.ui.theme.LightGreen3
import com.example.demosmallapp.ui.theme.LightRed
import com.example.demosmallapp.ui.theme.OrangeYellow3

@Composable
fun HomeScreen() {
    val list = listOf<String>("yash", "abc", "xyz")
    val featureList: ArrayList<FeatureData> = ArrayList()
    featureList.add(
        FeatureData(
            "Sleep Meditation",
            R.drawable.ic_headphones,
            BlueViolet1,
            BlueViolet2
        )
    )
    featureList.add(
        FeatureData(
            "Tip of Sleeping",
            R.drawable.ic_video_camera,
            BlueViolet1,
            LightGreen3
        )
    )
    featureList.add(FeatureData("Night Island", R.drawable.ic_headphones, BlueViolet1, Beige3))
    featureList.add(
        FeatureData(
            "Claming Sound",
            R.drawable.ic_video_camera,
            BlueViolet1,
            OrangeYellow3
        )
    )
    featureList.add(
        FeatureData(
            "Sleep Meditation",
            R.drawable.ic_headphones,
            BlueViolet1,
            AquaBlue
        )
    )

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {

        Column {
            GrapttingSection()
            ChipSection(list)
            DailyThought()
            BottomNav(
                listOf(
                    BottomNavData("Home", R.drawable.ic_home_),
                    BottomNavData("Meditate", R.drawable.ic_moon_),
                    BottomNavData("Sleep", R.drawable.ic_moon_),
                    BottomNavData("Music", R.drawable.ic_music_)
                )
            )
            FeaturedSection(featureList)

        }
    }
}

@Composable
fun GrapttingSection(value: String = "Good Morning , Yash..") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)

    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )
            Text(text = "We Wish You have good day!", color = Color.White)
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            tint = Color.White,
            contentDescription = "Search",
            modifier = Modifier
                .size(30.dp)
                .background(Color.Blue, RoundedCornerShape(20))
                .padding(3.dp)
        )


    }
}

@Composable
fun ChipSection(chips: List<String>) {
    var selectedChip by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .clickable { selectedChip = it }
                    .background(
                        if (selectedChip == it) ButtonBlue
                        else DarkerButtonBlue, RoundedCornerShape(30)
                    )
                    .clip(RoundedCornerShape(15.dp))
            ) {
                Text(text = chips[it], Modifier.padding(20.dp), color = Color.White)
            }
        }
    }
}

@Composable
fun DailyThought() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(LightRed)
            .padding(horizontal = 15.dp, vertical = 20.dp)


    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )
            Text(text = "We Wish You have good day!", color = Color.White)
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_play),
            tint = Color.White,
            contentDescription = "Play",
            modifier = Modifier
                .size(30.dp)
                .background(Color.Blue, RoundedCornerShape(50))
                .padding(3.dp)
        )


    }
}

@Composable
fun FeaturedSection(featureList: List<FeatureData>) {
    Column {
        Text(
            text = "Featured",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 20.dp, top = 15.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            items(featureList.size) {
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .width(50.dp)
                        .padding(20.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(featureList[it].darkColor)
                        .fillMaxSize()
                        .padding(15.dp)


                ) {
                    Text(
                        text = featureList[it].title,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.TopCenter)
                    )
                    Icon(
                        painter = painterResource(id = featureList[it].iconId),
                        contentDescription = "Icon",
                        modifier = Modifier.align(Alignment.BottomEnd).padding(bottom = 10.dp)
                    )

                    Button(
                        modifier = Modifier.align(Alignment.BottomStart),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Start")
                    }

                }
            }
        }


    }

}

@Composable
fun BottomNav(
    bottomList: List<BottomNavData>,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0,
) {

    var selctedItem by remember {
        mutableStateOf(initialSelectedItemIndex)

    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier

            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        bottomList.forEachIndexed { index, bottomNavData ->
            BottomNavItem(
                bottomNavData, isSelected = index == selctedItem,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selctedItem = index
            }
        }

    }

}

@Composable
fun BottomNavItem(
    item: BottomNavData,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {

        Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
                .clickable { onItemClick() }
        ) {
            Icon(
                painterResource(id = item.iconId), contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )

            Text(text = item.title, color = if (isSelected) activeTextColor else inactiveTextColor)
        }

}

@Preview(showBackground = true)
@Composable
fun Preview() {
    HomeScreen()
}