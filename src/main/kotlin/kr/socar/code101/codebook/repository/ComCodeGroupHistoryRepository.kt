package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.model.ComCodeGroupHistory
import kr.socar.code101.codebook.model.ComCodeGroupHistorys
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime


@Repository
class ComCodeGroupHistoryRepository(private val clock: Clock) {
    val now = LocalDateTime.now(clock)

    fun findAll(): List<ComCodeGroupHistory> {
        val query = ComCodeGroupHistorys.selectAll()
        return ComCodeGroupHistory.wrapRows(query).toList()
    }

    fun insert(id: String, codeGroupName: String): ComCodeGroupHistory {
        return ComCodeGroupHistory.new(id) {
            this.validityStartDate = now
            this.validityEndDate = LocalDateTime.of(9999, 12, 31, 11, 59)
            this.bfchgCodeGroupName = codeGroupName
            this.createdAt = now
            this.updatedAt = now
        }
    }
}
