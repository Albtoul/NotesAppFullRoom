package com.example.notesappfullroom

import androidx.lifecycle.LiveData

class Notecurotin(private val NTdao :NoteDao) {
    val getNotes: LiveData<List<NoteDclass>> = NTdao.get()


        suspend fun add(note:NoteDclass){
            NTdao.add(note)
        }
    suspend fun update(note:NoteDclass){
        NTdao.update(note)
    }
    suspend fun delete(note:NoteDclass){
        NTdao.delete(note)
    }
}