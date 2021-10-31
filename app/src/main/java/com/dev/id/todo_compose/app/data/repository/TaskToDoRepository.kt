package com.dev.id.todo_compose.app.data.repository

import com.dev.id.todo_compose.app.data.db.dao.TaskToDoDao
import com.dev.id.todo_compose.app.data.db.entity.TaskToDo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskToDoRepository @Inject constructor(private val taskToDoDao: TaskToDoDao) {
    val getAllToDoTask: Flow<List<TaskToDo>> =
        taskToDoDao.getAllToDoTasks()
    val sortByLowerPriority: Flow<List<TaskToDo>> =
        taskToDoDao.sortByLowerPriority()
    val sortByHigherPriority: Flow<List<TaskToDo>> =
        taskToDoDao.sortByHigherPriority()

    fun getSelectedTask(taskId: Int) =
        taskToDoDao.getSelectedTask(taskId)

    suspend fun addTask(task: TaskToDo) =
        taskToDoDao.addToDoTask(task)

    suspend fun updateTask(task: TaskToDo) =
        taskToDoDao.updateToDoTask(task)

    suspend fun deleteToDoTask(task: TaskToDo) =
        taskToDoDao.deleteToDoTask(task)

    suspend fun deleteAllTask() =
        taskToDoDao.deleteAllTask()

    fun searchTask(query: String): Flow<List<TaskToDo>> =
        taskToDoDao.searchTasks(query)

}