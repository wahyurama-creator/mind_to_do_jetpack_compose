package com.dev.id.todo_compose.app.di

import android.content.Context
import androidx.room.Room
import com.dev.id.todo_compose.app.data.db.dao.TaskToDoDatabase
import com.dev.id.todo_compose.app.data.utils.IConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            TaskToDoDatabase::class.java,
            IConstants.DATABASE_NAME
        ).build()

    fun provideDao(db: TaskToDoDatabase) = db.taskToDoDao()

}