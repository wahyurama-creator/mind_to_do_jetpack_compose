package com.dev.id.todo_compose.ui.navigation.destionation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.dev.id.todo_compose.app.data.utils.IConstants.TASK_ARGUMENTS_KEY
import com.dev.id.todo_compose.app.data.utils.IConstants.TASK_SCREEN
import com.dev.id.todo_compose.ui.navigation.ActionNav

fun NavGraphBuilder.taskComposable(navigateToListScreen: (ActionNav) -> Unit) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENTS_KEY) {
            type = NavType.IntType
        })
    ) {

    }
}