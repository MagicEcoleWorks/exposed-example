package kr.socar.code101.codebook

import org.jetbrains.exposed.sql.Database
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
abstract class AbstractCodebookTest : AbstractTest() {
    @Autowired
    lateinit var database: Database
}
