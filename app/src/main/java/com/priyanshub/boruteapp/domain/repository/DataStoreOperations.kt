package com.priyanshub.boruteapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {

    suspend fun saveOnboardingState(completed: Boolean)
    fun readOnboardingState(): Flow<Boolean>
}