package kim.intae.code101.codebook.repository

import kr.socar.code101.codebook.AbstractCodebookTest
import kr.socar.code101.codebook.infra.ComCodeGroupTable
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import support.MockClock

class ComCodeGroupRepositoryTest : AbstractCodebookTest() {
    private var repository: ComCodeGroupRepository = ComCodeGroupRepository(MockClock())

    @Test
    fun createGroupRepository() {
        transaction(database) {
            repository.insert(
                codeGroupId = "1",
                codeGroupName = "test01",
                parentCodeGroupId = null,
                description = "설명"
            )
            val result = repository.findById("1")
            assertThat(result).isNotNull
            assertThat(result!!.codeGroupId).isEqualTo("1")
            assertThat(result.parentCodeGroupId).isEqualTo(null)
        }
    }

    @Test
    fun updateGroupRepository() {
        transaction(database) {
            val codeGroupId = "1"
            val originalDescription = "test"
            val newDescription = "변경"
            repository.insert(
                codeGroupId = codeGroupId,
                codeGroupName = "update test",
                parentCodeGroupId = null,
                description = originalDescription
            )

            val originResult = repository.findById(codeGroupId)
            assertThat(originResult).isNotNull
            assertThat(originResult!!.description).isEqualTo(originalDescription)

            repository.update(
                codeGroupId = "1",
                description = newDescription
            )

            val newResult = repository.findById(codeGroupId)
            assertThat(newResult).isNotNull
            assertThat(newResult!!.description).isEqualTo(newDescription)
        }
    }

    @AfterEach
    fun cleanUp() {
        transaction {
            ComCodeGroupTable.deleteAll()
        }
    }
}
