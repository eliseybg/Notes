package com.breaktime.notes.feature_note.domain.use_case

import com.breaktime.notes.feature_note.domain.model.Note
import com.breaktime.notes.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetNoteUseCase(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? = withContext(Dispatchers.IO) {
        noteRepository.getNoteById(id)
    }
}