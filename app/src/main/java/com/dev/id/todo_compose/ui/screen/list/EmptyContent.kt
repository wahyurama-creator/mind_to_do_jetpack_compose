package com.dev.id.todo_compose.ui.screen.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.dev.id.todo_compose.R
import com.dev.id.todo_compose.ui.theme.MediumGray

@Composable
fun EmptyContent() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.empty_state
        )
    )
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
            .background(color = MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(250.dp)
        )
        Text(
            text = stringResource(id = R.string.text_empty_content),
            color = MediumGray,
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun EmptyContentPreview() {
    EmptyContent()
}