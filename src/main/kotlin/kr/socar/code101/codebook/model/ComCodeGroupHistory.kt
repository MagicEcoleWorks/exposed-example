package kr.socar.code101.codebook.model

import kr.socar.code101.codebook.infra.ComCodeGroupHistorys
import org.jetbrains.exposed.sql.ResultRow
import java.time.LocalDateTime

class ComCodeGroupHistory(
    val validityStartDate: LocalDateTime,
    val validityEndDate: LocalDateTime,
    val bfchgCodeGroupName: String,
    val aftchCodeGroupName: String?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    constructor(row: ResultRow) : this(
        validityStartDate = row[ComCodeGroupHistorys.validityStartDate],
        validityEndDate = row[ComCodeGroupHistorys.validityEndDate],
        bfchgCodeGroupName = row[ComCodeGroupHistorys.bfchgCodeGroupName],
        aftchCodeGroupName = row[ComCodeGroupHistorys.aftchCodeGroupName],
        createdAt = row[ComCodeGroupHistorys.createdAt],
        updatedAt = row[ComCodeGroupHistorys.updatedAt]
    )
}
