package id.workers.feeds.service

import id.workers.feeds.model.CreateNoteRequest
import id.workers.feeds.model.NoteResponse
import id.workers.feeds.model.UpdateNoteRequest

interface NoteService {
    fun createNote(createNoteRequest : CreateNoteRequest) : NoteResponse

    fun getNote(id : String) : NoteResponse

    fun updateNote(id : String, updateNoteRequest : UpdateNoteRequest) : NoteResponse

    fun deleteNote(id : String)
}


