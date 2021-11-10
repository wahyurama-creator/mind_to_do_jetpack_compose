package com.dev.id.todo_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dev.id.todo_compose.ui.navigation.SetupNavigationController
import com.dev.id.todo_compose.ui.theme.MindToDoToDoListReminderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MindToDoToDoListReminderTheme {
                navController = rememberNavController()
                SetupNavigationController(navController = navController)
            }
        }
    }
}