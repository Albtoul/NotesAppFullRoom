package com.example.notesappfullroom

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "tablenotes")
data class NoteDclass(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val note:String

)
