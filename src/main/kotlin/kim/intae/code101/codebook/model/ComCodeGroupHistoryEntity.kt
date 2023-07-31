package kim.intae.code101.codebook.model

import kim.intae.code101.codebook.infra.ComCodeGroupHistoryTable
import org.jetbrains.exposed.sql.ResultRow
import java.time.LocalDateTime

data class ComCodeGroupHistoryEntity(
    val codeGroupId: String,
    val codeValidityStartDate: LocalDateTime,
    val codeValidityEndDate: LocalDateTime,
    val codeGroupName: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    constructor(row: ResultRow) : this(
        codeGroupId = row[ComCodeGroupHistoryTable.codeGroupId],
        codeValidityStartDate = row[ComCodeGroupHistoryTable.codeValidityStartDate],
        codeValidityEndDate = row[ComCodeGroupHistoryTable.codeValidityEndDate],
        codeGroupName = row[ComCodeGroupHistoryTable.codeGroupName],
        createdAt = row[ComCodeGroupHistoryTable.createdAt],
        updatedAt = row[ComCodeGroupHistoryTable.updatedAt]
    )
}
