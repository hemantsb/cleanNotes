package bit.hemant.cleannotes.feature_note.domain.use_case

import bit.hemant.cleannotes.feature_note.domain.model.InvalidNoteException
import bit.hemant.cleannotes.feature_note.domain.model.Note
import bit.hemant.cleannotes.feature_note.domain.repository.NotesRepository

class AddNoteUseCase(val repository: NotesRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isEmpty()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }

        if (note.content.isEmpty()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }
}