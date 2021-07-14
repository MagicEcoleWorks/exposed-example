package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.model.ComCodeGroupHistory
import kr.socar.code101.codebook.model.ComCodeGroupHistorys
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.update
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime


@Repository
class ComCodeGroupHistoryRepository(private val clock: Clock) {
    fun findAll(): List<ComCodeGroupHistory> {
        val query = ComCodeGroupHistorys.selectAll()
        return ComCodeGroupHistory.wrapRows(query).toList()
    }

    fun insert(id: String, codeGroupName: String): ComCodeGroupHistory {
        val now = LocalDateTime.now(clock)
        return ComCodeGroupHistory.new(id) {
            this.validityStartDate = now
            this.validityEndDate = LocalDateTime.of(9999, 12, 31, 11, 59)
            this.bfchgCodeGroupName = codeGroupName
            this.createdAt = now
            this.updatedAt = now
        }
    }

    fun findOne(id: String): ComCodeGroupHistory? {
        val query = ComCodeGroupHistorys.select { ComCodeGroupHistorys.id eq id }
        return ComCodeGroupHistory.wrapRows(query).firstOrNull()
    }

    fun update(id: String, codeGroupName : String) : Int {
        val now = LocalDateTime.now(clock)
        return ComCodeGroupHistorys.update({
            ComCodeGroupHistorys.id eq id
        }) {
            it[this.bfchgCodeGroupName] = codeGroupName
            it[this.updatedAt] = now
        }
    }
}
