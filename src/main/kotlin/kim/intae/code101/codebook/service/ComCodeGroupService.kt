package kim.intae.code101.codebook.service

import kr.socar.code101.codebook.dto.ComCodeGroupDto
import kr.socar.code101.codebook.dto.CreateComCodeGroupParams
import kr.socar.code101.codebook.dto.ModifyComCodeGroupParams
import kr.socar.code101.codebook.model.ComCodeGroupEntity
import kr.socar.code101.codebook.repository.ComCodeGroupRepository
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class ComCodeGroupService(
    private val comCodeGroupRepository: ComCodeGroupRepository,
    private val database: Database,
) {
    fun createCodeGroup(p: CreateComCodeGroupParams): ComCodeGroupEntity? = transaction(database) {
        comCodeGroupRepository.insert(p.codeGroupId, p.codeGroupName, p.parentCodeGroupId, p.description) // insert 하는 부분
        return@transaction comCodeGroupRepository.findById(p.codeGroupId)
    }

    fun findAll() = transaction(database) {
        comCodeGroupRepository.findAll()
    }

    fun modifyGroup(p: ModifyComCodeGroupParams) = transaction(database) {
        val codeGroupId = p.codeGroupId
        val description = p.description
        comCodeGroupRepository.update(codeGroupId, description)
        return@transaction comCodeGroupRepository.findById(codeGroupId)?.let { ComCodeGroupDto(it) } // 수정
    }

    fun findById(codeGroupId: String) = transaction(database) {
        comCodeGroupRepository.findById(codeGroupId = codeGroupId)
    }
}
