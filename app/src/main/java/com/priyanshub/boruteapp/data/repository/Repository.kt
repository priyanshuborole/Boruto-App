package com.priyanshub.boruteapp.data.repository

import androidx.paging.PagingData
import com.priyanshub.boruteapp.domain.model.Hero
import com.priyanshub.boruteapp.domain.repository.DataStoreOperations
import com.priyanshub.boruteapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStoreOperations: DataStoreOperations,
    private val remoteDataSource: RemoteDataSource
){

    suspend fun getAllHeroes(): Flow<PagingData<Hero>>{
        return remoteDataSource.getAllHeroes()
    }

    suspend fun saveOnboardingState(completed: Boolean){
        dataStoreOperations.saveOnboardingState(completed = completed)
    }
    fun readOnboardingState(): Flow<Boolean>{
        return dataStoreOperations.readOnboardingState()
    }
}