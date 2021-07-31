package kr.socar.code101.codebook.infra

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object ComCodeInfoTable : IdTable<String>("com_code_info") {
    val codeId: Column<String> = varchar("code_id", 3)
    val codeName: Column<String> = varchar("code_name", 64).uniqueIndex()
    val createdAt: Column<LocalDateTime> = datetime("created_at")
    val updatedAt: Column<LocalDateTime> = datetime("updated_at")

    override val id: Column<EntityID<String>> = codeId.entityId()
}
