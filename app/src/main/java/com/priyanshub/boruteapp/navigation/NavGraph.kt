package com.priyanshub.boruteapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.priyanshub.boruteapp.presentation.screens.home.HomeScreen
import com.priyanshub.boruteapp.presentation.screens.welcome.WelcomeScreen
import com.priyanshub.boruteapp.utils.Constants.DETAILS_ARGUMENT_KEY


@Composable
fun SetupNavGraph(navHostController: NavHostController, startDestination: String) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Welcome.route){
            WelcomeScreen(navController = navHostController)
        }
        composable(route = Screen.Home.route){
            HomeScreen(navHostController = navHostController)
        }
        composable(route = Screen.Search.route){

        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY){
                type = NavType.IntType
            })
        ){

        }
    }
}