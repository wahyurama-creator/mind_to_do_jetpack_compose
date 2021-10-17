package com.dev.id.todo_compose.data.db.dao

import androidx.room.*
import com.dev.id.todo_compose.data.entity.TaskToDo
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskToDoDao {
    @Query("SELECT * FROM task_todo_table ORDER BY id ASC")
    fun getAllToDoTasks(): Flow<List<TaskToDo>>

    @Query("SELECT * FROM task_todo_table WHERE id = :taskId")
    fun getSelectedTask(taskId: Int): Flow<TaskToDo>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addToDoTask(task: TaskToDo)

    @Update
    suspend fun updateToDoTask(task: TaskToDo)

    @Delete
    suspend fun deleteToDoTask(task: TaskToDo)

    @Query("DELETE FROM task_todo_table")
    suspend fun deleteAllTask()

    @Query("SELECT * FROM task_todo_table WHERE title LIKE :query OR description LIKE :query")
    fun searchTasks(query: String): Flow<List<TaskToDo>>

    @Query("SELECT * FROM task_todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowerPriority(): Flow<List<TaskToDo>>

    @Query("SELECT * FROM task_todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHigherPriority(): Flow<List<TaskToDo>>
}