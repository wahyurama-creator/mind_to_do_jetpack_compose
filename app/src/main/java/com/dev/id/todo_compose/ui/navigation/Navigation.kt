package com.dev.id.todo_compose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.dev.id.todo_compose.app.data.utils.IConstants.LIST_SCREEN
import com.dev.id.todo_compose.ui.navigation.destination.listComposable
import com.dev.id.todo_compose.ui.navigation.destination.taskComposable
import com.dev.id.todo_compose.ui.viewmodel.SharedViewModel

@ExperimentalComposeUiApi
@Composable
fun SetupNavigationController(
    navController: NavHostController,
    viewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateToTaskScreen = screen.task,
            viewModel = viewModel
        )
        taskComposable(navigateToListScreen = screen.list)
    }
}