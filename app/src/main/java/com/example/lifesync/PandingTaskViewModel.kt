package com.example.lifesync

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yourpa.db.Note
import com.example.yourpa.db.NoteDB
import com.example.yourpa.db.NoteRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PandingTaskViewModel(application: Application) : ViewModel() {
    private val repository: NoteRepo
    val allNotes: LiveData<List<Note>>

    init {
        val database = NoteDB.getDatabase(application).getNoteDao()
        repository = NoteRepo(database)
        allNotes = repository.allNotes
    }

    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }
}