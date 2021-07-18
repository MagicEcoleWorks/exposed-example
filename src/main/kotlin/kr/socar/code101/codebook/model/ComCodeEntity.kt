package kr.socar.code101.codebook.model

import kr.socar.code101.codebook.infra.ComCodeTable
import org.jetbrains.exposed.sql.ResultRow
import java.time.LocalDateTime

data class ComCodeEntity(
    val codeGroupId: String,
    val codeId: Int,
    val useYN: Boolean,
    val sortingNum: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    constructor(row: ResultRow) : this(
        codeGroupId = row[ComCodeTable.codeGroupId],
        codeId = row[ComCodeTable.codeId],
        useYN = row[ComCodeTable.useYN],
        sortingNum = row[ComCodeTable.sortingNum],
        createdAt = row[ComCodeTable.createdAt],
        updatedAt = row[ComCodeTable.updatedAt],
    )
}
