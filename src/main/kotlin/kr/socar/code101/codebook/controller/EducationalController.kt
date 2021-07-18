package kr.socar.code101.codebook.controller

import kr.socar.code101.codebook.dto.InsertComCodeGroupHistoryParams
import kr.socar.code101.codebook.dto.Result
import kr.socar.code101.codebook.model.ComCodeGroupHistoryEntity
import kr.socar.code101.codebook.repository.ComCodeRepository
import kr.socar.code101.codebook.service.ComCodeGroupHistoryService
import kr.socar.code101.codebook.service.ComCodeGroupService
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.web.bind.annotation.*

@Deprecated("")
@RestController
class EducationalController(
    private val comCodeGroupHistoryService: ComCodeGroupHistoryService,
    private val comCodeRepository: ComCodeRepository,
    private val comCodeGroupService: ComCodeGroupService,
    private val database: Database
) {
    @PostMapping("/com_code_group_history/insert")
    fun insertComCodeGroupHistory(
            @RequestBody insertComCodeGroupHistoryParams: InsertComCodeGroupHistoryParams
    ): Result {
        println(insertComCodeGroupHistoryParams)
        println(insertComCodeGroupHistoryParams.name)
        println(insertComCodeGroupHistoryParams.id)
        //return comCodeGroupHistoryService.createComCodeGroupHistory(id)
        return Result.SUCCESS
    }

    @GetMapping("/com_code_group_history/find") // R - all 임시
    fun findComCodeGroupHistory() : List<ComCodeGroupHistoryEntity> {
        return comCodeGroupHistoryService.findComCodeGroupHistory()
    }

     @GetMapping("/com_code_group_history/each") //R
     fun findEachComCodeGroupHistory(
             @RequestParam id : String
     ) : ComCodeGroupHistoryEntity {
         return comCodeGroupHistoryService.findEachComCodeGroupHistory(id)
     }

    @PostMapping("/com_code/new")
    fun createNewComCode(
        @RequestBody codeGroupID: String, id: Int, useYN: Boolean, sortingNum: Int
    ): Unit = transaction(database) {
        return@transaction comCodeRepository.insert(codeGroupID, codeId = id, useYN = useYN, sortingNum = sortingNum )
    }
}
