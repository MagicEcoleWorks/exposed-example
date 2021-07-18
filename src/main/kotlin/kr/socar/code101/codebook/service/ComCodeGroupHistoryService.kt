package kr.socar.code101.codebook.service

import kr.socar.code101.codebook.repository.ComCodeGroupHistoryRepository
import org.springframework.stereotype.Service
import kr.socar.code101.codebook.dto.Result
import kr.socar.code101.codebook.model.ComCodeGroupHistoryEntity

@Service
class ComCodeGroupHistoryService (
    private val comCodeGroupHistoryRepository : ComCodeGroupHistoryRepository
){
    fun createComCodeGroupHistory(id: String, codeGroupName: String): Result {
        comCodeGroupHistoryRepository.insert(id, codeGroupName)
        return Result.SUCCESS
    }

    fun findComCodeGroupHistory(): List<ComCodeGroupHistoryEntity> {
        return comCodeGroupHistoryRepository.findAll()
    }

    fun findEachComCodeGroupHistory(id: String) = comCodeGroupHistoryRepository.findOne(id)
}
