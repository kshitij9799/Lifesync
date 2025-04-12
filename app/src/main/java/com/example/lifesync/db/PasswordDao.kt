package com.example.lifesync.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface PasswordDao {
    @Insert
    fun insert(password: Password)
}