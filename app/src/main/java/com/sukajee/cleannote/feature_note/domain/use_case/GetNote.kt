package com.sukajee.cleannote.feature_note.domain.use_case

import com.sukajee.cleannote.feature_note.domain.model.Note
import com.sukajee.cleannote.feature_note.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? = repository.getNoteById(id)
}
