package kr.socar.code101.codebook.controller

import kr.socar.code101.codebook.model.ComCode
import kr.socar.code101.codebook.model.ComCodeGroup
import kr.socar.code101.codebook.model.ComCodeGroupHistory
import kr.socar.code101.codebook.model.ComCodeInfo
import kr.socar.code101.codebook.repository.ComCodeGroupHistoryRepository
import kr.socar.code101.codebook.repository.ComCodeGroupRepository
import kr.socar.code101.codebook.repository.ComCodeInfoRepository
import kr.socar.code101.codebook.repository.ComCodeRepository
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Op
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.web.bind.annotation.*
import java.rmi.activation.ActivationGroupID
import java.time.LocalDateTime

@RestController
class CodeAdminController(
    private val ComCodeInfoRepository: ComCodeInfoRepository,
    private val ComCodeRepository: ComCodeRepository,
    private val comCodeGroupRepository: ComCodeGroupRepository,
    private val comCodeGroupHistoryRepository: ComCodeGroupHistoryRepository,
    private val database: Database
) {

    //ComCodeInfo
    //Create
    @PostMapping("/com_code_info/new")
    fun createNewComCodeInfo(
        @RequestBody codeName: String, description: String?
    ) : ComCodeInfo = transaction {
        return@transaction ComCodeInfoRepository.insert(codeName, description)
    }


/*    @GetMapping("/com_code_info/new")
    fun createNewComCodeInfo(
        @RequestParam("code_name") codeName: String,
        @RequestParam("description") description: String?
    ): String = transaction(database) {
        val r = ComCodeInfoRepository.insert(codeName, description)
        return@transaction """{"code_id":${r.id.value}, "code_name":${r.codeName}, "description":${r.description}, "created":${r.createdAt} }"""
    }*/

    //Read > all
    @GetMapping("/com_code_info/list")
    fun fetchComCodeInfo(): String = transaction(database) {
        return@transaction "[ " + ComCodeInfoRepository.findAll()
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
        return@transaction ComCodeInfoRepository.findOne(id)
    }

/*
    @GetMapping("/com_code_info/update")
    fun modifyComCodeInfo(
        @RequestParam id: Int,
        @RequestParam description: String?
    ): String? = transaction(database) {
        return@transaction ComCodeInfoRepository.update(id, description)
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

/*    @GetMapping("/comCodeGroupInsert")
    fun comCodeGroup(
        @RequestParam("id") id: String,
        @RequestParam("name") codeGroupName: String
    ): String = transaction(database) {
        val result = comCodeGroupRepository.insert(id, codeGroupName)
        return@transaction "id: ${result.id.value}, name: ${result.codeGroupName}, created: ${result.createdAt}"
    }*/


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

    // Read > all
    @GetMapping("com_code_group_History/list")
    fun fetchComCodeGroupHistory(): Any = transaction(database) {
        return@transaction comCodeGroupHistoryRepository.findAll()
    }

    //ComCode
    //Create
    @PostMapping("/com_code/new")
    fun createNewComCode(
        @RequestBody codeGroupID: String, id: Int, useYN: Boolean, sortingNum: Int
    ): Unit = transaction(database) {
        return@transaction ComCodeRepository.insert(codeGroupID, codeId = id, useYN = useYN, sortingNum = sortingNum )
    }

    //Read
    @GetMapping("/com_code/findAll")
    fun fetchComCode(): String = transaction(database) {
        return@transaction "[ " + ComCodeRepository.findAll()
            .joinToString { "{ codeGroupId: ${it.codeGroupId}, code_id:${it.codeId}, useYN: ${it.useYN}, sortingNum: ${it.sortingNum}, created:${it.createdAt}, updated:${it.updatedAt} } <br>".trimMargin() } + " ]"
    }

}