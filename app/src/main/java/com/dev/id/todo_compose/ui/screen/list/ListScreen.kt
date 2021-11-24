package com.dev.id.todo_compose.ui.screen.list

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dev.id.todo_compose.R
import com.dev.id.todo_compose.ui.theme.fabBackground

@Composable
fun ListScreen(navigateToTaskScreen: (taskId: Int) -> Unit) {
    Scaffold(
        topBar = {
            ListAppBar()
        },
        content = {},
        floatingActionButton = {
            ListFAB(onFABClicked = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFAB(
    onFABClicked: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFABClicked(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackground
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.button_add),
            tint = Color.White
        )
    }
}

@Composable
@Preview
private fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {})
}