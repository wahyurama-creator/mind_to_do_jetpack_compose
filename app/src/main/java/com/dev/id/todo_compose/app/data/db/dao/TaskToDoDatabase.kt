package com.dev.id.todo_compose.app.data.db.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dev.id.todo_compose.app.data.db.entity.TaskToDo

@Database(entities = [TaskToDo::class], version = 1, exportSchema = false)
abstract class TaskToDoDatabase : RoomDatabase(){
    abstract fun taskToDoDao(): TaskToDoDao

    companion object {

    }
}