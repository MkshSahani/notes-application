package com.r2b.mynotes.views

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.r2b.mynotes.composable.AddNoteDialogBox
import com.r2b.mynotes.composable.NoteAppTopBar
import com.r2b.mynotes.navigation.NoteApplicationNavigation
import com.r2b.mynotes.viewmodel.NotesViewModel
import com.r2b.mynotes.viewmodel.ShowAddNoteDialogViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainView() {

    val navHostController: NavHostController = rememberNavController()
    val showAddNoteAlertDialogViewModel: ShowAddNoteDialogViewModel = viewModel()
    val notesVIewModel: NotesViewModel = viewModel()

    val showAddNoteAlertDialogBox = remember { showAddNoteAlertDialogViewModel.showAddNoteDialogBox }

    Scaffold(
        topBar = { NoteAppTopBar(showAddNoteAlertDialogViewModel) }
    ) {
        NoteApplicationNavigation(navHostController)
        if(showAddNoteAlertDialogBox.value) {
            AddNoteDialogBox(showAddNoteAlertDialogViewModel, notesVIewModel)
        }
    }

}