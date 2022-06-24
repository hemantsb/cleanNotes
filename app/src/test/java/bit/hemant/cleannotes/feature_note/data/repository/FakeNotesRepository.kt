package bit.hemant.cleannotes.feature_note.data.repository

import bit.hemant.cleannotes.feature_note.domain.model.Note
import bit.hemant.cleannotes.feature_note.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeNotesRepository : NotesRepository {

    private var notes = mutableListOf<Note>()

    override fun getNotes(): Flow<List<Note>> {
        return flow { emit(notes) }
    }

    override suspend fun getNotesById(id: Int): Note? {
        return notes.find { it.id == id }
    }

    override suspend fun deleteNote(note: Note) {
        notes.remove(note)
    }

    override suspend fun insertNote(note: Note) {
        notes.add(note)
    }
}