package id.workers.feeds.service

import id.workers.feeds.model.CreateNoteRequest
import id.workers.feeds.model.NoteResponse
import id.workers.feeds.model.PaginatedNoteResponse
import id.workers.feeds.model.UpdateNoteRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query

interface NoteService {
    fun createNote(createNoteRequest : CreateNoteRequest) : NoteResponse

    fun getNote(id : String) : NoteResponse

    fun updateNote(id : String, updateNoteRequest : UpdateNoteRequest) : NoteResponse

    fun deleteNote(id : String)

    fun getNotes(pageable: Pageable) : PaginatedNoteResponse
}


