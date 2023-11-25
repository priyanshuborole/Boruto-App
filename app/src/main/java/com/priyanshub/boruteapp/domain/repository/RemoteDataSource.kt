package com.priyanshub.boruteapp.domain.repository

import androidx.paging.PagingData
import com.priyanshub.boruteapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(): Flow<PagingData<Hero>>
}