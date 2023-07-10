package com.priyanshub.boruteapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.priyanshub.boruteapp.presentation.welcome.WelcomeScreen
import com.priyanshub.boruteapp.utils.Constants.DETAILS_ARGUMENT_KEY


@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Welcome.route
    ) {
//        composable(route = Screen.Splash.route){
//
//        }
        composable(route = Screen.Welcome.route){
            WelcomeScreen(navController = navHostController)
        }
        composable(route = Screen.Home.route){

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