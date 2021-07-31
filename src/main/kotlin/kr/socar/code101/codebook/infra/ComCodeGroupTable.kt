package kr.socar.code101.codebook.infra

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object ComCodeGroupTable : Table("com_code_group") {
    val codeGroupId: Column<String> = varchar("code_group_id", 4)
    val codeGroupName: Column<String> = varchar("code_group_name", 100)
    val parentCodeGroupId: Column<String?> =
        (varchar("parent_code_group_id", 4) references codeGroupId).nullable().default(null)
    val codeGroupDescription: Column<String?> = varchar("code_group_description", 200).nullable().default(null)
    val createdAt: Column<LocalDateTime> = datetime("created_at")
    val updatedAt: Column<LocalDateTime> = datetime("updated_at")

    override val primaryKey: PrimaryKey = PrimaryKey(codeGroupId)
}
