package id.workers.feeds.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CreateNoteRequest (
    @field:NotBlank
    val id : String?,

    @field:NotNull
    val title: String?,

    @field:NotNull
    val description: String?
)
