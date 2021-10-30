package com.example.notesappfullroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteDclass::class], version = 1, exportSchema = false)
abstract class DB:RoomDatabase(){

    abstract fun noteDao():NoteDao
    companion object{
        @Volatile  // visiable to other thread
        private var INSTANCE :DB ?=null

        fun getDB(context: Context):DB {
            val value = INSTANCE
            if (value != null) {
                return value
            }
            synchronized(this){   //protection from multiaple thread
                val x=Room.databaseBuilder(context.applicationContext,DB::class.java,"noteDB")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE=x
                return x

            }

        }
    }
}