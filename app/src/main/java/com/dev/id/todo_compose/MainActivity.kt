package com.dev.id.todo_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dev.id.todo_compose.ui.navigation.SetupNavigationController
import com.dev.id.todo_compose.ui.theme.MindToDoToDoListReminderTheme
import com.dev.id.todo_compose.ui.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MindToDoToDoListReminderTheme {
                navController = rememberNavController()
                SetupNavigationController(
                    navController = navController,
                    viewModel = sharedViewModel
                )
            }
        }
    }
}