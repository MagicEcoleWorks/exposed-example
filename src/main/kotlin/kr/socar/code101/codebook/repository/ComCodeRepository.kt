package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.model.ComCode
import kr.socar.code101.codebook.model.ComCodeGroup
import kr.socar.code101.codebook.model.ComCodeInfo
import kr.socar.code101.codebook.model.ComCodes
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
        return ComCode.new {
            this.codeGroupID = codeGroupID
            this.codeId = codeId
            this.useYN = useYN
            this.sortingNum = sortingNum
            this.createdAt = now
            this.updatedAt = now
        }
    }
}