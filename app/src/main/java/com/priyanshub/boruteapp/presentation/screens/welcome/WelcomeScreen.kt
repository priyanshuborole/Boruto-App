package com.priyanshub.boruteapp.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.priyanshub.boruteapp.R
import com.priyanshub.boruteapp.domain.model.OnboardingPage
import com.priyanshub.boruteapp.navigation.Screen
import com.priyanshub.boruteapp.ui.theme.EXTRA_LARGE_PADDING
import com.priyanshub.boruteapp.ui.theme.PAGING_INDICATOR_SPACING
import com.priyanshub.boruteapp.ui.theme.PAGING_INDICATOR_WIDTH
import com.priyanshub.boruteapp.ui.theme.SMALL_PADDING
import com.priyanshub.boruteapp.ui.theme.activeIndicatorColor
import com.priyanshub.boruteapp.ui.theme.buttonBackgroundColor
import com.priyanshub.boruteapp.ui.theme.descriptionColor
import com.priyanshub.boruteapp.ui.theme.inactiveIndicatorColor
import com.priyanshub.boruteapp.ui.theme.titleColor
import com.priyanshub.boruteapp.ui.theme.welcomeScreenBackgroundColor
import com.priyanshub.boruteapp.utils.Constants.LAST_ON_BOARDING_PAGE
import com.priyanshub.boruteapp.utils.Constants.ON_BOARDING_PAGE_COUNT
import dagger.hilt.android.lifecycle.HiltViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(
    navController: NavHostController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
){

    val pages = listOf(
        OnboardingPage.First,
        OnboardingPage.Second,
        OnboardingPage.Third
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.welcomeScreenBackgroundColor)
    ){
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            pageCount = ON_BOARDING_PAGE_COUNT,
            verticalAlignment = Alignment.Top
        ) {pagePosition->
            PagerScreen(onboardingPage = pages[pagePosition])
        }
        
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.activeIndicatorColor,
            inactiveColor = MaterialTheme.colors.inactiveIndicatorColor,
            indicatorWidth = PAGING_INDICATOR_WIDTH,
            spacing = PAGING_INDICATOR_SPACING,
            pageCount = ON_BOARDING_PAGE_COUNT)

        FinishButton(modifier = Modifier.weight(1f), pagerState = pagerState) {
            navController.popBackStack()
            navController.navigate(Screen.Home.route)
            welcomeViewModel.saveOnboardingState(true)
        }
    }
    

}

@Composable
fun PagerScreen(onboardingPage: OnboardingPage){

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onboardingPage.image),
            contentDescription = stringResource(R.string.onboarding_page)
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = onboardingPage.title,
            color = MaterialTheme.colors.titleColor,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onboardingPage.description,
            color = MaterialTheme.colors.descriptionColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FinishButton(modifier: Modifier,pagerState: PagerState, onClick: () -> Unit){
    Row(
        modifier = modifier.padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = modifier.fillMaxWidth(),
            visible = pagerState.currentPage == LAST_ON_BOARDING_PAGE
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.buttonBackgroundColor,
                    contentColor = Color.White
                ),
                onClick = onClick
            ) {
                Text(text = "Finish")
            }
        }
    }
}
@Composable
@Preview(showBackground = true)
fun FirstOnBoardingScreenPreview(){
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onboardingPage = OnboardingPage.First)
    }
}
@Composable
@Preview(showBackground = true)
fun SecondOnBoardingScreenPreview(){
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onboardingPage = OnboardingPage.Second)
    }
}
@Composable
@Preview(showBackground = true)
fun ThirdOnBoardingScreenPreview(){
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onboardingPage = OnboardingPage.Third)
    }
}