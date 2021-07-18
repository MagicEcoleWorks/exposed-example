package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.infra.ComCodeTable
import kr.socar.code101.codebook.model.ComCodeEntity
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime

@Repository
class ComCodeRepository(private val clock: Clock) {
    fun findAll(): List<ComCodeEntity> {
        val resultRowList: List<ResultRow> = ComCodeTable.selectAll().toList() // DB에서 selectAll 을 한 결과
        val result = mutableListOf<ComCodeEntity>() // 여기서 부터 return 까지는 map 역할을 풀어서 쓴 부분
        resultRowList.forEach { resultRow ->
            val comCode = ComCodeEntity(resultRow)
            result.add(comCode)
        }
        return result
    }

    fun insert(codeGroupId: String, codeId: Int, useYN: Boolean, sortingNum: Int) {
        val now = LocalDateTime.now(clock)
        ComCodeTable.insert { table ->
            table[ComCodeTable.codeGroupId] = codeGroupId
            table[ComCodeTable.codeId] = codeId
            table[ComCodeTable.useYN] = useYN
            table[ComCodeTable.sortingNum] = sortingNum
            table[ComCodeTable.createdAt] = now
            table[ComCodeTable.updatedAt] = now
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
