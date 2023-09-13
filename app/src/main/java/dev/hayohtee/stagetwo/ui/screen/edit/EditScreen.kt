package dev.hayohtee.stagetwo.ui.screen.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import dev.hayohtee.stagetwo.R
import dev.hayohtee.stagetwo.ui.theme.StageTwoTheme

@Composable
fun EditScreen(
    fullName: String,
    onFullNameChange: (String) -> Unit,
    jobTitle: String,
    onJobTitleChange: (String) -> Unit,
    location: String,
    onLocationChange: (String) -> Unit,
    emailAddress: String,
    onEmailAddressChange: (String) -> Unit,
    personalBio: String,
    onPersonalBioChange: (String) -> Unit,
    slackUsername: String,
    onSlackUsernameChange: (String) -> Unit,
    githubUsername: String,
    onGithubUsernameChange: (String) -> Unit,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { EditScreenAppBar(onNavigateBack = onNavigateBack) },
        modifier = modifier
    ) { innerPadding ->
        Surface(modifier = Modifier
            .padding(innerPadding)
            .verticalScroll(rememberScrollState())) {
            Column(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.medium_padding)),
                verticalArrangement = Arrangement
                    .spacedBy(dimensionResource(id = R.dimen.medium_padding))
            ) {
                TextFields(
                    fullName = fullName,
                    onFullNameChange = onFullNameChange,
                    jobTitle = jobTitle,
                    onJobTitleChange = onJobTitleChange,
                    location = location,
                    onLocationChange = onLocationChange,
                    emailAddress = emailAddress,
                    onEmailAddressChange = onEmailAddressChange,
                    personalBio = personalBio,
                    onPersonalBioChange = onPersonalBioChange,
                    slackUsername = slackUsername,
                    onSlackUsernameChange = onSlackUsernameChange,
                    githubUsername = githubUsername,
                    onGithubUsernameChange = onGithubUsernameChange
                )
                Button(onClick = onNavigateBack, modifier = Modifier.fillMaxWidth()) {
                    Text(text = stringResource(id = R.string.submit))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreenAppBar(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.edit))
        },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = onNavigateBack) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.navigate_back)
                )
            }
        }
    )
}

@Composable
fun TextFields(
    fullName: String,
    onFullNameChange: (String) -> Unit,
    jobTitle: String,
    onJobTitleChange: (String) -> Unit,
    location: String,
    onLocationChange: (String) -> Unit,
    emailAddress: String,
    onEmailAddressChange: (String) -> Unit,
    personalBio: String,
    onPersonalBioChange: (String) -> Unit,
    slackUsername: String,
    onSlackUsernameChange: (String) -> Unit,
    githubUsername: String,
    onGithubUsernameChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement
            .spacedBy(dimensionResource(id = R.dimen.medium_padding))
    ) {
        OutlinedTextField(
            value = fullName,
            onValueChange = onFullNameChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            label = {
                Text(text = stringResource(id = R.string.full_name))
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = stringResource(id = R.string.full_name)
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )
        OutlinedTextField(
            value = jobTitle,
            onValueChange = onJobTitleChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            label = {
                Text(text = stringResource(id = R.string.job_title))
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.job_profile_svgrepo_com),
                    contentDescription = stringResource(id = R.string.job_title),
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.textfield_icon_size))
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )
        OutlinedTextField(
            value = location,
            onValueChange = onLocationChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            label = {
                Text(text = stringResource(id = R.string.location))
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = stringResource(id = R.string.location)
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )
        OutlinedTextField(
            value = emailAddress,
            onValueChange = onEmailAddressChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            label = {
                Text(text = stringResource(id = R.string.email))
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = stringResource(id = R.string.email)
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            )
        )
        OutlinedTextField(
            value = personalBio,
            onValueChange = onPersonalBioChange,
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(
                    minHeight = dimensionResource(id = R.dimen.textfield_min_height)
                ),
            singleLine = false,
            label = {
                Text(text = stringResource(id = R.string.personal_bio))
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Sentences
            )
        )
        OutlinedTextField(
            value = slackUsername,
            onValueChange = onSlackUsernameChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            label = {
                Text(text = stringResource(id = R.string.slack_username))
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.slack_fill_svgrepo_com),
                    contentDescription = stringResource(id = R.string.slack_username),
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.textfield_icon_size))
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )
        OutlinedTextField(
            value = githubUsername,
            onValueChange = onGithubUsernameChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            label = {
                Text(text = stringResource(id = R.string.github_username))
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.github_svgrepo_com),
                    contentDescription = stringResource(id = R.string.github_username),
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.textfield_icon_size))
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EditScreenPreview() {
    StageTwoTheme {
        EditScreen(
            fullName = "",
            onFullNameChange = {},
            jobTitle = "",
            onJobTitleChange = {},
            location = "",
            onLocationChange = {},
            emailAddress = "",
            onEmailAddressChange = {},
            personalBio = "",
            onPersonalBioChange = {},
            slackUsername = "",
            onSlackUsernameChange = {},
            githubUsername = "",
            onGithubUsernameChange = {},
            onNavigateBack = {}
        )
    }
}