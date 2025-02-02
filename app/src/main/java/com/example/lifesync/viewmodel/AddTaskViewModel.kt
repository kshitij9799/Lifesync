package com.example.lifesync.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lifesync.db.User
import com.example.lifesync.db.UserDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val userDao: UserDao
) : ViewModel() {
    fun insertUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.insert(user)
        }
    }
}