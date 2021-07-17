package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.infra.ComCodeGroups
import kr.socar.code101.codebook.model.ComCodeGroup
import kr.socar.code101.codebook.vo.ComCodeGroupVo
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.selectAll
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

    fun insert(comCodeGroupVo: ComCodeGroupVo): ComCodeGroup {
        val now = LocalDateTime.now(clock)
        return ComCodeGroup.new(comCodeGroupVo.id) {
            // this.codeGroupId = codeGroupId
            this.codeGroupName = comCodeGroupVo.codeGroupName
            this.upperCodeGroupId = comCodeGroupVo.upperCodeGroupId
            this.codeGroupDescription = comCodeGroupVo.codeGroupDescription
            this.createdAt = now
            this.updatedAt = now
        }
    }
}
