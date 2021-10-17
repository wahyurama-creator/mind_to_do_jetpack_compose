package com.dev.id.todo_compose.app.data.model

import androidx.compose.ui.graphics.Color
import com.dev.id.todo_compose.ui.theme.HighPriorityColor
import com.dev.id.todo_compose.ui.theme.LowPriorityColor
import com.dev.id.todo_compose.ui.theme.MediumPriorityColor
import com.dev.id.todo_compose.ui.theme.NonePriorityColor

enum class Priority(val colorValue: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}