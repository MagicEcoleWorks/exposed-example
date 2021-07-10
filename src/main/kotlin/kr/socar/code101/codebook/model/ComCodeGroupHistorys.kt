package kr.socar.code101.codebook.model

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object ComCodeGroupHistorys : IdTable<String>("com_code_group_history") {
    override val id: Column<EntityID<String>> = reference("code_group_id", ComCodeGroups)

    val validityStartDate: Column<LocalDateTime> = datetime("code_validity_start_date")
    val validityEndDate: Column<LocalDateTime> = datetime("code_validity_end_date")
    val bfchgCodeGroupName: Column<String> = varchar("bfchg_code_group_name", 50)
    val aftchCodeGroupName: Column<String?> = varchar("aftch_code_group_name", 50).nullable().default(null)
    val createdAt: Column<LocalDateTime> = datetime("created_at")
    val updatedAt: Column<LocalDateTime> = datetime("updated_at")
}
