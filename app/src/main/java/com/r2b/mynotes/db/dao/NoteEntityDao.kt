package com.r2b.mynotes.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.r2b.mynotes.db.entities.Note
import kotlinx.coroutines.flow.Flow


@Dao
abstract class NoteEntityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insertNotesEntity(noteEntity: Note)

    @Query("SELECT * FROM `notes` LIMIT 100")
    abstract fun getNotesEntities() : Flow<List<Note>>

    @Update
    abstract suspend fun updateNotesEntity(noteEntity: Note)

    @Delete
    abstract suspend fun deleteNote(noteEntity: Note)

}