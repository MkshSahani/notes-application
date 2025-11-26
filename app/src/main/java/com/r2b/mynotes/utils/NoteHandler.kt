package com.r2b.mynotes.utils

import com.r2b.mynotes.constants.NoteAppConstants
import com.r2b.mynotes.db.repository.NotesRepository
import com.r2b.mynotes.viewmodel.NewNoteInfoViewModel
import kotlinx.coroutines.CoroutineScope

class NoteHandler(val notesViewModel: NewNoteInfoViewModel) {

    companion object {
        var TAG: String = NoteAppConstants.TAG + NoteHandler.javaClass.simpleName
    }

    fun addNewNote(noteTitle: String, noteType: String, noteDescription: String, noteInfo: String) {

    }

}