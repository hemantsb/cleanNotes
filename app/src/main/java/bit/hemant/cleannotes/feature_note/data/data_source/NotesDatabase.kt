package bit.hemant.cleannotes.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import bit.hemant.cleannotes.feature_note.domain.model.Note


@Database(entities = [Note::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDao
    companion object{
        const val DATABASE_NAME = "Clean DB"
    }

}