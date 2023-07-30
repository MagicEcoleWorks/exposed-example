package kim.intae.code101.codebook.infra

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object ComCodeInfoTable : Table("com_code_info") {
    val codeId: Column<String> = varchar("code_id", 3)
    val codeName: Column<String> = varchar("code_name", 64).uniqueIndex()
    val createdAt: Column<LocalDateTime> = datetime("created_at")
    val updatedAt: Column<LocalDateTime> = datetime("updated_at")

    override val primaryKey: PrimaryKey = PrimaryKey(codeId)
}
