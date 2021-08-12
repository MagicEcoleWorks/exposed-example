package kr.socar.code101.codebook.service

import kr.socar.code101.codebook.dto.ComCodeGroupDto
import kr.socar.code101.codebook.dto.CreateComCodeGroupParams
import kr.socar.code101.codebook.dto.ModifyComCodeGroupParams

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

    fun findAll() = transaction(database) {
        comCodeGroupRepository.findAll()
    }

    fun modifyGroup(p: ModifyComCodeGroupParams) = transaction(database) {
        // 1. 필요한 파라미터 : codeGroupId, description
        val codeGroupId = p.codeGroupId
        val description = p.description
        // 2. repository 에 업데이트
        comCodeGroupRepository.update(codeGroupId, description)
        // 3. 업데이트한 codeGroupId 를 이용해 repository 에서 찾아 리턴
        return@transaction comCodeGroupRepository.findById(codeGroupId)?.let { ComCodeGroupDto(it) } // 수정
    }

    fun findById(codeGroupId: String) = transaction(database) {
        comCodeGroupRepository.findById(codeGroupId = codeGroupId)
    }
}
