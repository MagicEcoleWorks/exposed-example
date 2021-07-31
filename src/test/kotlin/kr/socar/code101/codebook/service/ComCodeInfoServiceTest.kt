package kr.socar.code101.codebook.service

import kr.socar.code101.codebook.AbstractServiceTest
import kr.socar.code101.codebook.dto.CreateNewCodeParams
import kr.socar.code101.codebook.infra.ComCodeInfoTable
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class ComCodeInfoServiceTest : AbstractServiceTest() {
    @Autowired
    lateinit var comCodeInfoService: ComCodeInfoService

    @Test
    fun createNewTest() {
        val codeId = "001"
        val codeName = "테스트"
        val createComCodeInfoParamsWithDescriptionIsNull = CreateNewCodeParams(codeId = codeId, codeName = codeName)
        val result = comCodeInfoService.createNew(createComCodeInfoParamsWithDescriptionIsNull)
        assertThat(result.codeId).isEqualTo(codeId)
        assertThat(result.codeName).isEqualTo(codeName)
    }

    @AfterEach
    fun cleanUp() {
        transaction(database) {
            ComCodeInfoTable.deleteAll()
        }
    }
}
