package com.priyanshub.boruteapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.priyanshub.boruteapp.domain.usecases.heroes.GetAllHeroesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getAllHeroesUseCase: GetAllHeroesUseCase
): ViewModel() {

    val getAllHeroes = getAllHeroesUseCase()

}