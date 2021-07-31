package kr.socar.code101.codebook.service

import kr.socar.code101.codebook.dto.CreateNewCodeParams
import kr.socar.code101.codebook.repository.ComCodeInfoRepository
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class ComCodeInfoService(
    private val comCodeInfoRepository: ComCodeInfoRepository,
    private val database: Database,
) {
    fun createNew(p: CreateNewCodeParams) = transaction(database) {
        return@transaction comCodeInfoRepository.insert(p.codeId, p.codeName)
    }
}
