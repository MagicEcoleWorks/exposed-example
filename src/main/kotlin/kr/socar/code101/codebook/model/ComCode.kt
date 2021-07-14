package kr.socar.code101.codebook.model

import kr.socar.code101.codebook.infra.ComCodes
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.time.LocalDateTime
import org.jetbrains.exposed.sql.ResultRow

data class ComCode(
    val codeGroupId: String,
    val codeId: Int,
    val useYN: Boolean,
    val sortingNum: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    constructor(row: ResultRow): this(
        codeGroupId = row[ComCodes.codeGroupId],
        codeId = row[ComCodes.codeId],
        useYN = row[ComCodes.useYN],
        sortingNum = row[ComCodes.sortingNum],
        createdAt = row[ComCodes.createdAt],
        updatedAt = row[ComCodes.updatedAt],
    )
}
