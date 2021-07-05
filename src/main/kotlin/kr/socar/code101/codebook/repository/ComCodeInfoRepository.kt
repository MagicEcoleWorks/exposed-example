package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.model.ComCodeInfo
import kr.socar.code101.codebook.model.ComCodeInfos
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime

@Repository
class ComCodeInfoRepository(private val clock: Clock) {
    fun findAll(): List<ComCodeInfo> {
        val query = ComCodeInfos.selectAll()
        return ComCodeInfo.wrapRows(query).toList()
    }

    fun insert(codeName: String, description: String? = null): ComCodeInfo {
        val now = LocalDateTime.now(clock)
        return ComCodeInfo.new {
            this.codeName = codeName
            this.description = description
            this.createdAt = now
            this.updatedAt = now
        }
    }
}
