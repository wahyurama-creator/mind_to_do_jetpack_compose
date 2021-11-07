package com.dev.id.todo_compose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.id.todo_compose.app.data.db.entity.TaskToDo
import com.dev.id.todo_compose.app.data.repository.TaskToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val taskToDoRepository: TaskToDoRepository) :
    ViewModel() {

    // Immutable variable
    private val _allToDoTask = MutableStateFlow<List<TaskToDo>>(
        emptyList()
    )
    val allToDoTask: StateFlow<List<TaskToDo>> = _allToDoTask

    fun getAllToDoTask() {
        viewModelScope.launch(Dispatchers.IO) {
            taskToDoRepository.getAllToDoTask.collect {
                _allToDoTask.value = it
            }
        }
    }
}