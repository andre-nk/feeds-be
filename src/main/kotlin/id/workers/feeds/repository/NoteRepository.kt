package id.workers.feeds.repository

import id.workers.feeds.entity.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

@Repository
interface NoteRepository : JpaRepository<Note, String> {
    @Query(
        value = "SELECT * FROM public.notes WHERE to_tsvector('english', title) @@ phraseto_tsquery('english', :s)",
        nativeQuery = true
    )
    fun search(@Param("s") s: String, pageable: Pageable): Page<Note>
}
