package kr.socar.code101.codebook.service

import kr.socar.code101.codebook.dto.CreateComCodeInfoParams
import kr.socar.code101.codebook.dto.GetComCodeInfoParams
import kr.socar.code101.codebook.model.ComCodeInfoEntity
import kr.socar.code101.codebook.repository.ComCodeInfoRepository
import kr.socar.code101.codebook.value.ComCode
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class ComCodeInfoService(
    private val comCodeInfoRepository: ComCodeInfoRepository,
    private val database: Database,
) {
    fun createNew(p: CreateComCodeInfoParams) = transaction(database) {
        comCodeInfoRepository.insert(p.codeName, p.description)
            .run { ComCode(this) }
    }

    fun findById(id: Int): ComCodeInfoEntity? {
        return transaction(database) {
            comCodeInfoRepository.findById(id)
        }
    }

    fun findByName(name: String): ComCodeInfoEntity? {
        return transaction(database) {
            comCodeInfoRepository.findByName(name)
        }
    }
}
