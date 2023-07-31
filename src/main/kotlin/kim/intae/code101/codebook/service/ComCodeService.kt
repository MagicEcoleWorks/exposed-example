package kim.intae.code101.codebook.service

import kim.intae.code101.codebook.repository.ComCodeRepository
import org.springframework.stereotype.Service

@Service
class ComCodeService(
    private val comCodeRepository: ComCodeRepository
)
