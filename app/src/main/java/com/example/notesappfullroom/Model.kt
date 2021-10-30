package com.example.notesappfullroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Model(app:Application): AndroidViewModel(app) {
    private val cor: Notecurotin
    private val  notes: LiveData<List<NoteDclass>>

    init {
        val notedao = DB.getDB(app).noteDao()
        cor= Notecurotin(notedao)
        notes= cor.getNotes
    }

    fun getNotes(): LiveData<List<NoteDclass>>{
        return notes
    }

    fun addNote(noteText: String){
        CoroutineScope(Dispatchers.IO).launch {
            cor.add(NoteDclass(0, noteText))
        }
    }

    fun editNote(noteID: Int, noteText: String){
        CoroutineScope(Dispatchers.IO).launch {
            cor.update(NoteDclass(noteID,noteText))
        }
    }

    fun deleteNote(noteID: Int){
        CoroutineScope(Dispatchers.IO).launch {
            cor.delete(NoteDclass(noteID,""))
        }
    }


}