package kr.socar.code101.codebook.repository

import kr.socar.code101.codebook.AbstractCodebookTest
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.exposed.sql.transactions.transaction
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
            val find = repository.findById("1")!!
            assertThat(find.codeGroupId).isEqualTo("1")
            assertThat(find.parentCodeGroupId).isEqualTo(null)
        }
    }

    @Test
    fun updateGroupRepository() {
        transaction(database) {
            repository.update(
                codeGroupId = "1",
                description = "변경"
            )
            val find = repository.findById("1")!!
            assertThat(find.description).isEqualTo("변경")
        }
    }
}