package kim.intae.code101.codebook.service

import kr.socar.code101.codebook.AbstractCodebookTest
import kr.socar.code101.codebook.dto.CreateNewCodeParams
import kr.socar.code101.codebook.infra.ComCodeInfoTable
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class ComCodeInfoServiceTest : AbstractCodebookTest() {
    @Autowired
    lateinit var comCodeInfoService: ComCodeInfoService

    @Test
    fun createNewTest() {
        val codeId = "001"
        val codeName = "테스트"
        val createComCodeInfoParams = CreateNewCodeParams(codeId = codeId, codeName = codeName)
        val result = comCodeInfoService.createNewCode(createComCodeInfoParams)
        assertThat(result.codeId).isEqualTo(codeId)
        assertThat(result.codeName).isEqualTo(codeName)
    }

    @Test
    fun getTest() {
        // given
        val codeIdList = listOf("001", "002")
        val codeNameList = listOf("테스트001", "테스트002")
        (0..1).forEach {
            val p = CreateNewCodeParams(codeId = codeIdList[it], codeName = codeNameList[it])
            comCodeInfoService.createNewCode(p)
        }

        // when
        val result = comCodeInfoService.getCode()

        // then
        assertThat(result).hasSize(2)
        assertThat(result.map { it.codeId }).containsExactlyInAnyOrderElementsOf(codeIdList)
        assertThat(result.map { it.codeName }).containsExactlyInAnyOrderElementsOf(codeNameList)
    }

    @AfterEach
    fun cleanUp() {
        transaction(database) {
            ComCodeInfoTable.deleteAll()
        }
    }
}
