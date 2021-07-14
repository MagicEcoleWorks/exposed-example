package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.model.ComCodeGroupHistory
import kr.socar.code101.codebook.infra.ComCodeGroupHistorys
import org.jetbrains.exposed.sql.*
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime


@Repository
class ComCodeGroupHistoryRepository(private val clock: Clock) {
    fun findAll(): List<ComCodeGroupHistory> {
        return ComCodeGroupHistorys.selectAll().toList().map { ComCodeGroupHistory(it) }
    }


    //fun findOne(id: String): ComCodeGroupHistory? {
       // val query = ComCodeGroupHistorys.select { ComCodeGroupHistorys.id eq id }
       // return ComCodeGroupHistory.wrapRows(query).firstOrNull()
    //}

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
       ComCodeGroupHistorys.insert { table ->
           table[codeGroupId] = codeGroupId
           table[validityStartDate] = now
           table[validityEndDate] = LocalDateTime.MAX
           table[bfchgCodeGroupName] = codeGroupName
           table[createdAt] = now
           table[updatedAt] = now
       }
   }
}
