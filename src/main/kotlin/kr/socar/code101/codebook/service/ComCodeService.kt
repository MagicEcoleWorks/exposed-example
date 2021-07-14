package kr.socar.code101.codebook.service

import kr.socar.code101.codebook.dto.CreateComCodeInfoParams
import kr.socar.code101.codebook.dto.GetComCodeInfoParams
import kr.socar.code101.codebook.model.ComCodeInfo
import kr.socar.code101.codebook.repository.ComCodeRepository
import org.springframework.stereotype.Service

@Service
class ComCodeService(
    private val comCodeRepository: ComCodeRepository
) {
    fun createComCodeInfo(createComCodeInfoParams: CreateComCodeInfoParams) {
        TODO("Not yet implemented")
    }

    fun getComCodeInfo(getComCodeInfoParams: GetComCodeInfoParams): ComCodeInfo? {
        TODO("Not yet implemented")
    }
}
