package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.infra.ComCodes
import kr.socar.code101.codebook.model.ComCode
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime

@Repository
class ComCodeRepository(private val clock: Clock) {
    fun findAll(): List<ComCode> {
        val resultRowList: List<ResultRow> = ComCodes.selectAll().toList() // DB에서 selectAll 을 한 결과
        val result = mutableListOf<ComCode>() // 여기서 부터 return 까지는 map 역할을 풀어서 쓴 부분
        resultRowList.forEach { resultRow ->
            val comCode = ComCode(resultRow)
            result.add(comCode)
        }
        return result
    }

    fun insert(codeGroupId: String, codeId: Int, useYN: Boolean, sortingNum: Int) {
        val now = LocalDateTime.now(clock)
        ComCodes.insert { table ->
            table[ComCodes.codeGroupId] = codeGroupId
            table[ComCodes.codeId] = codeId
            table[ComCodes.useYN] = useYN
            table[ComCodes.sortingNum] = sortingNum
            table[ComCodes.createdAt] = now
            table[ComCodes.updatedAt] = now
        }
    }


//
//    fun delete(codeGroupId:String, codeId: Int): List<ComCode> {
//        val query = ComCodes.select{ ComCodes.codeGroupId eq codeGroupId and (ComCodes.codeId eq codeId)}
//        val one = ComCode.wrapRows(query).firstOrNull()
//        one?.delete()
//        return findAll()
//    }
}
