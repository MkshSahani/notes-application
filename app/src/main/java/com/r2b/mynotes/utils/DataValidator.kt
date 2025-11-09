package com.r2b.mynotes.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.r2b.mynotes.constants.NoteAppConstants
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date


object DataValidator {

    @RequiresApi(Build.VERSION_CODES.O)
    fun isValidStartTime(selectedStartTime: Long) : Boolean {
        val currentTimeStamp = System.currentTimeMillis()
        val currentDate: Date = Date(currentTimeStamp)
        val selectedDate: Date = Date(selectedStartTime)
        return (selectedDate == currentDate) || selectedDate.after(currentDate)
    }


}

