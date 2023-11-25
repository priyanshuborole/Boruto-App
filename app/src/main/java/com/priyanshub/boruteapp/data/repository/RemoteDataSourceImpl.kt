package com.priyanshub.boruteapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.priyanshub.boruteapp.data.local.BorutoDatabase
import com.priyanshub.boruteapp.data.paging.HeroRemoteMediator
import com.priyanshub.boruteapp.data.remote.BorutoApi
import com.priyanshub.boruteapp.domain.model.Hero
import com.priyanshub.boruteapp.domain.repository.RemoteDataSource
import com.priyanshub.boruteapp.utils.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImpl(
    private val borutoApi: BorutoApi,
    private val borutoDatabase: BorutoDatabase
): RemoteDataSource {

    private val heroDao = borutoDatabase.heroDao()
    @OptIn(ExperimentalPagingApi::class)
    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = {
            heroDao.getAllHeroes()
        }
        return Pager(
            config = PagingConfig(ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(borutoApi,borutoDatabase),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }
}