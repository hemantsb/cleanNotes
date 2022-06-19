package bit.hemant.cleannotes.feature_note.presentation.add_edit_note.components

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)