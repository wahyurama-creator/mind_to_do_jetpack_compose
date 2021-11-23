package com.dev.id.todo_compose.ui.screen.list

import android.util.Log
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dev.id.todo_compose.R
import com.dev.id.todo_compose.app.data.model.Priority
import com.dev.id.todo_compose.app.data.utils.IConstants.DROPDOWN_MENU_ITEM
import com.dev.id.todo_compose.app.data.utils.IConstants.CLICK_EVENTS
import com.dev.id.todo_compose.ui.component.PriorityItem
import com.dev.id.todo_compose.ui.theme.topAppBarBackground
import com.dev.id.todo_compose.ui.theme.topAppBarContentColor

@Composable
fun ListAppBar() {
    DefaultAppBar(
        onSearchClicked = {},
        onSortClicked = {}
    )
}

@Composable
fun DefaultAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name_short),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        actions = {
            ListAppBarAction(onSearchClicked, onSortClicked)
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackground,
    )
}

@Composable
fun ListAppBarAction(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
) {
    SearchAction(onSearchClicked)
    SortAction(onSortClicked)
}

@Composable
fun SearchAction(onSearchClicked: () -> Unit) {
    IconButton(
        onClick = {
            onSearchClicked()

            Log.e(
                CLICK_EVENTS,
                "Search Action Clicked"
            )
        }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.button_search),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun SortAction(onSortClicked: (Priority) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val items =
        listOf(
            Priority.NONE,
            Priority.LOW,
            Priority.MEDIUM,
            Priority.HIGH
        )
    var selectedIndex by remember { mutableStateOf(0) }

    IconButton(
        onClick = {
            expanded = true

            Log.e(
                CLICK_EVENTS,
                "Sort Action Clicked"
            )
        }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_filter_list_24),
            contentDescription = stringResource(id = R.string.button_sort_priority),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }) {
            items.forEachIndexed { index, priority ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        selectedIndex = index
                        onSortClicked(priority)

                        Log.d(
                            DROPDOWN_MENU_ITEM,
                            "$DROPDOWN_MENU_ITEM : ${priority.name}"
                        )
                    }) {
                    PriorityItem(priority = priority)
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultAppBarPreview() {
    DefaultAppBar(onSearchClicked = {}, onSortClicked = {})
}
