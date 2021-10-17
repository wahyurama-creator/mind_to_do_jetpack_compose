package com.dev.id.todo_compose.app.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dev.id.todo_compose.app.data.model.Priority
import kotlinx.parcelize.Parcelize

@Entity(tableName = "task_todo_table")
@Parcelize
data class TaskToDo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "priority")
    val priority: Priority,

    @ColumnInfo(name = "created_at")
    val createdAt: String,

    @ColumnInfo(name = "is_remind")
    val isRemind: Boolean = false,

    @ColumnInfo(name = "reminder_at")
    val reminderAt: String,
) : Parcelable
