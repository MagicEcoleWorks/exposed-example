package kr.socar.code101.codebook.model

import kr.socar.code101.codebook.infra.ComCodeInfoTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.time.LocalDateTime

class ComCodeInfoEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ComCodeInfoEntity>(ComCodeInfoTable)

    var codeName: String by ComCodeInfoTable.codeName
    var description: String? by ComCodeInfoTable.description
    var createdAt: LocalDateTime by ComCodeInfoTable.createdAt
    var updatedAt: LocalDateTime by ComCodeInfoTable.updatedAt
}
