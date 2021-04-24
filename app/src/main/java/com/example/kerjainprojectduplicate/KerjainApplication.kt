package com.example.kerjainprojectduplicate

import android.app.Application
import com.example.kerjainprojectduplicate.database.TaskRepository
import com.example.kerjainprojectduplicate.database.TaskRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class KerjainApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { TaskRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { TaskRepository(database.taskDao()) }
}