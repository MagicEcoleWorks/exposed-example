package kr.socar.code101.codebook.controller

import kr.socar.code101.codebook.model.ComCodeInfo
import kr.socar.code101.codebook.vo.ComCodeInfoVo
import kr.socar.code101.codebook.repository.ComCodeGroupHistoryRepository
import kr.socar.code101.codebook.repository.ComCodeGroupRepository
import kr.socar.code101.codebook.repository.ComCodeInfoRepository
import kr.socar.code101.codebook.repository.ComCodeRepository
import kr.socar.code101.codebook.vo.ComCodeGroupHistoryVo
import kr.socar.code101.codebook.vo.ComCodeGroupVo
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.web.bind.annotation.*

@RestController
class CodeAdminController(
        private val comCodeInfoRepository: ComCodeInfoRepository,
        private val comCodeRepository: ComCodeRepository,
        private val comCodeGroupRepository: ComCodeGroupRepository,
        private val comCodeGroupHistoryRepository: ComCodeGroupHistoryRepository,
        private val database: Database
) {
    // com_code_info CRU
    @PostMapping("/com_code_info/new")
    fun createNewComCodeInfo(
        @RequestBody comCodeInfoVo: ComCodeInfoVo): String = transaction(database) {
        comCodeInfoRepository.insert(comCodeInfoVo)
        return@transaction fetchComCodeInfo()
    }

    @GetMapping("/com_code_info/list")
    fun fetchComCodeInfo(): String = transaction(database) {
        return@transaction "[ " + comCodeInfoRepository.findAll()
            .joinToString { "{ code_id:${it.id.value}, code_name:${it.codeName}, description:${it.description}, created:${it.createdAt}, updated:${it.updatedAt} } <br>".trimMargin() } + " ]"
    }

    @GetMapping("/com_code_info/each")
    fun fetchComCodeInfo(@RequestParam id: Int): String? = transaction(database) {
        val result = comCodeInfoRepository.findOne(id)
        return@transaction "{code_id: " + id + ", code_name:${result?.codeName}, description:${result?.description}, " +
                           "created:${result?.createdAt}, updated:${result?.updatedAt}}"
    }

    @GetMapping("/com_code_info/update")
    fun modifyComCodeInfo(
        @RequestParam id: Int,
        @RequestParam description: String?
    ): ComCodeInfo? = transaction(database) {
        return@transaction comCodeInfoRepository.update(id, description)
    }

    // com_code_group CRUD
    @GetMapping("/comCodeGroupFind")
    fun comCodeGroupFind(): String = transaction(database) {
        val result = comCodeGroupRepository.findAll()
        return@transaction result.joinToString { comCodeGroup -> "id: ${comCodeGroup.id.value}, name: ${comCodeGroup.codeGroupName} </br>" }
    }

    @PostMapping("/comCodeGroupInsert")
    fun comCodeGroup(
        @RequestBody comCodeGroupVo: ComCodeGroupVo): String = transaction(database) {
        val result = comCodeGroupRepository.insert(comCodeGroupVo)
        return@transaction "id: ${result.id.value}, name: ${result.codeGroupName}, created: ${result.createdAt}"
    }

    // com_code CRD
    @GetMapping("/com_code/findAll")
    fun fetchComCode(): String = transaction(database) {
        return@transaction "[ " + comCodeRepository.findAll()
            .joinToString { "{ codeGroupId: ${it.codeGroupId}, code_id:${it.codeId}, useYN: ${it.useYN}, sortingNum: ${it.sortingNum}, created:${it.createdAt}, updated:${it.updatedAt} } <br>".trimMargin() } + " ]"
    }

    //com_code_group_history CR
    @GetMapping("/com_code_group_history/new")
    fun createNewComCodeGroupHistory(
            @RequestParam("id") id: String,
            @RequestParam("name") codeGroupName: String
    ): String = transaction(database) {
        val result = comCodeGroupHistoryRepository.insert(id, codeGroupName)
        return@transaction "code_group_id:${id}, code_validity_start_date:${result?.validityStartDate}, code_validity_end_date:${result?.validityEndDate}, <br>" +
                "bfchg_code_group_name:${result?.bfchgCodeGroupName}, aftch_code_group_name:${result?.aftchCodeGroupName}, <br>" +
                "created_at:${result?.createdAt}, updated_at:${result?.updatedAt}"
    }

    @GetMapping("/com_code_group_history/list")
    fun fetchComCodeGroupHistory(): String = transaction(database) {
        return@transaction "[ " + comCodeGroupHistoryRepository.findAll()
                .joinToString { "code_group_id:, code_validity_start_date:${it.validityStartDate}, code_validity_end_date:${it.validityEndDate}, <br>" +
                        "bfchg_code_group_name:${it.bfchgCodeGroupName}, aftch_code_group_name:${it.aftchCodeGroupName}, <br>" +
                        "created_at:${it.createdAt}, updated_at:${it.updatedAt} ] <br>" }
    }

    @GetMapping("/com_code_group_history/each")
    fun fetchComCodeGroupHistory(@RequestParam id: String): String = transaction(database) {
        val result = comCodeGroupHistoryRepository.findOne(id)
        return@transaction "{ code_group_id:${id}, code_validity_start_date:${result?.validityStartDate}, code_validity_end_date:${result?.validityEndDate}, <br>" +
                "bfchg_code_group_name:${result?.bfchgCodeGroupName}, aftch_code_group_name:${result?.aftchCodeGroupName}, <br>" +
                "created_at:${result?.createdAt}, updated_at:${result?.updatedAt} }"
    }

}
