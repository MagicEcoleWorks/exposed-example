package kr.socar.code101.codebook.controller

import kr.socar.code101.codebook.model.ComCodeGroupHistory
import kr.socar.code101.codebook.repository.ComCodeGroupHistoryRepository
import kr.socar.code101.codebook.repository.ComCodeGroupRepository
import kr.socar.code101.codebook.repository.ComCodeInfoRepository
import kr.socar.code101.codebook.repository.ComCodeRepository
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CodeAdminController(
    private val ComCodeInfoRepository: ComCodeInfoRepository,
    private val ComCodeRepository: ComCodeRepository,
    private val comCodeGroupRepository: ComCodeGroupRepository,
    private val comCodeGroupHistoryRepository: ComCodeGroupHistoryRepository,
    private val database: Database
) {
    //com_code_info CRU
    @GetMapping("/com_code_info/new") //C
    fun createNewComCodeInfo(
        @RequestParam("code_name") codeName: String,
        @RequestParam("description") description: String?
    ): String = transaction(database) {
        val r = ComCodeInfoRepository.insert(codeName, description)
        return@transaction """{"code_id":${r.id.value}, "code_name":${r.codeName}, "description":${r.description}, "created":${r.createdAt} }"""
    }

    @GetMapping("/com_code_info/list") //R - all
    fun fetchComCodeInfo(): String = transaction(database) {
        return@transaction "[ " + ComCodeInfoRepository.findAll()
            .joinToString { "{ code_id:${it.id.value}, code_name:${it.codeName}, description:${it.description}, created:${it.createdAt}, updated:${it.updatedAt} } <br>".trimMargin() } + " ]"
    }

    @GetMapping("/com_code_info/each") //R
    fun fetchComCodeInfo(@RequestParam id: Int): String? = transaction(database) {
        return@transaction ComCodeInfoRepository.findOne(id)
    }

    @GetMapping("/com_code_info/update") //U
    fun modifyComCodeInfo(
        @RequestParam id: Int,
        @RequestParam description: String?
    ): String? = transaction(database) {
        return@transaction ComCodeInfoRepository.update(id, description)
    }

//
//    //com_code_group_history CR
//    @GetMapping("/com_code_group_history/new")  //C
//    fun createNewComCodeGroupHistory(
//        @RequestParam("id") id: String,
//        @RequestParam("name") codeGroupName: String
//    ): String = transaction(database) {
//        val r = comCodeGroupHistoryRepository.insert(id, codeGroupName)
//        return@transaction "code_group_id:${r.id}, code_validity_start_date:${r.validityStartDate}, code_validity_end_date:${r.validityEndDate}, <br>" +
//            "bfchg_code_group_name:${r.bfchgCodeGroupName}, aftch_code_group_name:${r.aftchCodeGroupName}, <br>" +
//            "created_at:${r.createdAt}, updated_at:${r.updatedAt}"
//    }

//    @GetMapping("/com_code_group_history/list") // R - all
//    fun fetchComCodeGroupHistory(): String = transaction(database) {
//        return@transaction "[ " + comCodeGroupHistoryRepository.findAll()
//                .joinToString {
//                    // 수정필요
//                    "code_group_id:${it.id.value}, code_validity_start_date:${it.validityStartDate}, code_validity_end_date:${it.validityEndDate}, <br>" +
//                    "bfchg_code_group_name:${it.bfchgCodeGroupName}, aftch_code_group_name:${it.aftchCodeGroupName}, <br>" +
//                    "created_at:${it.createdAt}, updated_at:${it.updatedAt} ] <br>"
//            }
//    }

//    @GetMapping("/com_code_group_history/each")     // R
//    fun fetchComCodeGroupHistory(@RequestParam id : String) : ComCodeGroupHistory? = transaction(database) {
//        return@transaction comCodeGroupHistoryRepository.findOne(id)
//    }


//    @GetMapping("/com_code_group_history/update")     // U
//    fun modifyComCodeGroupHistory(
//            @RequestParam id: String,
//            @RequestParam codeGroupName: String
//    ): String = transaction(database){
//        val result = comCodeGroupHistoryRepository.update(id, codeGroupName)
//        return@transaction if (result > 0) {
//            "success: $result"
//        } else {
//            "fail: $result"
//        }
//    }

    //com_code_group CRUD
    @GetMapping("/comCodeGroupFind")  //R - all
    fun comCodeGroupFind(): String = transaction(database) {
        val result = comCodeGroupRepository.findAll()
        return@transaction result.joinToString { comCodeGroup -> "id: ${comCodeGroup.id.value}, name: ${comCodeGroup.codeGroupName} </br>" }
    }

    @GetMapping("/comCodeGroupInsert") //C
    fun comCodeGroup(
        @RequestParam("id") id: String,
        @RequestParam("name") codeGroupName: String
    ): String = transaction(database) {
        val result = comCodeGroupRepository.insert(id, codeGroupName)
        return@transaction "id: ${result.id.value}, name: ${result.codeGroupName}, created: ${result.createdAt}"
    }


//    //com_code CRD
//    @GetMapping("/com_code/findAll") //R - all
//    fun fetchComCode(): String = transaction(database) {
//        return@transaction "[ " + ComCodeRepository.findAll()
//            .joinToString { "{ codeGroupId: ${it.codeGroupId}, code_id:${it.id.value}, useYN: ${it.useYN}, sortingNum: ${it.sortingNum}, created:${it.createdAt}, updated:${it.updatedAt} } <br>".trimMargin() } + " ]"
//    }
//
//    @GetMapping("/com_code/new") // C
//    fun createNewComCode(
//        @RequestParam codeGroupId: String,
//        @RequestParam codeId: Int,
//        @RequestParam useYN: Int,
//        @RequestParam sortingNum: Int
//    ): String = transaction(database) {
//        val result = ComCodeRepository.insert(codeGroupId, codeId, useYN, sortingNum)
//        return@transaction "codeGroupId: ${result.codeGroupId}, code_id:${result.id.value}, useYN: ${result.useYN}, sortingNum: ${result.sortingNum}, created:${result.createdAt}, updated:${result.updatedAt}"
//    }

//    @GetMapping("/com_code/delete") // D
//    fun deleteComCode(
//        @RequestParam codeGroupId: String,
//        @RequestParam codeId: Int
//    ): String = transaction(database) {
//        return@transaction "[ " + ComCodeRepository.delete(codeGroupId, codeId)
//            .joinToString { "{ codeGroupId: ${it.codeGroupId}, code_id:${it.codeId}, useYN: ${it.useYN}, sortingNum: ${it.sortingNum}, created:${it.createdAt}, updated:${it.updatedAt} } <br>".trimMargin() } + " ]"
//    }

}
