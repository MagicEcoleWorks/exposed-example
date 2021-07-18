package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.infra.ComCodeGroupTable
import kr.socar.code101.codebook.model.ComCodeGroupEntity
import kr.socar.code101.codebook.vo.ComCodeGroupVo
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime

@Repository
class ComCodeGroupRepository(private val clock: Clock) {
    fun findAll(): List<ComCodeGroupEntity> {
        val query: Query = ComCodeGroupTable.selectAll()
        return ComCodeGroupEntity.wrapRows(query).toList()
    }

    fun findOne(id: String): String?{
        val query = ComCodeGroupTable.select{ ComCodeGroupTable.id eq id}
        val one = ComCodeGroupEntity.wrapRows(query).firstOrNull()
        return "{codeGroupId: "+id + ", codeGroupName: +${one?.codeGroupName}, upperCodeGroupId: +${one?.upperCodeGroupId}, codeGroupDescription: +${one?.codeGroupDescription}, created:${one?.createdAt}, updated:${one?.updatedAt}"
    }

    fun insert(comCodeGroupVo: ComCodeGroupVo): ComCodeGroupEntity {
        val now = LocalDateTime.now(clock)
        return ComCodeGroupEntity.new(comCodeGroupVo.id) {
            // this.codeGroupId = codeGroupId
            this.codeGroupName = comCodeGroupVo.codeGroupName
            this.upperCodeGroupId = comCodeGroupVo.upperCodeGroupId
            this.codeGroupDescription = comCodeGroupVo.codeGroupDescription
            this.createdAt = now
            this.updatedAt = now
        }
    }
}
