package com.priyanshub.boruteapp.domain.usecases.onboarding

import com.priyanshub.boruteapp.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow

class ReadOnboardingUseCase(
    private val dataStoreOperations: DataStoreOperations
) {
    operator fun invoke(): Flow<Boolean> {
        return dataStoreOperations.readOnboardingState()
    }
}