package id.workers.feeds.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "notes", schema = "public")
data class Note (
    @Id
    val id: String,

    @Column(name="title")
    var title: String,

    @Column(name="description")
    var description: String,

    @Column(name="created_at")
    val createdAt: Date,

    @Column(name="updated_at")
    var updatedAt: Date
)
