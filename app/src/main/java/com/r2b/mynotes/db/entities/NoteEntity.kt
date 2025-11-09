package com.r2b.mynotes.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "notes"
)
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "title") // Note Title
    val title: String,
    @ColumnInfo(name = "type") // type of Note Fixed (REMINDER, TASK, AIM)
    val type: String,
    @ColumnInfo(name = "created_at") // timestamp of when note is created.
    val createdAt: Long,
    @ColumnInfo(name = "is_active") // whether note is still active. Status not complete.
    val isActive: Boolean,
    @ColumnInfo(name = "status") // What is current status of note.
    val status: String
)