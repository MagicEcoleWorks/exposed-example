package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.model.ComCodeGroup
import kr.socar.code101.codebook.infra.ComCodeGroups
import org.jetbrains.exposed.sql.*
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime

@Repository
class ComCodeGroupRepository(private val clock: Clock) {
    fun findAll(): List<ComCodeGroup> {
        val query: Query = ComCodeGroups.selectAll()
        return ComCodeGroup.wrapRows(query).toList()
    }

    fun findOne(id: String): String?{
        val query = ComCodeGroups.select{ ComCodeGroups.id eq id}
        val one = ComCodeGroup.wrapRows(query).firstOrNull()
        return "{codeGroupId: "+id + ", codeGroupName: +${one?.codeGroupName}, upperCodeGroupId: +${one?.upperCodeGroupId}, codeGroupDescription: +${one?.codeGroupDescription}, created:${one?.createdAt}, updated:${one?.updatedAt}"
    }

    fun insert(id: String , codeGroupName: String, upperCodeGroupId: String?=null, codeGroupDescription: String? = null): ComCodeGroup {
        val now = LocalDateTime.now(clock)
        return ComCodeGroup.new(id) {
            this.codeGroupId = codeGroupId
            this.codeGroupName = codeGroupName
            this.upperCodeGroupId = upperCodeGroupId
            this.codeGroupDescription = codeGroupDescription
            this.createdAt = now
            this.updatedAt = now
        }
    }
}
