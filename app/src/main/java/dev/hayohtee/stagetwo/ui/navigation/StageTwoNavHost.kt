package dev.hayohtee.stagetwo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.hayohtee.stagetwo.ui.PortfolioUiState
import dev.hayohtee.stagetwo.ui.PortfolioViewModel
import dev.hayohtee.stagetwo.ui.screen.edit.EditScreen
import dev.hayohtee.stagetwo.ui.screen.home.HomeScreen

@Composable
fun StageTwoNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: PortfolioViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable(route = "home") {
            HomeScreen(
                uiState = viewModel.uiState.value,
                onEditClick = { navController.navigate("edit") }
            )
        }
        composable(route = "edit") {
            val uiState: PortfolioUiState = viewModel.uiState.value

            EditScreen(
                fullName = uiState.fullName,
                onFullNameChange = viewModel::setFullName,
                jobTitle = uiState.title,
                onJobTitleChange = viewModel::setTitle,
                location = uiState.location,
                onLocationChange = viewModel::setLocation,
                emailAddress = uiState.emailAddress,
                onEmailAddressChange = viewModel::setEmailAddress,
                personalBio = uiState.personalBio,
                onPersonalBioChange = viewModel::setPersonalBio,
                slackUsername = uiState.slackUsername,
                onSlackUsernameChange = viewModel::setSlackUsername,
                githubUsername = uiState.gitHubUsername,
                onGithubUsernameChange = viewModel::setGithubUsername,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}