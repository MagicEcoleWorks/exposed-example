package kr.socar.code101.codebook.model

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object ComCodes : IntIdTable() {
    val codeGroupID = reference("codeGroupId", ComCodeGroups)
    val codeId = reference("code_id", ComCodeInfos)

    val useYN: Column<Int> = integer("use_yn")
    val sortingNum: Column<Int> = integer("sorting_number")
    val createdAt: Column<LocalDateTime> = datetime("created_at")
    val updatedAt: Column<LocalDateTime> = datetime("updated_at")

}
