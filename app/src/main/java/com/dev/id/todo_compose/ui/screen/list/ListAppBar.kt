package com.dev.id.todo_compose.ui.screen.list

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.dev.id.todo_compose.R
import com.dev.id.todo_compose.app.data.model.Priority
import com.dev.id.todo_compose.app.data.utils.IConstants.CLICK_EVENTS
import com.dev.id.todo_compose.app.data.utils.IConstants.DROPDOWN_MENU_ITEM
import com.dev.id.todo_compose.app.data.utils.IConstants.LARGE_PADDING
import com.dev.id.todo_compose.app.data.utils.IConstants.TOP_APP_BAR_HEIGHT
import com.dev.id.todo_compose.ui.component.PriorityItem
import com.dev.id.todo_compose.ui.theme.Typography
import com.dev.id.todo_compose.ui.theme.topAppBarBackground
import com.dev.id.todo_compose.ui.theme.topAppBarContentColor

@ExperimentalComposeUiApi
@Composable
fun ListAppBar() {
    DefaultAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}

@ExperimentalComposeUiApi
@Composable
fun DefaultAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name_short),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        actions = {
            SearchAppBarView(
                text = "",
                onTextChange = {},
                onCloseClicked = { },
                onSearchClicked = {}
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackground,
    )
}

@Composable
fun ListAppBarAction(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit,
) {
    SearchAction(onSearchClicked)
    SortAction(onSortClicked)
    DeleteAction(onDeleteClicked)
}

@Composable
fun SearchAction(onSearchClicked: () -> Unit) {
    IconButton(
        onClick = {
            onSearchClicked()

            Log.e(CLICK_EVENTS, "Search action clicked")
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
            Priority.LOW,
            Priority.HIGH,
            Priority.NONE
        )
    var selectedIndex by remember { mutableStateOf(0) }

    IconButton(
        onClick = {
            expanded = true

            Log.e(CLICK_EVENTS, "Sort action clicked")
        }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_filter_list_24),
            contentDescription = stringResource(id = R.string.button_sort_priority),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false

                Log.e(CLICK_EVENTS, "Dropdown menu closed")
            }) {
            items.forEachIndexed { index, priority ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        selectedIndex = index
                        onSortClicked(priority)

                        Log.e(
                            DROPDOWN_MENU_ITEM,
                            "${priority.name} clicked"
                        )
                    }) {
                    PriorityItem(priority = priority)
                }
            }
        }
    }
}

@Composable
fun DeleteAction(onDeleteClicked: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = {
        expanded = true

        Log.e(CLICK_EVENTS, "Delete action clicked")
    }) {
        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = stringResource(id = R.string.button_delete_all),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false

                Log.e(CLICK_EVENTS, "Dropdown menu closed")
            }) {
            DropdownMenuItem(onClick = {
                expanded = false
                onDeleteClicked()

                Log.e(
                    DROPDOWN_MENU_ITEM,
                    "Delete All"
                )
            }) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.text_delete_all),
                        style = Typography.subtitle1,
                        color = MaterialTheme.colors.onSurface
                    )
                    Spacer(modifier = Modifier.width(LARGE_PADDING))
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.button_delete_all),
                        tint = MaterialTheme.colors.error,
                    )
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun SearchAppBarView(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.topAppBarBackground
    ) {
        TextField(
            value = text,
            onValueChange = { onTextChange(it) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.text_search_placeholder),
                    color = Color.White,
                    modifier = Modifier.alpha(ContentAlpha.disabled)
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.topAppBarContentColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.disabled),
                    onClick = { onSearchClicked(text) }

                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(id = R.string.button_search),
                        tint = MaterialTheme.colors.topAppBarContentColor
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.disabled),
                    onClick = { onCloseClicked() }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.button_search),
                        tint = MaterialTheme.colors.topAppBarContentColor
                    )
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = { onSearchClicked(text) },
                onDone = { keyboardController?.hide() }
            ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = MaterialTheme.colors.topAppBarContentColor,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent,
            )
        )
    }
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun DefaultAppBarPreview() {
    DefaultAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {})
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun SearchAppBarPreview() {
    SearchAppBarView(
        text = stringResource(id = R.string.text_search_placeholder),
        onTextChange = {},
        onCloseClicked = {},
        onSearchClicked = {})
}