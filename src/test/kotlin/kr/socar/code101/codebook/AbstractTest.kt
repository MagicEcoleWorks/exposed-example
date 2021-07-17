package kr.socar.code101.codebook

import kr.socar.code101.codebook.infra.ComCodeGroupHistorys
import kr.socar.code101.codebook.infra.ComCodeGroups
import kr.socar.code101.codebook.infra.ComCodeInfos
import kr.socar.code101.codebook.infra.ComCodes
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.annotation.Autowired

abstract class AbstractTest {
    @Autowired
    lateinit var beanFactory: BeanFactory

    @BeforeEach
    fun createTables() {
        try {
            val database = beanFactory.getBean(Database::class.java)
            transaction(database) {
                SchemaUtils.create(
                    ComCodes,
                    ComCodeInfos,
                    ComCodeGroups,
                    ComCodeGroupHistorys,
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
