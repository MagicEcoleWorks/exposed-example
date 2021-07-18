package kr.socar.code101.codebook.model

import kr.socar.code101.codebook.infra.ComCodeGroupTable
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ComCodeGroupEntity(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, ComCodeGroupEntity>(ComCodeGroupTable)

    var codeGroupId by ComCodeGroupTable.id
    var codeGroupName by ComCodeGroupTable.codeGroupName
    var upperCodeGroupId by ComCodeGroupTable.upperCodeGroupId
    var codeGroupDescription by ComCodeGroupTable.codeGroupDescription
    var createdAt by ComCodeGroupTable.createdAt
    var updatedAt by ComCodeGroupTable.updatedAt
}
