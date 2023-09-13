package id.workers.feeds.service.impl

import id.workers.feeds.entity.Note
import id.workers.feeds.model.CreateNoteRequest
import id.workers.feeds.model.NoteResponse
import id.workers.feeds.model.UpdateNoteRequest
import id.workers.feeds.repository.NoteRepository
import id.workers.feeds.service.NoteService
import id.workers.feeds.validation.ValidationUtil
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class NoteServiceImpl(val noteRepository: NoteRepository, val validationUtil: ValidationUtil) : NoteService {
    override fun createNote(createNoteRequest: CreateNoteRequest): NoteResponse {
        validationUtil.validate(createNoteRequest)

        val note = Note(
            id = createNoteRequest.id!!,
            title = createNoteRequest.title!!,
            description = createNoteRequest.description!!,
            createdAt = Date(),
            updatedAt = Date()
        )

        //Assumed Repository has already implemented Exception handling
        noteRepository.save(note)

        return noteToResponse(note)
    }

    override fun getNote(id : String): NoteResponse {
        val note = findNoteById(id)
        return noteToResponse(note)
    }

    override fun updateNote(id: String, updateNoteRequest: UpdateNoteRequest): NoteResponse {
        val note = findNoteById(id)

        validationUtil.validate(updateNoteRequest)

        note.apply {
            title = updateNoteRequest.title!!
            description = updateNoteRequest.description!!
            updatedAt = Date()
        }

        noteRepository.save(note)

        return noteToResponse(note)
    }

    override fun deleteNote(id: String) {
        findNoteById(id)
        noteRepository.deleteById(id)
    }

    private fun findNoteById(id : String) : Note {
        val note = noteRepository.findByIdOrNull(id)

        if(note == null){
            throw NotFoundException()
        } else {
            return note
        }
    }

    private fun noteToResponse(note: Note) : NoteResponse {
        return NoteResponse(
            id = note.id,
            title = note.title,
            description = note.description,
            createdAt = note.createdAt,
            updatedAt = note.updatedAt
        )
    }
}
