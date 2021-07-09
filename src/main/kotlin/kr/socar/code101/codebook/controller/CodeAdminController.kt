package kr.socar.code101.codebook.controller

import kr.socar.code101.codebook.repository.ComCodeGroupRepository
import kr.socar.code101.codebook.repository.ComCodeInfoRepository
import kr.socar.code101.codebook.repository.ComCodeRepository
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CodeAdminController(
    private val ComCodeInfoRepository: ComCodeInfoRepository,
    private val ComCodeRepository : ComCodeRepository,
    private val comCodeGroupRepository : ComCodeGroupRepository,
    private val database: Database
) {
    //com_code_info CRU
    @GetMapping("/com_code_info/new")
    fun createNewComCodeInfo(
        @RequestParam("code_name") codeName: String,
        @RequestParam("description") description: String?
    ): String = transaction(database) {
        val r = ComCodeInfoRepository.insert(codeName, description)
        return@transaction """{"code_id":${r.id.value}, "code_name":${r.codeName}, "description":${r.description}, "created":${r.createdAt} }"""
    }

    @GetMapping("/com_code_info/list")
    fun fetchComCodeInfo(): String = transaction(database) {
        return@transaction "[ " + ComCodeInfoRepository.findAll()
            .joinToString { "{ code_id:${it.id.value}, code_name:${it.codeName}, description:${it.description}, created:${it.createdAt}, updated:${it.updatedAt} } <br>".trimMargin() } + " ]"
    }

    @GetMapping("/com_code_info/each")
    fun fetchComCodeInfo(@RequestParam id: Int): String? = transaction(database) {
        return@transaction ComCodeInfoRepository.findOne(id)
    }

    @GetMapping("/com_code_info/update")
    fun modifyComCodeInfo(
        @RequestParam id: Int,
        @RequestParam description: String?
    ): String? = transaction(database) {
        return@transaction ComCodeInfoRepository.update(id, description)
    }

    //com_code_group CRUD
    @GetMapping("/comCodeGroupFind")
    fun comCodeGroupFind() : String = transaction(database) {
        val result = comCodeGroupRepository.findAll()
        return@transaction result.joinToString { comCodeGroup -> "id: ${comCodeGroup.id.value}, name: ${comCodeGroup.codeGroupName} </br>" }
    }

    @GetMapping("/comCodeGroupInsert")
    fun comCodeGroup(
        @RequestParam("id") id : String,
        @RequestParam("name") codeGroupName: String
    ): String = transaction(database) {
        val result = comCodeGroupRepository.insert(id, codeGroupName)
        return@transaction "id: ${result.id.value}, name: ${result.codeGroupName}, created: ${result.createdAt}"
    }

    @GetMapping("/com_code_group/each")
    fun fetchComCodeGroupInfo(@RequestParam id: Int): String {
        return """{...}"""
    }


    //com_code CRD
    @GetMapping("/com_code/findAll")
    fun fetchComCode() : String = transaction(database) {
        return@transaction "[ " + ComCodeRepository.findAll()
            .joinToString { "{ codeGroupID: ${it.codeGroupID}, code_id:${it.id.value}, useYN: ${it.useYN}, sortingNum: ${it.sortingNum}, created:${it.createdAt}, updated:${it.updatedAt} } <br>".trimMargin() } + " ]"
    }

    @GetMapping("/com_code/new")
    fun createNewComCode(
        @RequestParam codeGroupId: String,
        @RequestParam codeId: Int,
        @RequestParam useYN: Int,
        @RequestParam sortingNum: Int
    ) : String = transaction(database) {
            return
    }

    //com_code_group_history CR

}