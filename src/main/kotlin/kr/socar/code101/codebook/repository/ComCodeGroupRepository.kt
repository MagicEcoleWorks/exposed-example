package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.infra.ComCodeGroupTable
import kr.socar.code101.codebook.model.ComCodeGroupEntity
import org.jetbrains.exposed.sql.insert
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime

@Repository
class ComCodeGroupRepository(
    private val clock: Clock
) {
    fun insert(
        codeGroupId: String,
        codeGroupName : String,
        parentCodeGroupId : String?,
        description : String?
    ) : ComCodeGroupEntity {
        val now = LocalDateTime.now(clock)
        ComCodeGroupTable.insert { table ->
            table[ComCodeGroupTable.codeGroupId] = codeGroupId
            table[ComCodeGroupTable.codeGroupName] = codeGroupName
            table[ComCodeGroupTable.parentCodeGroupId] = parentCodeGroupId
            table[ComCodeGroupTable.description] = description
            table[ComCodeGroupTable.createdAt] = createdAt
            table[ComCodeGroupTable.updatedAt] = updatedAt
        }
        return ComCodeGroupEntity(codeGroupId, codeGroupName, parentCodeGroupId, description, now, now)
    }
}
