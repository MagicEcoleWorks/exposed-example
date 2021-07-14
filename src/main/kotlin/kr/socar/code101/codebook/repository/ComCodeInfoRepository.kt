package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.infra.ComCodeInfos
import kr.socar.code101.codebook.model.ComCodeInfo
import org.jetbrains.exposed.sql.select
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

    fun findOne(id: Int): String? {
        val query = ComCodeInfos.select { ComCodeInfos.id eq id }
        val one = ComCodeInfo.wrapRows(query).firstOrNull()
        return "{code_id: " + id + ", code_name:${one?.codeName}, description:${one?.description}, created:${one?.createdAt}, updated:${one?.updatedAt}}"
    }

    fun update(id: Int, description: String? = null): String? {
        val now = LocalDateTime.now(clock)
        val query = ComCodeInfos.select { ComCodeInfos.id eq id }
        val one = ComCodeInfo.wrapRows(query).firstOrNull()
        one?.description = description
        one?.updatedAt = now
        return findOne(id)
    }
}
