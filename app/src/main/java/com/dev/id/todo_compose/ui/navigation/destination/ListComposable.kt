package com.dev.id.todo_compose.ui.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.dev.id.todo_compose.app.data.utils.IConstants.LIST_ARGUMENTS_KEY
import com.dev.id.todo_compose.app.data.utils.IConstants.LIST_SCREEN
import com.dev.id.todo_compose.ui.screen.list.ListScreen

fun NavGraphBuilder.listComposable(navigateToTaskScreen: (Int) -> Unit) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENTS_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(navigateToTaskScreen = navigateToTaskScreen)
    }
}
