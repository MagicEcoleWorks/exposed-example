package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.infra.ComCodeInfoTable
import kr.socar.code101.codebook.model.ComCodeInfoEntity
import org.jetbrains.exposed.sql.select
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime

@Repository
class ComCodeInfoRepository(
    private val clock: Clock
) {
    fun insert(name: String, description: String?): ComCodeInfoEntity {
        val now = LocalDateTime.now(clock)
        return ComCodeInfoEntity.new {
            this.codeName = name
            this.description = description
            this.createdAt = now
            this.updatedAt = now
        }.also { it.flush() }
    }

    fun findById(id: Int)= ComCodeInfoEntity.findById(id)

    fun findByName(name: String) = ComCodeInfoTable
        .select { ComCodeInfoTable.codeName eq name }
        .run { ComCodeInfoEntity.wrapRows(this) }
        .firstOrNull()
}
