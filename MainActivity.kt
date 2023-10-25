package com.juagsa.examenandroid.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}
@Composable
fun MyApp() {
    var ronda by remember { mutableStateOf(1) }
    var buttonText by remember { mutableStateOf("Start") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Botón "Ronda" en la parte superior
        Button(
            onClick = {
                ronda++
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(if (ronda > 10) Color.Red else Color.Green),
            colors = ButtonDefaults.buttonColors(contentColor = Color.White)
        ) {
            Text(text = "Ronda")
        }

        // Cuatro botones de colores en el medio
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val buttonColors = listOf(Color.Blue, Color.Green, Color.Red, Color.Yellow)
            for (i in 0 until 4) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .size(80.dp)
                        .background(buttonColors[i]),
                    colors = ButtonDefaults.buttonColors(contentColor = Color.White)
                ) {
                    Text(text = "Botón ${i + 1}")
                }
            }
        }

        // Botones "Start" y "Sumar 1 a Ronda" en la parte inferior
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    ronda = 1
                    buttonText = "Start"
                },
                modifier = Modifier
                    .size(120.dp)
                    .background(Color.Gray),
                colors = ButtonDefaults.buttonColors(contentColor = Color.White)
            ) {
                Text(text = buttonText)
            }

            Button(
                onClick = {
                    ronda++
                },
                modifier = Modifier
                    .size(120.dp)
                    .background(Color.Cyan),
                colors = ButtonDefaults.buttonColors(contentColor = Color.White)
            ) {
                Text(text = "Sumar 1 a Ronda")
            }
        }
    }
}
