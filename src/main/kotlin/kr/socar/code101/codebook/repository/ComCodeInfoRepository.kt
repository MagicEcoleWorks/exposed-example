package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.infra.ComCodeInfos
import kr.socar.code101.codebook.model.ComCodeInfo
import kr.socar.code101.codebook.vo.ComCodeInfoVo
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime

@Repository
class ComCodeInfoRepository(
    private val clock: Clock
) {
    fun insert(comCodeInfoVo: ComCodeInfoVo): ComCodeInfo {
        val now = LocalDateTime.now(clock)
        return ComCodeInfo.new {
            this.codeName = comCodeInfoVo.codeName
            this.description = comCodeInfoVo.description
            this.createdAt = now
            this.updatedAt = now
        }
    }
    
    fun findOne(id: Int): ComCodeInfo? {
        val query = ComCodeInfos.select { ComCodeInfos.id eq id }
        return ComCodeInfo.wrapRows(query).firstOrNull()
    }

    fun update(id: Int, description: String? = null): ComCodeInfo? {
        val now = LocalDateTime.now(clock)
        val query = ComCodeInfos.select { ComCodeInfos.id eq id }
        val one = ComCodeInfo.wrapRows(query).firstOrNull()
        one?.description = description
        one?.updatedAt = now
        return findOne(id)
    }
}
