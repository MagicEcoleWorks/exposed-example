package kr.socar.code101.codebook.model

import kr.socar.code101.codebook.model.ComCodeInfos.default
import kr.socar.code101.codebook.model.ComCodeInfos.nullable
import kr.socar.code101.codebook.model.ComCodeInfos.uniqueIndex
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime


object ComCodeGroups : IdTable<String>("com_code_group") {
    val codeGroupId: Column<String> = varchar("code_group_id", 4)
    val codeGroupName : Column<String>  = varchar("code_group_name", 50).uniqueIndex()
    val upperCodeGroupId : Column<String?> = varchar("upper_code_group_id", 4).nullable().default(null)
    val codeGroupDescription : Column<String?> = varchar("code_group_description", 200).nullable().default(null)
    val createdAt: Column<LocalDateTime> = datetime("created_at")
    val updatedAt: Column<LocalDateTime> = datetime("updated_at")

    override val id: Column<EntityID<String>> = codeGroupId.entityId()
}