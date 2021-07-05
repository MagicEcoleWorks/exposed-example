package kr.socar.code101.codebook.model

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object ComCodeInfos : IntIdTable("com_code_info", "code_id") {
    val codeName: Column<String> = varchar("code_name", 50).uniqueIndex()
    val description: Column<String?> = varchar("description", 200).nullable().default(null)
    val createdAt: Column<LocalDateTime> = datetime("created_at")
    val updatedAt: Column<LocalDateTime> = datetime("updated_at")
}
