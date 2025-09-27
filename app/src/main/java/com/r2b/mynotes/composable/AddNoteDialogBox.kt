package com.r2b.mynotes.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.util.TableInfo
import com.r2b.mynotes.constants.noteTypeList
import com.r2b.mynotes.viewmodel.NewNoteInfoViewModel
import com.r2b.mynotes.viewmodel.NotesViewModel
import com.r2b.mynotes.viewmodel.ShowAddNoteDialogViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteDialogBox(showAlertBoxViewModel : ShowAddNoteDialogViewModel, notesViewModel: NotesViewModel) {

    val newNoteInfoViewModel: NewNoteInfoViewModel = viewModel()
    val noteTitle = remember { newNoteInfoViewModel.noteTitle }
    val noteType = remember { newNoteInfoViewModel.noteType }
    val isNoteTypeDropdownExpended = remember { mutableStateOf(false) }
    val dropDownMenuButtonTxt = remember { mutableStateOf("Select Note Type") }


    AlertDialog(
        onDismissRequest = {
            showAlertBoxViewModel.dismissAddNOteDialogBox()
        },
        title = {
            Text("Add new note")
        },
        dismissButton = {
            TextButton(onClick = {
                showAlertBoxViewModel.dismissAddNOteDialogBox()
            }) {
                Text("Cancel")
            }
        },
        confirmButton = {
            TextButton(onClick = {
                showAlertBoxViewModel.dismissAddNOteDialogBox()
            }) {
                Text("Add")
            }
        },
        text = {
            Column {
                TextField(
                    label = {
                        Text("Note Title")
                    },
                    value = noteTitle.value,
                    onValueChange = { newTitle ->
                        newNoteInfoViewModel.setNewNoteTitle(newTitle)
                    }
                )
                Box() {
                    TextButton(
                        onClick = {
                            isNoteTypeDropdownExpended.value = true
                        }
                    ) {
                        Text(dropDownMenuButtonTxt.value)
                    }
                    DropdownMenu(
                        expanded = isNoteTypeDropdownExpended.value,
                        onDismissRequest = {
                            isNoteTypeDropdownExpended.value = !isNoteTypeDropdownExpended.value
                        }
                    ) {
                        noteTypeList.forEach { noteType ->
                            DropdownMenuItem(text = {
                                Text(noteType.type)
                            }, onClick = {
                                dropDownMenuButtonTxt.value = noteType.type
                                newNoteInfoViewModel.setNoteType(noteType.type)
                                isNoteTypeDropdownExpended.value = false
                            })
                        }
                    }
                }
            }
        },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        ),
    )

}