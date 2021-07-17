package kr.socar.code101.codebook.model

import kr.socar.code101.codebook.infra.ComCodeGroups
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ComCodeGroup(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, ComCodeGroup>(ComCodeGroups)

    var codeGroupId by ComCodeGroups.id
    var codeGroupName by ComCodeGroups.codeGroupName
    var upperCodeGroupId by ComCodeGroups.upperCodeGroupId
    var codeGroupDescription by ComCodeGroups.codeGroupDescription
    var createdAt by ComCodeGroups.createdAt
    var updatedAt by ComCodeGroups.updatedAt
}
