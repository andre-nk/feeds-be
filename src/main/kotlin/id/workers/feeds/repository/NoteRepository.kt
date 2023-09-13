package id.workers.feeds.repository

import id.workers.feeds.entity.Note
import org.springframework.data.jpa.repository.JpaRepository

interface NoteRepository : JpaRepository<Note, String> {
}
