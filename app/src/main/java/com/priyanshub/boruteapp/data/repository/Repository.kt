package com.priyanshub.boruteapp.data.repository

import com.priyanshub.boruteapp.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStoreOperations: DataStoreOperations
){
    suspend fun saveOnboardingState(completed: Boolean){
        dataStoreOperations.saveOnboardingState(completed = completed)
    }
    fun readOnboardingState(): Flow<Boolean>{
        return dataStoreOperations.readOnboardingState()
    }
}