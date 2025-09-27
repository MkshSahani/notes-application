package com.r2b.mynotes.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.r2b.mynotes.db.constants.DBConstants
import com.r2b.mynotes.db.dao.NoteEntityDao

object Graph {

    lateinit var database: NotesDatabase

    fun getNotesDao() : NoteEntityDao {
        return database.getNotesDao()
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, NotesDatabase::class.java, DBConstants.NOTES_DB_NAME).build()
    }


}