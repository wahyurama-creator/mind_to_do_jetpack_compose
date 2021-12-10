package com.dev.id.todo_compose.ui.screen.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.dev.id.todo_compose.app.data.db.entity.TaskToDo
import com.dev.id.todo_compose.app.data.model.Priority
import com.dev.id.todo_compose.app.data.utils.IConstants.LARGE_PADDING
import com.dev.id.todo_compose.app.data.utils.IConstants.PRIORITY_INDICATOR
import com.dev.id.todo_compose.app.data.utils.IConstants.TASK_ITEM_ELEVATION
import com.dev.id.todo_compose.ui.theme.taskItemBackgroundColor
import com.dev.id.todo_compose.ui.theme.taskItemTextColor

@ExperimentalMaterialApi
@Composable
fun ListContent(
    tasks: List<TaskToDo>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    if (tasks.isEmpty()) {
        EmptyContent()
    } else {
        DisplayTask(
            tasks = tasks,
            navigateToTaskScreen = navigateToTaskScreen
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun DisplayTask(
    tasks: List<TaskToDo>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    LazyColumn {
        items(
            items = tasks,
            key = { task ->
                task.id
            }
        ) { task ->
            TaskItem(
                taskToDo = task,
                navigateToTaskScreen = navigateToTaskScreen
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun TaskItem(
    taskToDo: TaskToDo,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.taskItemBackgroundColor,
        shape = RectangleShape,
        elevation = TASK_ITEM_ELEVATION,
        onClick = {
            navigateToTaskScreen(taskToDo.id)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(all = LARGE_PADDING)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(8f),
                    text = taskToDo.title,
                    color = MaterialTheme.colors.taskItemTextColor,
                    maxLines = 1,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Canvas(
                        modifier = Modifier
                            .size(
                                PRIORITY_INDICATOR
                            )
                    ) {
                        drawCircle(
                            color = taskToDo.priority.colorValue
                        )
                    }
                }
            }
            Text(
                text = taskToDo.description,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colors.taskItemTextColor,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun TaskItemPreview() {
    TaskItem(
        taskToDo = TaskToDo(
            1,
            "Task Example",
            "Anything desc...",
            Priority.MEDIUM,
            "",
            false,
            ""
        ),
        navigateToTaskScreen = {}
    )
}