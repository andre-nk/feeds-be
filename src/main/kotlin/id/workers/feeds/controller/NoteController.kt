package id.workers.feeds.controller

import id.workers.feeds.model.CreateNoteRequest
import id.workers.feeds.model.GenericResponse
import id.workers.feeds.model.NoteResponse
import id.workers.feeds.model.UpdateNoteRequest
import id.workers.feeds.service.NoteService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class NoteController(val noteService: NoteService) {

    @PostMapping(
        value = ["/api/notes"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createNote(@RequestBody body : CreateNoteRequest) : GenericResponse<NoteResponse>{
        val noteResponse = noteService.createNote(body)

        return GenericResponse(
            code = 200,
            status = "OK",
            data = noteResponse
        )
    }

    @GetMapping(
        value = ["/api/notes/{noteId}"],
        produces = ["application/json"]
    )
    fun getNote(@PathVariable("noteId") id : String) : GenericResponse<NoteResponse>{
        val noteResponse = noteService.getNote(id)

        return GenericResponse(
            code = 200,
            status = "OK",
            data = noteResponse
        )
    }

    @PutMapping(
        value = ["/api/notes/{noteId}"],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun updateNote(@PathVariable("noteId") id :String, @RequestBody body : UpdateNoteRequest) : GenericResponse<NoteResponse>{
        val noteResponse = noteService.updateNote(id, body)

        return GenericResponse(
            code = 200,
            status = "OK",
            data = noteResponse
        )
    }

    @DeleteMapping(
        value = ["/api/notes/{noteId}"]
    )
    fun deleteNote(@PathVariable("noteId") id : String) : GenericResponse<String>{
        noteService.deleteNote(id)

        return GenericResponse(
            code = 200,
            status = "OK",
            data = "Note $id has been deleted!"
        )
    }
}
