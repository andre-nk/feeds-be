package id.workers.feeds.model

import jakarta.validation.constraints.NotNull

data class UpdateNoteRequest (
    @field:NotNull
    val title: String?,

    @field:NotNull
    val description: String?
)
