package kr.socar.code101.codebook.repository

import org.springframework.stereotype.Repository
import java.time.Clock

@Repository
class ComCodeGroupRepository(private val clock: Clock)
