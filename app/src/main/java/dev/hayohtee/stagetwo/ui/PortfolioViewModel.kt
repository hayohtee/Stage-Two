package dev.hayohtee.stagetwo.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PortfolioViewModel : ViewModel() {
    var uiState: MutableState<PortfolioUiState> = mutableStateOf(getDefaultPortfolioUiState())
        private set

    fun setFullName(fullName: String) {
        uiState.value = uiState.value.copy(
            fullName = fullName
        )
    }

    fun setSlackUsername(slackUsername: String) {
        uiState.value = uiState.value.copy(
            slackUsername = slackUsername
        )
    }

    fun setGithubUsername(gitHubUsername: String) {
        uiState.value = uiState.value.copy(
            gitHubUsername = gitHubUsername
        )
    }

    fun setLocation(location: String) {
        uiState.value = uiState.value.copy(
            location = location
        )
    }

    fun setPersonalBio(personalBio: String) {
        uiState.value = uiState.value.copy(
            personalBio = personalBio
        )
    }

    fun setEmailAddress(emailAddress: String) {
        uiState.value = uiState.value.copy(
            emailAddress = emailAddress
        )
    }

    fun setTitle(title: String) {
        uiState.value = uiState.value.copy(
            title = title
        )
    }

}
