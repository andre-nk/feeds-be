package id.workers.feeds.model

import java.util.*

data class NoteResponse (
    val id: String,
    val title: String,
    val description: String,
    val createdAt: Date,
    val updatedAt: Date
)
