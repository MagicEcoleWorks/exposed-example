package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.infra.ComCodeGroupHistorys
import org.jetbrains.exposed.sql.transactions.transaction
import kr.socar.code101.codebook.infra.ComCodeInfos
import kr.socar.code101.codebook.model.ComCodeGroupHistory
import kr.socar.code101.codebook.model.ComCodeInfo
import kr.socar.code101.codebook.vo.ComCodeGroupHistoryVo
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime

@Repository
class ComCodeGroupHistoryRepository(
        private val clock: Clock,
        private val database: Database
) {
    fun findAll(): List<ComCodeGroupHistory> = transaction(database) {
        return@transaction ComCodeGroupHistorys.selectAll().toList().map { ComCodeGroupHistory(it) }
    }


    fun findOne(id: String): ComCodeGroupHistory = transaction(database){
        val query = ComCodeGroupHistorys.select { ComCodeGroupHistorys.codeGroupId eq id }.first()
        return@transaction ComCodeGroupHistory(query)
    }

//    fun update(codeGroupId: String, codeVarildyStartDate : String,  codeGroupName : String) : Int {
//        val now = LocalDateTime.now(clock)
//        return ComCodeGroupHistorys.update({
//            ComCodeGroupHistorys.id eq id
//        }) {
//            it[this.bfchgCodeGroupName] = codeGroupName
//            it[this.updatedAt] = now
//        }
//    }

    fun insert(id: String, codeGroupName: String) {
        val now = LocalDateTime.now(clock)
        transaction(database) {
            ComCodeGroupHistorys.insert { table ->
                table[codeGroupId] = id
                table[validityStartDate] = now
                table[validityEndDate] = now
                table[bfchgCodeGroupName] = codeGroupName
                table[createdAt] = now
                table[updatedAt] = now
            }
        }
    }
}
