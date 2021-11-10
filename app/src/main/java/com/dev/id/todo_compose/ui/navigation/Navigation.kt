package com.dev.id.todo_compose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.dev.id.todo_compose.app.data.utils.IConstants.LIST_SCREEN
import com.dev.id.todo_compose.ui.navigation.destination.listComposable
import com.dev.id.todo_compose.ui.navigation.destination.taskComposable

@Composable
fun SetupNavigationController(navController: NavHostController) {
    val screen = remember(navController) {
        Screens(navController)
    }
    
    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(navigateToTaskScreen = screen.task)
        taskComposable(navigateToListScreen = screen.list)
    }
}