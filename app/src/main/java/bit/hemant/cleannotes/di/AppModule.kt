package bit.hemant.cleannotes.di

import android.app.Application
import androidx.room.Room
import bit.hemant.cleannotes.feature_note.data.data_source.NotesDatabase
import bit.hemant.cleannotes.feature_note.data.repository.NotesRepositoryImpl
import bit.hemant.cleannotes.feature_note.domain.repository.NotesRepository
import bit.hemant.cleannotes.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesDatabase(app: Application): NotesDatabase {
        return Room.databaseBuilder(app, NotesDatabase::class.java, NotesDatabase.DATABASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun providesNotesRepository(db: NotesDatabase): NotesRepository {
        return NotesRepositoryImpl(db.notesDao())
    }

    @Provides
    @Singleton
    fun providesNotesUseCase(notesRepository: NotesRepository): NotesUseCase {
        return NotesUseCase(
            getNotesUseCase = GetNotesUseCase(notesRepository),
            deleteNoteUseCase = DeleteNoteUseCase(notesRepository),
            addNoteUseCase = AddNoteUseCase(notesRepository),
            getNoteUseCase = GetNoteUseCase(notesRepository)
        )
    }

}