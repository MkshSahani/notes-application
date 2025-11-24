package com.r2b.mynotes.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.r2b.mynotes.constants.NoteAppConstants
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date


object DataValidator {

    val TAG: String = NoteAppConstants.TAG + DataValidator.javaClass.simpleName

    @RequiresApi(Build.VERSION_CODES.O)
    fun isValidStartTime(selectedStartTime: Long) : Boolean {
        val currentTimeStamp = System.currentTimeMillis()
        val currentDate: Date = Date(currentTimeStamp)
        val selectedDate: Date = Date(selectedStartTime)
        return (selectedDate.year == currentDate.year && selectedDate.month == currentDate.month && selectedDate.date == currentDate.date) || selectedDate.after(currentDate)
    }

    fun isValidEndTime(selectedEndTime: Long, selectedStartTime: Long) : Boolean {
        val currentTimeStamp: Long = System.currentTimeMillis()
        val selectedStartDate: Date = Date(selectedStartTime)
        val selectedEndDate: Date = Date(selectedEndTime)
        val currentDate: Date = Date(currentTimeStamp)
        return (selectedEndDate.year == currentDate.year && selectedEndDate.month == currentDate.month && selectedEndDate.date == currentDate.date) || selectedEndDate.after(selectedStartDate)
    }

    fun getDateFromTimestamp(timestamp: Long) : String {
        val selectedDate: Date = Date(timestamp)
        return selectedDate.date.toString() + "/" + selectedDate.month.toString() + "/" + selectedDate.year.toString();
    }


}

