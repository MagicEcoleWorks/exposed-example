package kr.socar.code101.codebook.controller

import kr.socar.code101.codebook.model.ComCode
import kr.socar.code101.codebook.model.ComCodeGroup
import kr.socar.code101.codebook.model.ComCodeGroupHistory
import kr.socar.code101.codebook.model.ComCodeInfo
import kr.socar.code101.codebook.vo.ComCodeInfoVo
import kr.socar.code101.codebook.repository.ComCodeGroupHistoryRepository
import kr.socar.code101.codebook.repository.ComCodeGroupRepository
import kr.socar.code101.codebook.repository.ComCodeInfoRepository
import kr.socar.code101.codebook.repository.ComCodeRepository
import kr.socar.code101.codebook.vo.ComCodeGroupHistoryVo
import kr.socar.code101.codebook.vo.ComCodeGroupVo
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Op
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
class CodeAdminController(
        private val comCodeInfoRepository: ComCodeInfoRepository,
        private val comCodeRepository: ComCodeRepository,
        private val comCodeGroupRepository: ComCodeGroupRepository,
        private val comCodeGroupHistoryRepository: ComCodeGroupHistoryRepository,
        private val database: Database
) {
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

    // JSON encoding error > jackson
/*    @GetMapping("/com_code_info/list")
    fun fetchComCodeInfo(): List<ComCodeInfo> = transaction(database) {
        return@transaction  ComCodeInfoRepository.findAll()
    }*/

    // Read > One
    @GetMapping("/com_code_info/each")
    fun fetchComCodeInfo(@RequestParam id: Int): String? = transaction(database) {
        val result = comCodeInfoRepository.findOne(id)
        return@transaction "{code_id: " + id + ", code_name:${result?.codeName}, description:${result?.description}, " +
                           "created:${result?.createdAt}, updated:${result?.updatedAt}}"
    }

/*
    @GetMapping("/com_code_info/update")
    fun modifyComCodeInfo(
        @RequestParam id: Int,
        @RequestParam description: String?
    ): ComCodeInfo? = transaction(database) {
        return@transaction comCodeInfoRepository.update(id, description)
    }
*/

    //ComCodeGroup
    //Create
    @PostMapping("/com_code_group/new")
    fun createNewComCodeGroup(
       @RequestBody codeGroupID: String, codeGroupName: String
    ): ComCodeGroup = transaction(database) {
        return@transaction comCodeGroupRepository.insert(id, codeGroupName)
    }

    //Read > all
    @GetMapping("/com_code_group/list")
    fun fetchComCodeGroup(): String = transaction(database) {
        val result = comCodeGroupRepository.findAll()
        return@transaction result.joinToString { comCodeGroup -> "id: ${comCodeGroup.id.value}, name: ${comCodeGroup.codeGroupName} </br>" }
    }


   //Read > One
    @GetMapping("/com_code_group/each")
    fun fetchComCodeGroup(@RequestParam id: String): String? = transaction(database) {
        return@transaction ComCodeGroupRepository.findOne(id)
   }

    //ComCodeGroupHistory
    //Create
    @PostMapping("/com_code_group_History/new")
    fun createNewComCodeGroupHistory(
        @RequestBody codeGroupID: String, codeGroupName: String
    ) : Unit = transaction(database) {
        return@transaction comCodeGroupHistoryRepository.insert(codeGroupID,codeGroupName)
    }

    @GetMapping("com_code_group_History/list")
    fun fetchComCodeGroupHistory(): Any = transaction(database) {
        return@transaction comCodeGroupHistoryRepository.findAll()
    }

    @PostMapping("/com_code/new")
    fun createNewComCode(
        @RequestBody codeGroupID: String, id: Int, useYN: Boolean, sortingNum: Int
    ): Unit = transaction(database) {
        return@transaction ComCodeRepository.insert(codeGroupID, codeId = id, useYN = useYN, sortingNum = sortingNum )
    }

    @GetMapping("/com_code/findAll")
    fun fetchComCode(): String = transaction(database) {
        return@transaction "[ " + comCodeRepository.findAll()
            .joinToString { "{ codeGroupId: ${it.codeGroupId}, code_id:${it.codeId}, useYN: ${it.useYN}, sortingNum: ${it.sortingNum}, created:${it.createdAt}, updated:${it.updatedAt} } <br>".trimMargin() } + " ]"
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
