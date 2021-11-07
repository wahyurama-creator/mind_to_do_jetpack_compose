package com.dev.id.todo_compose.app.di

import android.content.Context
import androidx.room.Room
import com.dev.id.todo_compose.app.data.db.dao.TaskToDoDatabase
import com.dev.id.todo_compose.app.data.utils.IConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            TaskToDoDatabase::class.java,
            IConstants.DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun provideDao(db: TaskToDoDatabase) = db.taskToDoDao()

}