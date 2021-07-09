package kr.socar.code101.codebook.model

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.update
import java.time.LocalDateTime

class ComCodeGroupHistory(id: EntityID<String>): Entity<String>(id = id) {
    companion object: EntityClass<String, ComCodeGroupHistory>(ComCodeGroupHistorys)

    var validityStartDate: LocalDateTime by ComCodeGroupHistorys.validityStartDate
    var validityEndDate: LocalDateTime by ComCodeGroupHistorys.validityEndDate
    var bfchgCodeGroupName: String by ComCodeGroupHistorys.bfchgCodeGroupName
    var aftchCodeGroupName: String? by ComCodeGroupHistorys.aftchCodeGroupName
    var createdAt: LocalDateTime by ComCodeGroupHistorys.createdAt
    var updatedAt: LocalDateTime by ComCodeGroupHistorys.updatedAt

}