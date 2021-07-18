package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.infra.ComCodeGroupHistoryTable
import kr.socar.code101.codebook.model.ComCodeGroupHistoryEntity
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.LocalDateTime

@Repository
class ComCodeGroupHistoryRepository(
        private val clock: Clock,
        private val database: Database
) {
    fun findAll(): List<ComCodeGroupHistoryEntity> = transaction(database) {
        return@transaction ComCodeGroupHistoryTable.selectAll().toList().map { ComCodeGroupHistoryEntity(it) }
    }


    fun findOne(id: String): ComCodeGroupHistoryEntity = transaction(database){
        val query = ComCodeGroupHistoryTable.select { ComCodeGroupHistoryTable.codeGroupId eq id }.first()
        return@transaction ComCodeGroupHistoryEntity(query)
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
            ComCodeGroupHistoryTable.insert { table ->
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
