package com.priyanshub.boruteapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.priyanshub.boruteapp.presentation.common.ListContent
import com.priyanshub.boruteapp.presentation.components.RatingWidget
import com.priyanshub.boruteapp.ui.theme.LARGE_PADDING


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
){

    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()
    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})
        },
        content = {
            ListContent(allHeroes,navHostController)
        }
    )
}