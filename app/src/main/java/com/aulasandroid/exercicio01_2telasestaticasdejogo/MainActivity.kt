package com.aulasandroid.exercicio01_2telasestaticasdejogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.exercicio01_2telasestaticasdejogo.ui.theme.Exercicio012TelasEstaticasDeJogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Exercicio012TelasEstaticasDeJogoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    HomeScreen(
//                        modifier = Modifier
//                            .padding(innerPadding)
//                            .fillMaxSize()
//                            .background(color = Color(0, 0, 0, 255))
//                    )
                    GameOverScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(color = Color.Black)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            Row ( // Barra superior
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "SCORE: 0050", color = Color.White)
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "LIVES:", color = Color.White)
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AndroidEnemy(color = Color.Green, modifier = Modifier.size(10.dp))
                        AndroidEnemy(color = Color.Green, modifier = Modifier.size(10.dp))
                        AndroidEnemy(color = Color.Green, modifier = Modifier.size(10.dp))
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                AndroidEnemy(color = Color.Green, modifier = Modifier.size(50.dp))
                AndroidEnemy(color = Color.Red, modifier = Modifier.size(50.dp))
                AndroidEnemy(color = Color.Blue, modifier = Modifier.size(50.dp))
                AndroidEnemy(color = Color.Yellow, modifier = Modifier.size(50.dp))
                AndroidEnemy(color = Color.Green, modifier = Modifier.size(50.dp))
            }
        }
        Column(
            modifier = Modifier
                .padding(0.dp, 70.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.outline_all_inclusive_24),
                colorFilter = ColorFilter.tint(color = Color.White),
                contentDescription = "Infinite Icon",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp),
                alignment = Alignment.Center
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "PRESS START",
                    color = Color.White,
                    fontSize = 25.sp
                )
            }
        }
    }
}

@Composable
fun GameOverScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            AndroidEnemy(color = Color.Green, modifier = Modifier.size(50.dp))
            AndroidEnemy(color = Color.Red, modifier = Modifier.size(50.dp))
            AndroidEnemy(color = Color.Blue, modifier = Modifier.size(50.dp))
            AndroidEnemy(color = Color.Yellow, modifier = Modifier.size(50.dp))
        }
        Text(
            text = "Game Over",
            color = Color.White,
            fontSize = 60.sp,
            fontWeight = W600
        )
    }
}

@Composable
fun AndroidEnemy(
    color: Color,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.outline_android_24),
        colorFilter = ColorFilter.tint(color = color),
        contentDescription = "Android Enemy"
    )
}
