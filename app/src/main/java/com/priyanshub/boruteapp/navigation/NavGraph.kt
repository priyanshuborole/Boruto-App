package com.priyanshub.boruteapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


@Composable
fun SetupNavGraph(navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route
    ){

    }
}