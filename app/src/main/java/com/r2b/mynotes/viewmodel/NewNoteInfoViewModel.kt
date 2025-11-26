package com.r2b.mynotes.viewmodel

import android.util.Log
import androidx.compose.material3.DatePickerState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.r2b.mynotes.constants.NoteAppConstants
import com.r2b.mynotes.constants.NoteTypes
import com.r2b.mynotes.db.Graph
import com.r2b.mynotes.db.entities.Note
import com.r2b.mynotes.db.repository.NotesRepository
import kotlinx.coroutines.launch
import java.util.Date

class NewNoteInfoViewModel(val notesRepository: NotesRepository = NotesRepository(Graph.getNotesDao())): ViewModel() {

    companion object {
        val TAG: String = NoteAppConstants.TAG + NewNoteInfoViewModel.javaClass.simpleName
    }

    private val _noteTitle: MutableState<String> = mutableStateOf("");
    private val _noteType: MutableState<String> = mutableStateOf("");
    private val _noteDescription: MutableState<String> = mutableStateOf("")
    private val _noteStartDate: MutableState<Long?> = mutableStateOf(null)
    private val _noteEndDate: MutableState<Long?> = mutableStateOf(null)
    val noteTitle: MutableState<String> = _noteTitle
    val noteType: MutableState<String> = _noteType
    val noteStartDate: MutableState<Long?> = _noteStartDate
    val noteEndDate: MutableState<Long?> = _noteEndDate
    val noteDescription = _noteDescription

    fun setNewNoteTitle(title: String) {
        noteTitle.value = title
    }

    fun setNoteType(type: String) {
        noteType.value = type
    }

    fun setNoteStartDate(startDate: Long?) {
        _noteStartDate.value = startDate
    }

    fun setNoteEndDate(endDate: Long?) {
        _noteEndDate.value = endDate
    }

    fun setNoteDescription(noteDes: String) {
        _noteDescription.value = noteDes
    }

    fun addNewNote(note: Note) {
        viewModelScope.launch {
            try {
                notesRepository.addNote(note)
                Log.i(TAG, "Inserted new note.")
            } catch (ex: Exception) {
                Log.i(TAG, "Error while inserting new note. Error :: " + ex.message)
            }
        }
    }

}