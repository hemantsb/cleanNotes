package bit.hemant.cleannotes.feature_note.domain.use_case

import bit.hemant.cleannotes.feature_note.data.repository.FakeNotesRepository
import bit.hemant.cleannotes.feature_note.domain.model.Note
import bit.hemant.cleannotes.feature_note.domain.util.NoteOrder
import bit.hemant.cleannotes.feature_note.domain.util.OrderType
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetNotesUseCaseTest {


    private lateinit var getNoteUseCase: GetNotesUseCase
    private lateinit var repository: FakeNotesRepository


    @Before
    fun setUp() {
        repository = FakeNotesRepository()
        getNoteUseCase = GetNotesUseCase(repository)


        val notesToInsert = mutableListOf<Note>()
        ('a'..'z').forEachIndexed { index, c ->
            notesToInsert.add(
                Note(
                    title = c.toString(),
                    content = c.toString(),
                    timestamp = index.toLong(),
                    color = index
                )
            )
        }
        notesToInsert.shuffle()

        runBlocking {
            notesToInsert.forEach {
                repository.insertNote(it)
            }
        }

    }

    @Test
    fun `Order notes by title ascending, correct order`() = runBlocking {
        val notes = getNoteUseCase(NoteOrder.Title(OrderType.Acending)).first()
        for (i in 0..notes.size - 2) {
            assertThat(notes[i].title).isLessThan(notes[i + 1].title)
        }
    }

    @Test
    fun `Order notes by title decending, correct order`() = runBlocking {
        val notes = getNoteUseCase(NoteOrder.Title(OrderType.Decending)).first()
        for (i in 0..notes.size - 2) {
            assertThat(notes[i].title).isGreaterThan(notes[i + 1].title)
        }
    }


    @Test
    fun `Order notes by date ascending, correct order`() = runBlocking {
        val notes = getNoteUseCase(NoteOrder.Date(OrderType.Acending)).first()
        for (i in 0..notes.size - 2) {
            assertThat(notes[i].timestamp).isLessThan(notes[i + 1].timestamp)
        }
    }

    @Test
    fun `Order notes by date decending, correct order`() = runBlocking {
        val notes = getNoteUseCase(NoteOrder.Date(OrderType.Decending)).first()
        for (i in 0..notes.size - 2) {
            assertThat(notes[i].timestamp).isGreaterThan(notes[i + 1].timestamp)
        }
    }


    @Test
    fun `Order notes by Color ascending, correct order`() = runBlocking {
        val notes = getNoteUseCase(NoteOrder.Color(OrderType.Acending)).first()
        for (i in 0..notes.size - 2) {
            assertThat(notes[i].color).isLessThan(notes[i + 1].color)
        }
    }

    @Test
    fun `Order notes by color decending, correct order`() = runBlocking {
        val notes = getNoteUseCase(NoteOrder.Color(OrderType.Decending)).first()
        for (i in 0..notes.size - 2) {
            assertThat(notes[i].color).isGreaterThan(notes[i + 1].color)
        }
    }

}