package com.example.lifesync.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lifesync.db.Task
import com.example.lifesync.db.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val taskDao: TaskDao
) : ViewModel() {
    fun insertUser(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            taskDao.insert(task)
        }
    }
}