package com.r2b.mynotes.composable

import androidx.compose.runtime.Composable
import com.r2b.mynotes.constants.NoteTypes
import com.r2b.mynotes.viewmodel.NewNoteInfoViewModel

@Composable
fun AddNoteCustomInfo(newNoteInfoViewModel: NewNoteInfoViewModel) {
    when(newNoteInfoViewModel.noteType.value) {
        NoteTypes.NoteTypeAIM.type -> {
            AddAimNoteInfo(newNoteInfoViewModel)
        }
        NoteTypes.NoteTypeTask.type -> {
            AddTaskNoteInfo(newNoteInfoViewModel)
        }
        NoteTypes.NoteTypeReminder.type -> {
            AddReminderNoteInfo(newNoteInfoViewModel)
        }
    }
}