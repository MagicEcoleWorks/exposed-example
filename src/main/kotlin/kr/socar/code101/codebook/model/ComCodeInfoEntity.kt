package kr.socar.code101.codebook.model

import kr.socar.code101.codebook.infra.ComCodeInfoTable
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.time.LocalDateTime

class ComCodeInfoEntity(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, ComCodeInfoEntity>(ComCodeInfoTable)

    var codeId: String by ComCodeInfoTable.codeId
    var codeName: String by ComCodeInfoTable.codeName
    var createdAt: LocalDateTime by ComCodeInfoTable.createdAt
    var updatedAt: LocalDateTime by ComCodeInfoTable.updatedAt
}
