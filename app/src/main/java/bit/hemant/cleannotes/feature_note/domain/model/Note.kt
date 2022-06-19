package bit.hemant.cleannotes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import bit.hemant.cleannotes.ui.theme.*

@Entity
class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {

    companion object {
        val noteColors = listOf(RedOrange, RedPink, BabyBlue, Violet, LightGreen)
    }

}

class InvalidNoteException(message: String) : Exception(message)