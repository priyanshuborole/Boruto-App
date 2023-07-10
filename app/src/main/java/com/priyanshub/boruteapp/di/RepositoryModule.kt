package com.priyanshub.boruteapp.di

import android.content.Context
import com.priyanshub.boruteapp.data.repository.DataStoreOperationsImpl
import com.priyanshub.boruteapp.domain.model.OnboardingPage
import com.priyanshub.boruteapp.domain.repository.DataStoreOperations
import com.priyanshub.boruteapp.domain.usecases.onboarding.OnboardingUseCases
import com.priyanshub.boruteapp.domain.usecases.onboarding.ReadOnboardingUseCase
import com.priyanshub.boruteapp.domain.usecases.onboarding.SaveOnboardingUseCase
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
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideOnboardingUseCases(dataStoreOperations: DataStoreOperations):OnboardingUseCases{
        return OnboardingUseCases(
            saveOnboardingUseCase = SaveOnboardingUseCase(dataStoreOperations),
            readOnboardingUseCase = ReadOnboardingUseCase(dataStoreOperations)
        )
    }

}