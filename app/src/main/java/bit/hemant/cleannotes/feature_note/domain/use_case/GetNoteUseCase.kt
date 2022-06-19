package bit.hemant.cleannotes.feature_note.domain.use_case

import bit.hemant.cleannotes.feature_note.domain.model.Note
import bit.hemant.cleannotes.feature_note.domain.repository.NotesRepository

class GetNoteUseCase(private val repository: NotesRepository) {

    suspend operator fun invoke(noteId: Int): Note? {
        return repository.getNotesById(noteId)
    }
}