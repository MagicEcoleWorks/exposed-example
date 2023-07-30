package kim.intae.code101.codebook.service

import kr.socar.code101.codebook.repository.ComCodeGroupHistoryRepository
import org.springframework.stereotype.Service

@Service
class ComCodeGroupHistoryService(
    private val comCodeGroupHistoryRepository: ComCodeGroupHistoryRepository
)
