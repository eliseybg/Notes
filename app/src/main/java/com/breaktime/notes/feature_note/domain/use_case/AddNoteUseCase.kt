package com.breaktime.notes.feature_note.domain.use_case

import com.breaktime.notes.feature_note.domain.model.InvalidNodeException
import com.breaktime.notes.feature_note.domain.model.Note
import com.breaktime.notes.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddNoteUseCase(private val noteRepository: NoteRepository) {
    @Throws(InvalidNodeException::class)
    suspend operator fun invoke(note: Note) = withContext(Dispatchers.IO) {
        if (note.title.isBlank()) {
            throw InvalidNodeException("The title of the note can't be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNodeException("The content of the note can't be empty")
        }
        noteRepository.insertNote(note)
    }
}