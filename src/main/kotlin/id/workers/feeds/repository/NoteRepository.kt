package id.workers.feeds.repository

import id.workers.feeds.entity.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Page

@Repository
interface NoteRepository : JpaRepository<Note, String> {
}
