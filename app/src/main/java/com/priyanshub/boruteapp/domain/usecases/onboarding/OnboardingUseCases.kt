package com.priyanshub.boruteapp.domain.usecases.onboarding

import com.priyanshub.boruteapp.domain.usecases.onboarding.ReadOnboardingUseCase
import com.priyanshub.boruteapp.domain.usecases.onboarding.SaveOnboardingUseCase

data class OnboardingUseCases(
    val saveOnboardingUseCase: SaveOnboardingUseCase,
    val readOnboardingUseCase: ReadOnboardingUseCase
)
