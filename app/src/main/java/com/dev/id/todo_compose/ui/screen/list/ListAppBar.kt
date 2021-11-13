package com.dev.id.todo_compose.ui.screen.list

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dev.id.todo_compose.R
import com.dev.id.todo_compose.ui.theme.topAppBarContentColor
import com.dev.id.todo_compose.ui.theme.topAppBarBackground

@Composable
fun ListAppBar() {

}

@Composable
fun DefaultAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackground,
    )
}

@Preview
@Composable
fun DefaultAppBarPreview() {
    DefaultAppBar()
}
