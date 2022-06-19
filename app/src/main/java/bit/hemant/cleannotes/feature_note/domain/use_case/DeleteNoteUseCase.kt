package bit.hemant.cleannotes.feature_note.domain.use_case

import bit.hemant.cleannotes.feature_note.domain.model.Note
import bit.hemant.cleannotes.feature_note.domain.repository.NotesRepository

class DeleteNoteUseCase(private val repository: NotesRepository) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}