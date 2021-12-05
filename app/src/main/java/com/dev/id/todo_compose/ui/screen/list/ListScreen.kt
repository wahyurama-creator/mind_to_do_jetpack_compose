package com.dev.id.todo_compose.ui.screen.list

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dev.id.todo_compose.R
import com.dev.id.todo_compose.app.data.utils.SearchAppBarState
import com.dev.id.todo_compose.ui.theme.fabBackgroundColor
import com.dev.id.todo_compose.ui.viewmodel.SharedViewModel

@ExperimentalComposeUiApi
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    viewModel: SharedViewModel
) {
    val searchAppBarState: SearchAppBarState by viewModel.searchAppBarState
    val searchTextState: String by viewModel.searchTextState

    Scaffold(
        topBar = {
            ListAppBar(
                viewModel,
                searchAppBarState,
                searchTextState
            )
        },
        content = {
            ListContent()
        },
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
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.button_add),
            tint = Color.White
        )
    }
}

@ExperimentalComposeUiApi
@Composable
@Preview
private fun ListScreenPreview() {
//    ListScreen(navigateToTaskScreen = {})
}