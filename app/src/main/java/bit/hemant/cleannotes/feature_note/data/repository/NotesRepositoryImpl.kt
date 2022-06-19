package bit.hemant.cleannotes.feature_note.data.repository

import bit.hemant.cleannotes.feature_note.data.data_source.NotesDao
import bit.hemant.cleannotes.feature_note.domain.model.Note
import bit.hemant.cleannotes.feature_note.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow

class NotesRepositoryImpl(val dao: NotesDao) : NotesRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getAllNotes()
    }

    override suspend fun getNotesById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

}