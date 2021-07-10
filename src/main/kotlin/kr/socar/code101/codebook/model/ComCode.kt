package kr.socar.code101.codebook.model

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.EntityIDFactory
import org.jetbrains.exposed.sql.EntityIDColumnType
import java.time.LocalDateTime

class ComCode(id: EntityID<Int>) : IntEntity(id){
    companion object : IntEntityClass<ComCode>(ComCodes)

    var codeGroupId by ComCodeGroup referencedOn ComCodes.codeGroupId
    var codeId by ComCodeInfo referencedOn ComCodes.codeId
    var useYN by ComCodes.useYN
    var sortingNum by ComCodes.sortingNum
    var createdAt: LocalDateTime by ComCodes.createdAt
    var updatedAt: LocalDateTime by ComCodes.updatedAt

}