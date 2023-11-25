package com.priyanshub.boruteapp.domain.usecases.heroes

import androidx.paging.PagingData
import com.priyanshub.boruteapp.domain.model.Hero
import com.priyanshub.boruteapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val remoteDataSource: RemoteDataSource
) {
    operator fun invoke(): Flow<PagingData<Hero>>{
        return remoteDataSource.getAllHeroes()
    }
}