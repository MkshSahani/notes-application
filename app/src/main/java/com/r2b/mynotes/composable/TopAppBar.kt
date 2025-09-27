package com.r2b.mynotes.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.r2b.mynotes.viewmodel.ShowAddNoteDialogViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteAppTopBar(showAddNoteAlertDialogViewModel : ShowAddNoteDialogViewModel) {

    TopAppBar(
        title = {
            Text("Notes")
        },
        actions = {
            IconButton(
                onClick = {
                    showAddNoteAlertDialogViewModel.showAddNoteDialogBox()
                },
            )  {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add new note")
            }
        }
    )

}