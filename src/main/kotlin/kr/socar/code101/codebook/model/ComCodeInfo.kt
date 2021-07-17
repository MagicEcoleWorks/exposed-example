package kr.socar.code101.codebook.model

import kr.socar.code101.codebook.infra.ComCodeInfos
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.time.LocalDateTime

class ComCodeInfo(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ComCodeInfo>(ComCodeInfos)

    var codeName: String by ComCodeInfos.codeName
    var description: String? by ComCodeInfos.description
    var createdAt: LocalDateTime by ComCodeInfos.createdAt
    var updatedAt: LocalDateTime by ComCodeInfos.updatedAt
}
