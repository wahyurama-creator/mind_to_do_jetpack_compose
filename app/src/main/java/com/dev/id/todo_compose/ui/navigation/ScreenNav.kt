package com.dev.id.todo_compose.ui.navigation

import androidx.navigation.NavHostController
import com.dev.id.todo_compose.app.data.utils.IConstants.LIST_SCREEN

class ScreenNav(navHostController: NavHostController) {
    val listOfAction: (ActionNav) -> Unit = { navAction ->
        navHostController.navigate("list/${navAction.name}") {
            popUpTo(LIST_SCREEN) {
                inclusive = true
            }
        }
    }
}