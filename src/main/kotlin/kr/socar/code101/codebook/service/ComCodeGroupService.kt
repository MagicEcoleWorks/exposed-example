package kr.socar.code101.codebook.service

import kr.socar.code101.codebook.repository.ComCodeGroupRepository
import org.springframework.stereotype.Service

@Service
class ComCodeGroupService(
    private val comCodeGroupRepository: ComCodeGroupRepository
)
