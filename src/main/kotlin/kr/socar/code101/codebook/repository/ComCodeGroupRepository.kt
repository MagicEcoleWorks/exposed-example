package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.model.ComCodeGroup
import kr.socar.code101.codebook.infra.ComCodeGroups
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

    fun insert(id: String, codeGroupName: String, upperCodeGroupId: String? = null, codeGroupDescription: String? = null): ComCodeGroup {
        val now = LocalDateTime.now(clock)
        return ComCodeGroup.new(id) {
            // this.codeGroupId = codeGroupId
            this.codeGroupName = codeGroupName
            this.upperCodeGroupId = upperCodeGroupId
            this.codeGroupDescription = codeGroupDescription
            this.createdAt = now
            this.updatedAt = now
        }
    }
}
