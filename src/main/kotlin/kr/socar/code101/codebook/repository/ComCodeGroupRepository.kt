package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.infra.ComCodeGroupTable
import kr.socar.code101.codebook.model.ComCodeGroupEntity
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.update
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime

@Repository
class ComCodeGroupRepository(
    private val clock: Clock
) {
    fun insert(
        codeGroupId: String,
        codeGroupName: String,
        parentCodeGroupId: String?,
        description: String?
    ) {
        val now = LocalDateTime.now(clock)
        ComCodeGroupTable.insert { table ->
            table[ComCodeGroupTable.codeGroupId] = codeGroupId
            table[ComCodeGroupTable.codeGroupName] = codeGroupName
            table[ComCodeGroupTable.parentCodeGroupId] = parentCodeGroupId
            table[ComCodeGroupTable.description] = description
            table[ComCodeGroupTable.createdAt] = now
            table[ComCodeGroupTable.updatedAt] = now
        }
    }

    fun findAll(): List<ComCodeGroupEntity> {
        val result = ComCodeGroupTable.selectAll()
        val resultRows = result.toList()
        return resultRows.map { ComCodeGroupEntity(it) }
    }

    fun update(
        codeGroupId: String,
        description: String
    ): Int {
        return ComCodeGroupTable.update({ComCodeGroupTable.codeGroupId eq codeGroupId}) { table ->
            table[ComCodeGroupTable.description] = description
            table[ComCodeGroupTable.updatedAt] = LocalDateTime.now(clock)
        }
    }

    fun findById(codeGroupId: String): ComCodeGroupEntity? {
        return ComCodeGroupTable.select { ComCodeGroupTable.codeGroupId eq codeGroupId }
                .firstOrNull()
                ?.run { ComCodeGroupEntity(this) }
    }
}
