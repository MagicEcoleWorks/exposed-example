package kr.socar.code101.codebook.service

import kr.socar.code101.codebook.dto.CreateComCodeGroupParams
import kr.socar.code101.codebook.repository.ComCodeGroupRepository
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class ComCodeGroupService(
    private val comCodeGroupRepository: ComCodeGroupRepository,
    private val database: Database,
) {
    fun createCodeGroup(p: CreateComCodeGroupParams) = transaction(database) {
        return@transaction comCodeGroupRepository.insert(p.codeGroupId, p.codeGroupName, p.parentCodeGroupId, p.description)
    }
}
