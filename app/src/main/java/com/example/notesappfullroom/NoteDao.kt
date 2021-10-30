package com.example.notesappfullroom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) // make the process in background "mainActivity"
    suspend fun add(note:NoteDclass)

    @Query("SELECT * FROM tablenotes ORDER BY id ASC")
    fun get(): LiveData<List<NoteDclass>>

    @Delete
    suspend fun delete(note:NoteDclass)

    @Update
    suspend fun update(note: NoteDclass)


}