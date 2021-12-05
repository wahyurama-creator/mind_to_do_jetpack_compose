package com.dev.id.todo_compose.app.data.utils

import androidx.compose.ui.unit.dp

object IConstants {
    // Database
    const val DATABASE_NAME = "task_todo_database"
    const val DATABASE_TABLE = "task_todo_table"

    // Nav Action
    const val LIST_SCREEN = "list/{action}"
    const val TASK_SCREEN = "list/{taskId}"
    const val LIST_ARGUMENTS_KEY = "action"
    const val TASK_ARGUMENTS_KEY = "taskId"

    // Dimens
    val LARGE_PADDING = 12.dp
    val MEDIUM_PADDING = 8.dp
    val SMALL_PADDING = 6.dp

    val PRIORITY_INDICATOR = 16.dp
    val TOP_APP_BAR_HEIGHT = 56.dp

    val TASK_ITEM_ELEVATION = 2.dp

    // Log Tags
    const val CLICK_EVENTS = "Click Event"
    const val DROPDOWN_MENU_ITEM = "Dropdown Item"
}