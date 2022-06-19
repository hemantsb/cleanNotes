package bit.hemant.cleannotes.feature_note.domain.use_case

import bit.hemant.cleannotes.feature_note.domain.model.Note
import bit.hemant.cleannotes.feature_note.domain.repository.NotesRepository
import bit.hemant.cleannotes.feature_note.domain.util.NoteOrder
import bit.hemant.cleannotes.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(private val repository: NotesRepository) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Acending)): Flow<List<Note>> {
        return repository.getNotes().map { notes ->

            when (noteOrder.orderType) {
                is OrderType.Acending -> {
                    when (noteOrder) {
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Decending -> {
                    when (noteOrder) {
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}