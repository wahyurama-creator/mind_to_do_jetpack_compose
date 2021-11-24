package com.dev.id.todo_compose.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dev.id.todo_compose.app.data.model.Priority
import com.dev.id.todo_compose.app.data.utils.IConstants.LARGE_PADDING
import com.dev.id.todo_compose.app.data.utils.IConstants.PRIORITY_INDICATOR
import com.dev.id.todo_compose.ui.theme.Typography
import java.util.*

@Composable
fun PriorityItem(priority: Priority) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Canvas(modifier = Modifier.size(PRIORITY_INDICATOR)) {
            drawCircle(color = priority.colorValue)
        }
        Spacer(modifier = Modifier.width(LARGE_PADDING))
        Text(
            text = priority.name.lowercase(Locale.getDefault())
                .replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                },
            style = Typography.subtitle1,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
@Preview
fun DefaultPreview() {
    PriorityItem(priority = Priority.HIGH)
}