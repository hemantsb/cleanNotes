package bit.hemant.cleannotes.feature_note.domain.repository

import bit.hemant.cleannotes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow


interface NotesRepository {
    fun getNotes(): Flow<List<Note>>

    suspend fun getNotesById(id: Int): Note?

    suspend fun deleteNote(note: Note)

    suspend fun insertNote(note: Note)
}