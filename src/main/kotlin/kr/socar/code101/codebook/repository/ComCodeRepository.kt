package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.model.ComCode
import kr.socar.code101.codebook.model.ComCodeGroup
import kr.socar.code101.codebook.model.ComCodeInfo
import kr.socar.code101.codebook.model.ComCodes
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime

@Repository
class ComCodeRepository(private val clock: Clock) {
    fun findAll() : List<ComCode>{
        val query = ComCodes.selectAll()
        return ComCode.wrapRows(query).toList()
    }

    fun insert(codeGroupId: String, codeId: Int, useYN: Int, sortingNum: Int) : ComCode {
        val now = LocalDateTime.now(clock)
        return ComCode.new() {
            /*this.codeGroupId = codeGroupId
            this.codeId = codeId*/      //type mismatch 해결 못함
            this.useYN = useYN
            this.sortingNum = sortingNum
            this.createdAt = now
            this.updatedAt = now
        }
    }

    fun delete(codeGroupId:String, codeId: Int): List<ComCode> {
        val query = ComCodes.select{ ComCodes.codeGroupId eq codeGroupId and (ComCodes.codeId eq codeId)}
        val one = ComCode.wrapRows(query).firstOrNull()
        one?.delete()
        return findAll()
    }
}