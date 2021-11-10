package com.dev.id.todo_compose.ui.navigation

import androidx.navigation.NavHostController
import com.dev.id.todo_compose.app.data.utils.IConstants.LIST_SCREEN

class Screens(navHostController: NavHostController) {
    val list: (ActionNav) -> Unit = { navAction ->
        navHostController.navigate("list/${navAction.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navHostController.navigate("task/$taskId")
    }

}