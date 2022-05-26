package com.breaktime.notes.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.breaktime.notes.feature_note.domain.model.Note

@Database(entities = [Note::class], exportSchema = false, version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract val noteDao: NoteDao
}