package kr.socar.code101.codebook.model

import kr.socar.code101.codebook.infra.ComCodeGroupHistoryTable
import org.jetbrains.exposed.sql.ResultRow
import java.time.LocalDateTime

class ComCodeGroupHistoryEntity(
    val validityStartDate: LocalDateTime,
    val validityEndDate: LocalDateTime,
    val bfchgCodeGroupName: String,
    val aftchCodeGroupName: String?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    constructor(row: ResultRow) : this(
        validityStartDate = row[ComCodeGroupHistoryTable.validityStartDate],
        validityEndDate = row[ComCodeGroupHistoryTable.validityEndDate],
        bfchgCodeGroupName = row[ComCodeGroupHistoryTable.bfchgCodeGroupName],
        aftchCodeGroupName = row[ComCodeGroupHistoryTable.aftchCodeGroupName],
        createdAt = row[ComCodeGroupHistoryTable.createdAt],
        updatedAt = row[ComCodeGroupHistoryTable.updatedAt]
    )
}
