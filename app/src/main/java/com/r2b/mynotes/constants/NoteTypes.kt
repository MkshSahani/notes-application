package com.r2b.mynotes.constants

sealed class NoteTypes(val type: String) {
    object NoteTypeTask: NoteTypes("TASK")
    object NoteTypeReminder: NoteTypes("REMINDER")
    object NoteTypeAIM: NoteTypes("AIM")
}

val noteTypeList: List<NoteTypes> = listOf(
    NoteTypes.NoteTypeTask,
    NoteTypes.NoteTypeReminder,
    NoteTypes.NoteTypeAIM
)
