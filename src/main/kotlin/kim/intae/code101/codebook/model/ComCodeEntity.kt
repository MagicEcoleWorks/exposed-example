package kim.intae.code101.codebook.model

import kr.socar.code101.codebook.infra.ComCodeTable
import org.jetbrains.exposed.sql.ResultRow
import java.time.LocalDateTime

data class ComCodeEntity(
    val codeGroupId: String,
    val codeId: String,
    val useYn: Boolean,
    val description: String?,
    val sortingNumber: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    constructor(row: ResultRow) : this(
        codeGroupId = row[ComCodeTable.codeGroupId],
        codeId = row[ComCodeTable.codeId],
        useYn = row[ComCodeTable.useYn],
        description = row[ComCodeTable.description],
        sortingNumber = row[ComCodeTable.sortingNumber],
        createdAt = row[ComCodeTable.createdAt],
        updatedAt = row[ComCodeTable.updatedAt],
    )
}
