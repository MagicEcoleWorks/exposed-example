package kr.socar.code101.codebook.repository

import org.springframework.stereotype.Repository
import java.time.Clock

@Repository
class ComCodeRepository(private val clock: Clock)
