package com.example.lifesync.viewmodel

import android.provider.SyncStateContract.Helpers.update
import androidx.lifecycle.ViewModel
import com.example.lifesync.db.Task
import com.example.lifesync.db.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditTaskViewModel @Inject constructor(
    private val taskDao: TaskDao
) : ViewModel() {
    fun updateUser(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            taskDao.update(task)
        }
    }
}