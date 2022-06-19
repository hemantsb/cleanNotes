package bit.hemant.cleannotes.feature_note.presentation.notes

import bit.hemant.cleannotes.feature_note.domain.model.Note
import bit.hemant.cleannotes.feature_note.domain.util.NoteOrder
import bit.hemant.cleannotes.feature_note.domain.util.OrderType

data class NoteState(
    val notes: List<Note> = emptyList<Note>(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Decending),
    val isOrderSectionVisible: Boolean = false
)