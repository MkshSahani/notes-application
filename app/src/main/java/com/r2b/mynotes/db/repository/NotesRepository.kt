package com.r2b.mynotes.db.repository

import com.r2b.mynotes.db.dao.NoteEntityDao
import com.r2b.mynotes.db.entities.Note
import kotlinx.coroutines.flow.Flow

class NotesRepository(val noteEntityDao: NoteEntityDao) {

    suspend fun addNote(note: Note) {
        this.noteEntityDao.insertNotesEntity(note)
    }

    fun getNotes() : Flow<List<Note>> {
        return this.noteEntityDao.getNotesEntities()
    }

    suspend fun updateNote(note: Note) {
        this.noteEntityDao.updateNotesEntity(note)
    }

    suspend fun deleteNote(note: Note) {
        this.noteEntityDao.deleteNote(note)
    }

}