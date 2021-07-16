package kr.socar.code101.codebook

import org.jetbrains.exposed.sql.Database
import org.springframework.beans.factory.annotation.Autowired

abstract class AbstractServiceTest : AbstractCodebookTest() {
    @Autowired
    lateinit var database: Database
}
