package com.example.unit_converter

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle

@Composable
fun homescreen(go_to_main_screen:()->Unit){
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Welcome to the Unit converter APP",
            fontSize = 30.sp, // Adjust this value to make the text bigger or smaller
            fontWeight = FontWeight.Bold, // Optional: Makes the text bold
            color = Color.Black, // Optional: Set the text color
            style = androidx.compose.ui.text.TextStyle(
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.5.sp
            ) // Additional text styling
            , textAlign = TextAlign.Center

        )

        Button(onClick = { go_to_main_screen()}) {
            Text("Get started ")

        }

    }
}