package com.r2b.mynotes.composable

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.checkScrollableContainerConstraints
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DatePicker
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalGraphicsContext
import com.r2b.mynotes.constants.NoteAppConstants
import com.r2b.mynotes.utils.DataValidator
import com.r2b.mynotes.viewmodel.NewNoteInfoViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddAimNoteInfo(newNoteInfoViewModel: NewNoteInfoViewModel) {


    val TAG: String = NoteAppConstants.TAG + "AddAimNoteInfo"

    val showStartDatePicker = remember { mutableStateOf(false) }
    val showEndDatePicker = remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            singleLine = false,
            value = "",
            onValueChange = {

            },
            label = {
                Text("Description")
            }
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(
                onClick = {
                    showStartDatePicker.value = true
                }
            ) {
                Text("Select Start Date")
            }
            TextButton(
                onClick = {
                    showEndDatePicker.value = true
                }
            ) {
                Text("Select End Date")
            }
        }
    }

    if(showStartDatePicker.value) {
        DatePickerModal(
            LocalContext.current,
            onDateSelectedRequest = {
            },
            onDatePickerDismissRequest = {
                showStartDatePicker.value = false
            },
            isSelectedDateValid = {
                Log.i(TAG, "Selected start date timestamp :: $it")
                if(it == null) {
                    return@DatePickerModal false
                }
                if(it < System.currentTimeMillis()) {
                    return@DatePickerModal false
                }
                return@DatePickerModal true
            }
        )
    }

    if(showEndDatePicker.value) {
        DatePickerModal(
            LocalContext.current,
            onDateSelectedRequest = {
            },
            onDatePickerDismissRequest = {
                showEndDatePicker.value = false
            },
            isSelectedDateValid = {
                Log.i(TAG, "selected end date timestamp :: $it")
                if(it == null) {
                    return@DatePickerModal false
                }
                val res: Boolean = DataValidator.isValidStartTime(selectedStartTime = it)
                return@DatePickerModal res
            }
        )
    }

}