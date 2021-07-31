package kr.socar.code101.codebook.model

import kr.socar.code101.codebook.infra.ComCodeInfoTable
import org.jetbrains.exposed.sql.ResultRow
import java.time.LocalDateTime

data class ComCodeInfoEntity(
    val codeId: String,
    val codeName: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    constructor(row: ResultRow) : this(
        codeId = row[ComCodeInfoTable.codeId],
        codeName = row[ComCodeInfoTable.codeName],
        createdAt = row[ComCodeInfoTable.createdAt],
        updatedAt = row[ComCodeInfoTable.updatedAt]
    )
}
