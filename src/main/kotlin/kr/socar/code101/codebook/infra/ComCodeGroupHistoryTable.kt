package kr.socar.code101.codebook.infra

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object ComCodeGroupHistoryTable : Table("com_code_group_history") {
    val codeGroupId: Column<String> = varchar("code_group_id", 4) references ComCodeGroupTable.codeGroupId
    val codeValidityStartDate: Column<LocalDateTime> = datetime("code_validity_start_date")
    val codeValidityEndDate: Column<LocalDateTime> = datetime("code_validity_end_date")
    val codeGroupName: Column<String> = varchar("code_group_name", 100)
    val createdAt: Column<LocalDateTime> = datetime("created_at")
    val updatedAt: Column<LocalDateTime> = datetime("updated_at")

    override val primaryKey: PrimaryKey = PrimaryKey(codeGroupId, codeValidityStartDate)
}
