package com.example.notesapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notesapp.Repository.NotesRepository
import com.example.notesapp.Database.NotesDatabase
import com.example.notesapp.Model.Notes


class NotesViewModel(application: Application):AndroidViewModel(application) {

    val repository : NotesRepository

    init{
        val dao =NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)
    }

    fun addNotes(notes: Notes){
        repository.insertNotes(notes)
    }
    fun getNotes() : LiveData<List<Notes>> = repository.getAllNotes()

    fun deleteNotes(id:Int){
        repository.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        repository.updateNotes(notes)
    }
}