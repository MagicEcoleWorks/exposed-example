package kim.intae.code101.codebook.repository

import kr.socar.code101.codebook.infra.ComCodeInfoTable
import kr.socar.code101.codebook.model.ComCodeInfoEntity
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime

@Repository
class ComCodeInfoRepository(
    private val clock: Clock
) {
    fun insert(codeId: String, codeName: String): ComCodeInfoEntity {
        val now = LocalDateTime.now(clock)
        ComCodeInfoTable.insert { table ->
            table[ComCodeInfoTable.codeId] = codeId
            table[ComCodeInfoTable.codeName] = codeName
            table[ComCodeInfoTable.createdAt] = now
            table[ComCodeInfoTable.updatedAt] = now
        }
        return ComCodeInfoEntity(codeId, codeName, now, now)
    }

    fun findAll(): List<ComCodeInfoEntity> {
        return ComCodeInfoTable.selectAll().toList().map { ComCodeInfoEntity(it) }
    }
}
