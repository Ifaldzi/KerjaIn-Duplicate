package com.example.kerjainprojectduplicate.ui.task

import androidx.lifecycle.*
import com.example.kerjainprojectduplicate.database.Task
import com.example.kerjainprojectduplicate.database.TaskRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    val tasks: LiveData<List<Task>> = taskRepository.sortedTasks.asLiveData()

    fun insert(task: Task) = viewModelScope.launch{
        taskRepository.insert(task)
    }
}

class TaskViewModelFactory(private val repository: TaskRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TaskViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }
}