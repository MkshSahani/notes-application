package com.r2b.mynotes.viewmodel

import androidx.compose.material3.DatePickerState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.r2b.mynotes.constants.NoteTypes
import java.util.Date

class NewNoteInfoViewModel: ViewModel() {

    private val _noteTitle: MutableState<String> = mutableStateOf("");
    private val _noteType: MutableState<String> = mutableStateOf("");
    private val _noteStartDate: MutableState<Long?> = mutableStateOf(null)
    private val _noteEndDate: MutableState<Long?> = mutableStateOf(null)
    val noteTitle: MutableState<String> = _noteTitle
    val noteType: MutableState<String> = _noteType
    val noteStartDate: MutableState<Long?> = _noteStartDate
    val noteEndDate: MutableState<Long?> = _noteEndDate

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

}