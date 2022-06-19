package bit.hemant.cleannotes.feature_note.data.data_source

import androidx.room.*
import bit.hemant.cleannotes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Query("SELECT * from note")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECt * from note WHERE id=:id")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}