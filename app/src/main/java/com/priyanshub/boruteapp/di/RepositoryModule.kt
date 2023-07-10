package com.priyanshub.boruteapp.di

import android.content.Context
import com.priyanshub.boruteapp.data.prefs.DataStoreOperationsImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperationsImpl{
        return DataStoreOperationsImpl(context = context)
    }

}