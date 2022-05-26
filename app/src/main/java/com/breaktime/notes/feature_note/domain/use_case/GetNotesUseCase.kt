package com.breaktime.notes.feature_note.domain.use_case

import com.breaktime.notes.feature_note.domain.model.Note
import com.breaktime.notes.feature_note.domain.repository.NoteRepository
import com.breaktime.notes.feature_note.domain.util.NoteOrder
import com.breaktime.notes.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.map

class GetNotesUseCase(private val repository: NoteRepository) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ) = repository.getNotes().map { notes ->
        val compareType = when (noteOrder) {
            is NoteOrder.Title -> Note::title
            is NoteOrder.Date -> Note::timestamp
            is NoteOrder.Color -> Note::color
        }
        when (noteOrder.orderType) {
            is OrderType.Ascending -> {
                return@map notes.sortedWith { a, b -> compareValuesBy(a, b, compareType) }
            }
            is OrderType.Descending -> {
                return@map notes.sortedWith { a, b -> compareValuesBy(b, a, compareType) }
            }
        }
    }
}