package kr.socar.code101.codebook

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
abstract class AbstractCodebookTest : AbstractTest()
