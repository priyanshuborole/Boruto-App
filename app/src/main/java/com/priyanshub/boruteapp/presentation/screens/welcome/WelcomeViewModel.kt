package com.priyanshub.boruteapp.presentation.screens.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyanshub.boruteapp.domain.usecases.onboarding.OnboardingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val useCases: OnboardingUseCases
): ViewModel() {

    fun saveOnboardingState(completed: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        useCases.saveOnboardingUseCase(completed = completed)
    }

   // fun readOnboardingState(): Flow<Boolean>
}