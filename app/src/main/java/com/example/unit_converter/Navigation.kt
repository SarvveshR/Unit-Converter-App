package com.example.unit_converter

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navcontroller:NavHostController){
    NavHost(navController = navcontroller, startDestination = "homescreen"){
        composable("homescreen") {
            homescreen(go_to_main_screen = {navcontroller.navigate("mainscreen")})
        }
        composable("mainscreen"){
            Unitconverter()
        }
    }

}