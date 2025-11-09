package com.r2b.mynotes.composable

import android.content.Context
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import com.r2b.mynotes.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    context: Context,
    onDatePickerDismissRequest: () -> Unit,
    onDateSelectedRequest: (Long?) -> Unit,
    isSelectedDateValid: (Long?) -> Boolean
) {
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = System.currentTimeMillis())
    val invalidStringMessage = stringResource(R.string.invalid_date_message)
    DatePickerDialog(
        modifier = Modifier.padding(horizontal = 32.dp),
        onDismissRequest = {
            onDatePickerDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if(isSelectedDateValid(datePickerState.selectedDateMillis)) {
                        onDateSelectedRequest(datePickerState.selectedDateMillis)
                    } else {
                        Toast.makeText(context, invalidStringMessage, Toast.LENGTH_SHORT).show()
                    }
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDatePickerDismissRequest()
                }
            ) {
                Text("Cancel")
            }
        }
    ) {
        androidx.compose.material3.DatePicker(
            state = datePickerState
        )
    }

}
