package com.r2b.mynotes.utils

import com.r2b.mynotes.constants.NoteAppConstants
import com.r2b.mynotes.viewmodel.NewNoteInfoViewModel

class NoteHandler {

    companion object {
        var TAG: String = NoteAppConstants.TAG + NoteHandler.javaClass.simpleName
    }

    fun addNewNote(newNoteInfoViewModel: NewNoteInfoViewModel) {
        val stringNoteTitle = newNoteInfoViewModel.noteTitle.value
        val stringNoteType = newNoteInfoViewModel.noteType.value
    }

}