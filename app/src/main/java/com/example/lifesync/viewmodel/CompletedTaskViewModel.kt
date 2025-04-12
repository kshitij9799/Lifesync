package com.example.lifesync.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lifesync.db.Task
import com.example.lifesync.db.TaskDao
import com.example.lifesync.util.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CompletedTaskViewModel@Inject constructor(
    taskDao: TaskDao,
    private val apiService: ApiService
) : ViewModel() {
    val allCompletedTask:LiveData<List<Task>> = taskDao.getAllCompletedTasks()
    
}