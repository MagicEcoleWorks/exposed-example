package kr.socar.code101.codebook.model

import kr.socar.code101.codebook.infra.ComCodes
import org.jetbrains.exposed.sql.ResultRow
import java.time.LocalDateTime

data class ComCode(
    val codeGroupId: String,
    val codeId: Int,
    val useYN: Boolean,
    val sortingNum: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    constructor(row: ResultRow) : this(
        codeGroupId = row[ComCodes.codeGroupId],
        codeId = row[ComCodes.codeId],
        useYN = row[ComCodes.useYN],
        sortingNum = row[ComCodes.sortingNum],
        createdAt = row[ComCodes.createdAt],
        updatedAt = row[ComCodes.updatedAt],
    )
}
