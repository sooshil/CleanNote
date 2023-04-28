package com.sukajee.cleannote.feature_note.presentation.notes

import com.sukajee.cleannote.feature_note.domain.model.Note
import com.sukajee.cleannote.feature_note.domain.util.NoteOrder
import com.sukajee.cleannote.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Ascending),
    val isOrderSelectionSectionVisible: Boolean = false
)
