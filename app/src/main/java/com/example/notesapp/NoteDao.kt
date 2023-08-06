package com.example.notesapp

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface NoteDao {
     @Insert(onConflict = OnConflictStrategy.IGNORE)
     // insert delete opertion are I/O operation It will make your app laggy if work on main thread
     // suspend is coroutine which enable function to run on background thread
     // either func called by background thread or they will call by suspend fun only
     suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)
    @Query("Select * from notes_table order by id ASC")
    // Creating livedata so that activity knows about all update
    // Activity will be observer
    fun getAllNote(): LiveData<List<Note>>
}