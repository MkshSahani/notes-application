package com.r2b.mynotes.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.r2b.mynotes.constants.NoteTypes

class NewNoteInfoViewModel: ViewModel() {

    private val _noteTitle: MutableState<String> = mutableStateOf("");
    private val _noteType: MutableState<String> = mutableStateOf("");
    val noteTitle: MutableState<String> = _noteTitle
    val noteType: MutableState<String> = _noteType

    fun setNewNoteTitle(title: String) {
        noteTitle.value = title
    }

    fun setNoteType(type: String) {
        noteType.value = type
    }

}