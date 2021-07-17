package kr.socar.code101.codebook.controller

import kr.socar.code101.codebook.dto.InsertComCodeGroupHistoryParams
import kr.socar.code101.codebook.dto.InsertComCodeGroupParams
import kr.socar.code101.codebook.dto.Result
import kr.socar.code101.codebook.model.ComCodeGroupHistory
import kr.socar.code101.codebook.service.ComCodeGroupHistoryService
import kr.socar.code101.codebook.service.ComCodeGroupService
import org.springframework.web.bind.annotation.*

@RestController
class CodeAdminController(
    private val comCodeGroupHistoryService: ComCodeGroupHistoryService
    private val comCodeGroupService: ComCodeGroupService
) {
    // com_code_group_history CR
    @PostMapping("/com_code_group_history/insert")  //C
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
    fun findComCodeGroupHistory() : List<ComCodeGroupHistory> {
        return comCodeGroupHistoryService.findComCodeGroupHistory()
    }

     @GetMapping("/com_code_group_history/each") //R
     fun findEachComCodeGroupHistory(
             @RequestParam id : String
     ) : ComCodeGroupHistory {
         return comCodeGroupHistoryService.findEachComCodeGroupHistory(id)
     }


    // com_code_group CR
    @PostMapping("/com_code_group/insert")
    fun insertComCodeGroup(
            @RequestBody insertComCodeGroupParams : InsertComCodeGroupParams
    ) {
    }

}
