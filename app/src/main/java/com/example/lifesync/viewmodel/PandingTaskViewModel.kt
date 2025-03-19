package com.example.lifesync.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lifesync.db.Task
import com.example.lifesync.db.TaskDao
import com.example.lifesync.model.ForAllTask
import com.example.lifesync.util.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PandingTaskViewModel @Inject constructor(
    private val taskDao: TaskDao,
    private val apiService: ApiService
) : ViewModel() {
    val user: LiveData<List<Task>> = taskDao.getAllTasks()

    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Api exception: ${exception.message}")
        exception.printStackTrace()
    }

    fun deleteUser(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            taskDao.delete(task)
        }
    }

    var _task = MutableLiveData<List<Task>>()
    val task: LiveData<List<Task>> = _task
    suspend fun getOnlineTask(): List<ForAllTask> {
        val task = CoroutineScope(Dispatchers.IO + exceptionHandler).async {
            apiService.getTask()
        }.await()
        return task
    }

}