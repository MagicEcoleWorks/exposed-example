package kr.socar.code101.codebook.service

import kr.socar.code101.codebook.repository.ComCodeInfoRepository
import org.springframework.stereotype.Service

@Service
class ComCodeInfoService(
    private val comCodeInfoRepository: ComCodeInfoRepository
) {
}
