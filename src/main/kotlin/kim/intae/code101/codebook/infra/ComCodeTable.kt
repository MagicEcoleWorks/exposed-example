package kim.intae.code101.codebook.infra

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object ComCodeTable : Table("com_code") {
    val codeGroupId: Column<String> = varchar("code_group_id", 4) references ComCodeGroupTable.codeGroupId
    val codeId: Column<String> = varchar("code_id", 3) references ComCodeInfoTable.codeId

    val useYn: Column<Boolean> = bool("use_yn")
    val description: Column<String?> = varchar("description", 200).nullable().default(null)
    val sortingNumber: Column<Int> = integer("sorting_number")
    val createdAt: Column<LocalDateTime> = datetime("created_at")
    val updatedAt: Column<LocalDateTime> = datetime("updated_at")

    override val primaryKey: PrimaryKey = PrimaryKey(codeGroupId, codeId)
}
