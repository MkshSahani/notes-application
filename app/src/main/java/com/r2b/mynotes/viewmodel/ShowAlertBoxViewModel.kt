package com.r2b.mynotes.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ShowAddNoteDialogViewModel : ViewModel() {

    private val _showAddNoteDialogBox: MutableState<Boolean> = mutableStateOf(false)
    val showAddNoteDialogBox = _showAddNoteDialogBox

    fun showAddNoteDialogBox() {
        _showAddNoteDialogBox.value = true
    }

    fun dismissAddNOteDialogBox() {
        _showAddNoteDialogBox.value = false
    }

}