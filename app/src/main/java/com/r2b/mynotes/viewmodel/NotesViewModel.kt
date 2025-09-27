package com.r2b.mynotes.viewmodel

import androidx.lifecycle.ViewModel
import com.r2b.mynotes.db.Graph
import com.r2b.mynotes.db.repository.NotesRepository

class NotesViewModel(val notesRepository: NotesRepository = NotesRepository(Graph.getNotesDao())) : ViewModel(){



}