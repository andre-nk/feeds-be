package id.workers.feeds.model

class PaginatedNoteResponse (
    val data: List<NoteResponse>,
    val total: Long,
    currentPage: Int
) {
    var currentPage : Int = currentPage + 1
}

