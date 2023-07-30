package kim.intae.code101.codebook.model

import kr.socar.code101.codebook.infra.ComCodeGroupTable
import org.jetbrains.exposed.sql.ResultRow
import java.time.LocalDateTime

data class ComCodeGroupEntity(
    val codeGroupId: String,
    val codeGroupName: String,
    val parentCodeGroupId: String?,
    val description: String?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    constructor(row: ResultRow) : this(
        codeGroupId = row[ComCodeGroupTable.codeGroupId],
        codeGroupName = row[ComCodeGroupTable.codeGroupName],
        parentCodeGroupId = row[ComCodeGroupTable.parentCodeGroupId],
        description = row[ComCodeGroupTable.description],
        createdAt = row[ComCodeGroupTable.createdAt],
        updatedAt = row[ComCodeGroupTable.updatedAt],
    )
}
