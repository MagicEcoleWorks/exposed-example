package kr.socar.code101.codebook.service

import kr.socar.code101.codebook.AbstractCodebookTest
import kr.socar.code101.codebook.dto.CreateComCodeGroupParams
import kr.socar.code101.codebook.dto.ModifyComCodeGroupParams
import kr.socar.code101.codebook.infra.ComCodeGroupTable
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class ComCodeGroupServiceTest : AbstractCodebookTest() {
    @Autowired
    lateinit var comCodeGroupService: ComCodeGroupService

    @Test
    fun createGroupNewTest() {
        val codeGroupId = "002"
        val codeGroupName = "B"
        val description = "설명설명설명설명설명"
        val createComCodeGroupParams = CreateComCodeGroupParams(
            codeGroupId = codeGroupId,
            codeGroupName = codeGroupName,
            description = description
        )

        val result = comCodeGroupService.createCodeGroup(createComCodeGroupParams)
        assertThat(result).isNotNull
        assertThat(result!!.codeGroupId).isEqualTo(codeGroupId)
        assertThat(result.codeGroupName).isEqualTo(codeGroupName)
        assertThat(result.description).isEqualTo(description)
    }

    @Test
    fun modifyGroupNewTest() {
        val codeGroupId = "002"
        val codeGroupName = "B"
        val originDescription = "설명수정전"
        val newDescription = "설명수정후"
        comCodeGroupService.createCodeGroup(
            CreateComCodeGroupParams(
                codeGroupId = codeGroupId,
                codeGroupName = codeGroupName,
                description = originDescription
            )
        )

        val originResult = comCodeGroupService.findById(codeGroupId)
        assertThat(originResult).isNotNull
        assertThat(originResult!!.description).isEqualTo(originDescription)

        val modifyComCodeGroupParams = ModifyComCodeGroupParams(
            codeGroupId = codeGroupId,
            description = newDescription
        )

        comCodeGroupService.modifyGroup(modifyComCodeGroupParams)

        val result = comCodeGroupService.findById(codeGroupId)
        assertThat(result).isNotNull
        assertThat(result!!.description).isEqualTo(newDescription)
    }

    @AfterEach
    fun cleanUp() {
        transaction(database) {
            ComCodeGroupTable.deleteAll()
        }
    }
}
