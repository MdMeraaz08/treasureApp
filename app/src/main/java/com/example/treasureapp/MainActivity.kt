package com.example.treasureapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.treasureapp.ui.theme.TreasureAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TreasureAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    treasureGame()
                }
            }
        }
    }
}



@Composable
fun MySpacer(i : Int) {
    Spacer(modifier = Modifier.height(i.dp))
    Spacer(modifier = Modifier.width(i.dp))
}


@Composable
fun treasureGame(){


    val treasuresFound = remember {
        mutableStateOf(0)
    }
    val currentDirection = remember {
        mutableStateOf("East")
    }

    val currentAlert = remember {
        mutableStateOf("Storm Ahead")
    }


Column (
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
){

    Text(
        text = "Treasure Game",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold // Optional: To make the text bold
    )

    MySpacer(10)
    Text(text = "Treasures Found : ${treasuresFound.value}")
    MySpacer(10)
    Text(text = "Current Direction : ${currentDirection.value}")

    MySpacer(28)

    Row {
        Button(onClick = {
            currentDirection.value = "East"
            if (Random.nextBoolean()){
                treasuresFound.value++
                currentAlert.value = "Treasure Found"

            }else{
                currentAlert.value = "Storm Ahead"
            }


        }) {
            Text("Sail East")
        }

        MySpacer(18)
        Button(onClick = {
            currentDirection.value = "West"
            if (Random.nextBoolean()){
                currentDirection.value = "West"
                treasuresFound.value++
                currentAlert.value = "Treasure Found"
            }else{
                currentAlert.value = "Storm Ahead"
            }

        }) {
            Text("Sail West")
        }

    }

    MySpacer(18)


    Row {
        Button(onClick = {
            currentDirection.value = "North"
            if (Random.nextBoolean()){
                treasuresFound.value++
                currentAlert.value = "Treasure Found"
            }else{
                currentAlert.value = "Storm Ahead"
            }


        }) {
            Text("Sail North")
        }

        MySpacer(18)

        Button(onClick = {
            currentDirection.value = "South"
            if (Random.nextBoolean()){

                treasuresFound.value++
                currentAlert.value = "Treasure Found"
            }else{
                currentAlert.value = "Storm Ahead"
            }

        }) {
            Text("Sail South")
        }
    }

    MySpacer(i = 50)
    Text(
        text = "Alert!! ${currentAlert.value}",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold // Optional: To make the text bold
    )

}
    }


@Preview(showBackground = true)
@Composable
fun TreasureGamePreview() {
    TreasureAppTheme {
        treasureGame()
    }
}