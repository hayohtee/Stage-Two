package dev.hayohtee.stagetwo.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import dev.hayohtee.stagetwo.R
import dev.hayohtee.stagetwo.ui.PortfolioUiState
import dev.hayohtee.stagetwo.ui.getDefaultPortfolioUiState
import dev.hayohtee.stagetwo.ui.theme.StageTwoTheme

@Composable
fun HomeScreen(
    uiState: PortfolioUiState,
    onEditClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(onClick = onEditClick) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = stringResource(id = R.string.edit)
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(dimensionResource(id = R.dimen.medium_padding))
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding))
        ) {
            HeaderSection(
                fullName = uiState.fullName,
                jobTitle = uiState.title,
                location = uiState.location
            )
            AboutSection(
                personalBio = uiState.personalBio
            )
            SkillsSection()
            ContactSection(
                emailAddress = uiState.emailAddress,
                githubUsername = uiState.gitHubUsername,
                slackUsername = uiState.slackUsername
            )
        }
    }
}

@Composable
fun HeaderSection(
    fullName: String,
    jobTitle: String,
    location: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_padding)),
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = stringResource(id = R.string.profile_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.profile_image_size))
                .clip(RoundedCornerShape(10))
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.extra_small_padding))
        ) {
            Text(
                text = fullName,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = jobTitle,
                style = MaterialTheme.typography.bodyLarge
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement
                    .spacedBy(dimensionResource(id = R.dimen.extra_small_padding))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.location_svgrepo_com),
                    contentDescription = stringResource(id = R.string.location),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size))
                )
                Text(
                    text = location,
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = MaterialTheme.colorScheme.onBackground.copy(
                            alpha = 0.5f
                        )
                    )
                )
            }
        }
    }
}

@Composable
fun AboutSection(personalBio: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding))
    ) {
        Text(
            text = stringResource(id = R.string.about),
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = personalBio,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillsSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding))
    ) {
        Text(
            text = stringResource(id = R.string.skills),
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )
        FlowRow(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_padding)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_padding))
        ) {
            SkillCard(
                painter = painterResource(id = R.drawable.kotlin_16_svgrepo_com),
                name = stringResource(id = R.string.kotlin)
            )
            SkillCard(
                painter = painterResource(id = R.drawable.java_logo_svgrepo_com),
                name = stringResource(id = R.string.java)
            )
            SkillCard(
                painter = painterResource(id = R.drawable.figma_svgrepo_com),
                name = stringResource(id = R.string.figma)
            )
            SkillCard(
                painter = painterResource(id = R.drawable.database_02_svgrepo_com),
                name = stringResource(id = R.string.database)
            )
        }
    }
}

@Composable
fun SkillCard(painter: Painter, name: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.clickable {},
        shape = RoundedCornerShape(10),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )

    ) {
        Column(
            modifier = Modifier.size(dimensionResource(id = R.dimen.skill_card_size)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painter,
                contentDescription = name,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.skill_icon_size))
                    .padding(bottom = dimensionResource(id = R.dimen.small_padding))
            )
            Text(
                text = name,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Composable
fun ContactSection(
    emailAddress: String,
    slackUsername: String,
    githubUsername: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding))
    ) {
        Text(
            text = stringResource(id = R.string.contact),
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )
        ContactItem(
            painter = painterResource(id = R.drawable.email_1_svgrepo_com),
            contentDescription = stringResource(id = R.string.email),
            value = emailAddress
        )
        ContactItem(
            painter = painterResource(id = R.drawable.github_svgrepo_com),
            contentDescription = stringResource(id = R.string.github),
            value = githubUsername
        )
        ContactItem(
            painter = painterResource(id = R.drawable.slack_fill_svgrepo_com),
            contentDescription = stringResource(id = R.string.slack),
            value = slackUsername
        )
    }
}

@Composable
fun ContactItem(
    painter: Painter,
    contentDescription: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement
            .spacedBy(dimensionResource(id = R.dimen.extra_small_padding)),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Icon(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier.size(dimensionResource(id = R.dimen.skill_icon_size))
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    StageTwoTheme {
        HomeScreen(
            uiState = getDefaultPortfolioUiState(),
            onEditClick = {}
        )
    }
}