package id.workers.feeds.model

import jakarta.validation.constraints.NotBlank

data class DeleteNoteRequest (
    @field:NotBlank
    val id : String?,
)
