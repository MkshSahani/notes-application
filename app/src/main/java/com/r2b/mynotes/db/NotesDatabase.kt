package com.r2b.mynotes.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.r2b.mynotes.db.dao.NoteEntityDao
import com.r2b.mynotes.db.entities.Note

@Database(
    entities = [
        Note::class
    ],
    version = 1,
    exportSchema = false
)
abstract class NotesDatabase: RoomDatabase() {

    abstract fun getNotesDao() : NoteEntityDao

}