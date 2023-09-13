package dev.hayohtee.stagetwo.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.hayohtee.stagetwo.ui.navigation.StageTwoNavHost

@Composable
fun StageTwoApp() {
    StageTwoNavHost(modifier = Modifier.fillMaxSize())
}