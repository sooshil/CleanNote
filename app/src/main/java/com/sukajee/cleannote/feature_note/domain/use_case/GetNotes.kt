package com.sukajee.cleannote.feature_note.domain.use_case

import com.sukajee.cleannote.feature_note.domain.model.Note
import com.sukajee.cleannote.feature_note.domain.repository.NoteRepository
import com.sukajee.cleannote.feature_note.domain.util.NoteOrder
import com.sukajee.cleannote.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private val repository: NoteRepository
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
//            when(noteOrder.orderType) {
//                is OrderType.Ascending -> {
//                    when(noteOrder) {
//                        is NoteOrder.Date -> {
//                            notes.sortedBy { it.timestamp }
//                        }
//                        is NoteOrder.Title -> {
//                            notes.sortedBy { it.title.lowercase() }
//                        }
//                        is NoteOrder.Color -> {
//                            notes.sortedBy { it.color }
//                        }
//                    }
//                }
//                is OrderType.Descending -> {
//                    when(noteOrder) {
//                        is NoteOrder.Date -> {
//                            notes.sortedByDescending { it.timestamp }
//                        }
//                        is NoteOrder.Title -> {
//                            notes.sortedByDescending { it.title.lowercase() }
//                        }
//                        is NoteOrder.Color -> {
//                            notes.sortedByDescending { it.color }
//                        }
//                    }
//                }
//            }
            when(noteOrder) {
                is NoteOrder.Date -> {
                    when(noteOrder.orderType) {
                        is OrderType.Ascending -> notes.sortedBy { it.timestamp }
                        is OrderType.Descending -> notes.sortedByDescending { it.timestamp }
                    }
                }
                is NoteOrder.Title -> {
                    when(noteOrder.orderType) {
                        is OrderType.Ascending -> notes.sortedBy { it.title.lowercase() }
                        is OrderType.Descending -> notes.sortedByDescending { it.title.lowercase() }
                    }
                }
                is NoteOrder.Color -> {
                    when(noteOrder.orderType) {
                        is OrderType.Ascending -> notes.sortedBy { it.color }
                        is OrderType.Descending -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}
