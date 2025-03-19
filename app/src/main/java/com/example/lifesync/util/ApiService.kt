package com.example.lifesync.util

import com.example.lifesync.db.Task
import com.example.lifesync.model.ForAllTask
import retrofit2.http.GET

interface ApiService {
    @GET("tasks/getTasks")
    suspend fun getTask() : List<ForAllTask>
}