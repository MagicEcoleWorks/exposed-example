package kr.socar.code101.codebook.service

import kr.socar.code101.codebook.dto.ApiEmptyResponse
import kr.socar.code101.codebook.dto.CreateComCodeInfoParams
import kr.socar.code101.codebook.dto.GetComCodeInfoParams
import kr.socar.code101.codebook.model.ComCodeInfo
import kr.socar.code101.codebook.repository.ComCodeInfoRepository
import org.springframework.stereotype.Service

@Service
class ComCodeInfoService(
    private val comCodeInfoRepository: ComCodeInfoRepository
) {
    fun createComCodeInfo(createComCodeInfoParams: CreateComCodeInfoParams): ApiEmptyResponse {
        val codeName = createComCodeInfoParams.codeName
        val description = createComCodeInfoParams.description
        comCodeInfoRepository.create(codeName, description)
        return ApiEmptyResponse()
    }

    fun getComCodeInfo(getComCodeInfoParams: GetComCodeInfoParams): ComCodeInfo? {
        TODO("Not yet implemented")
    }
}
