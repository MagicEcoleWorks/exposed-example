package kim.intae.code101.codebook.service

import kim.intae.code101.codebook.dto.ComCodeInfoDto
import kim.intae.code101.codebook.dto.CreateNewCodeParams
import kim.intae.code101.codebook.repository.ComCodeInfoRepository
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class ComCodeInfoService(
    private val comCodeInfoRepository: ComCodeInfoRepository,
    private val database: Database,
) {
    fun createNewCode(p: CreateNewCodeParams) = transaction(database) {
        ComCodeInfoDto(comCodeInfoRepository.insert(p.codeId, p.codeName))
    }

    fun getCode() = transaction(database) {
        comCodeInfoRepository.findAll().map { ComCodeInfoDto(it) }
    }
}
