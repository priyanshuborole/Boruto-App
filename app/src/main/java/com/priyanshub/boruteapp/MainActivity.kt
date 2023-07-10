package com.priyanshub.boruteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.priyanshub.boruteapp.domain.usecases.onboarding.OnboardingUseCases
import com.priyanshub.boruteapp.navigation.Screen
import com.priyanshub.boruteapp.navigation.SetupNavGraph
import com.priyanshub.boruteapp.ui.theme.BoruteAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    private var completed = false
    @Inject
    lateinit var useCases: OnboardingUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            BoruteAppTheme {
                navHostController = rememberNavController()
                SetupNavGraph(
                    navHostController = navHostController,
                    startDestination = if (completed) Screen.Home.route else Screen.Welcome.route)
            }
        }

        lifecycleScope.launch(Dispatchers.IO) {
            useCases.readOnboardingUseCase().collect{
                completed = it
            }
        }
    }
}
