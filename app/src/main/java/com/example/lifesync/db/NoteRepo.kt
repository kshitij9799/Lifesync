package com.example.lifesync.db

import androidx.lifecycle.LiveData

class NoteRepo(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = noteDao.getAll()

    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
}