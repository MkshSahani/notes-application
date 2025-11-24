package com.r2b.mynotes.composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import com.r2b.mynotes.constants.NoteTypes
import com.r2b.mynotes.viewmodel.NewNoteInfoViewModel

@RequiresApi(Build.VERSION_CODES.O)
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