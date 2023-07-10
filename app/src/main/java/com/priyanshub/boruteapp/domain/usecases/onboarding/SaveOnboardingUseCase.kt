package com.priyanshub.boruteapp.domain.usecases.onboarding

import com.priyanshub.boruteapp.domain.repository.DataStoreOperations

class SaveOnboardingUseCase(
    private val dataStoreOperations: DataStoreOperations
) {
    suspend operator fun invoke(completed:Boolean){
        dataStoreOperations.saveOnboardingState(completed = completed)
    }
}