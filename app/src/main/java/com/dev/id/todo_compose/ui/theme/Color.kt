package com.dev.id.todo_compose.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

// Dark theme
val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFF9C9C9C)
val DarkGray = Color(0xFF141414)

val LowPriorityColor = Color(0xFFABDAF8)
val MediumPriorityColor = Color(0xFFFDE395)
val HighPriorityColor = Color(0xFFFF3E55)
val NonePriorityColor = Color(0xFFD8C4EA)

// TopAppBar color
val Colors.topAppBarContentColor: Color
    @Composable
    get() = if (isLight) Color.White else LightGray
val Colors.topAppBarBackground: Color
    @Composable
    get() = if (isLight) Purple500 else Color.Black

// FAB background color
val Colors.fabBackground: Color
    @Composable
    get() = if (isLight) Teal200 else Purple700