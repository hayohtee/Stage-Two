package dev.hayohtee.stagetwo.ui

data class PortfolioUiState(
    val fullName: String,
    val slackUsername: String,
    val emailAddress: String,
    val gitHubUsername: String,
    val location: String,
    val personalBio: String,
    val title: String
)

fun getDefaultPortfolioUiState(): PortfolioUiState {
    return PortfolioUiState(
        fullName = "Olamilekan Akintilebo",
        slackUsername = "Olamilekan Akintilebo",
        emailAddress = "olamilekanakintilebo@gmail.com",
        gitHubUsername = "hayohtee",
        location = "Ile-Ife, Osun State, Nigeria",
        title = "Android developer",
        personalBio = "Goal-oriented and highly motivated developer with a strong " +
                "proficiency in Kotlin and Java. Passionate about creating innovative " +
                "and user-friendly applications, developing robust code and implementing " +
                "best practices for efficient app performance. "
    )
}